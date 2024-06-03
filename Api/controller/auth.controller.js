const bodyParser = require("body-parser");
const express = require('express');
const AccountModel = require("../model/account.model");
const RefreshToken = require("../model/refresh_token.model");
const { generateAccessToken, generateRefreshToken } = require("../utils/jwt");
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");
const nodemailer = require('nodemailer');
const app = express();

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended:true}));
app.use(express.json());
app.use(express.urlencoded({ extended: true }));




// Function to send an email using Nodemailer
async function sendEmail(from, to, subject, text, html) {
  try {
    // Create a secure SMTP transporter for Gmail
    const transporter = nodemailer.createTransport({
      host: process.env.HOST,
      port: process.env.EMAIL_PORT,
      secure: false,
      auth: {
        user: 'thao16068@gmail.com', // Replace with your actual email address
        pass: 'vuas tnke hton mkrc' // Replace with your actual password (store securely)
      }
    });

    // Create the email options
    const mailOptions = {
      from: from,
      to: to,
      subject: subject,
      text: text, // Plain text content
      html: html // Optional HTML content
    };

    // Send the email
    const info = await transporter.sendMail(mailOptions);

    console.log("Email sent: " + info.response);
  } catch (error) {
    console.error("Error sending email:", error);
  }
}

// Function to handle forgot password request (assuming AccountModel is defined)
exports.forgotPass = async (req, res) => {
  try {
    const { email } = req.body; // Destructure email from request body

    // Check if email exists
    const existEmail = await AccountModel.findOne({ email });
    if (!existEmail) {
      return res.status(400).json({ code: 400, message: "Email not found" });
    }

    // Generate a random password reset token (implementation omitted)
    //const resetToken = generateRandomPasswordResetToken(); // Replace with your logic

    // Prepare email content (replace with appropriate placeholders)
    const subject = "Required Reset Password!";
    const text = `
      Hi ${email},

      You recently requested a password reset for your account.

      Click on the following link to reset your password:

     

      If you didn't request a password reset, please ignore this email.

      Sincerely,

      MoVie App
    `;

    // Send the password reset email
    await sendEmail('Movie App', 'tranthao28062003@gmail.com', subject, text, ''); // No HTML needed

    res.status(200).json({ code: 200, message: "Password reset email sent" });
  } catch (error) {
    console.error("Error processing forgot password request:", error);
    res.status(500).json({ code: 500, message: "Internal server error" });
  }
};


// register
exports.registered = async (req, res) => {
  try {
    const { email, phone, password } = req.body;

    // checking if it already exists in db
    const existAccount = await AccountModel.findOne({ email });
    const existPhone = await AccountModel.findOne({phone});

    if (existAccount) {
      return res.status(400).json({ code:400, message: "Email address already exists" });
    }

    if(existPhone){
      return res.status(400).json({ code:400, message: "Phone address already exists" });

    }

    // hash
    const salt = await bcrypt.genSalt(10);
    const hash = await bcrypt.hash(password, salt);

    // create new account
    const newAccount = await new AccountModel({
      email,
      phone,
      password: hash,
    });

    const account = await newAccount.save();

    // res.status(200).json({ success: true, message: "Create successfully", account: account });
    res.status(200).json({ success: true ,code:200, message: "Create successfully" });
  } catch (error) {
    console.log(error.message);
    res.status(500).json({ code:500, message: error.message });
  }
};

// login
  exports.login = async (req, res) => {
    try {
      // const account = await AccountModel.findOne({ email: req.body.email });
      const {email,password} = req.body;
      const account = await AccountModel.findOne({ email: req.body.email });
      

      // check email if it exists
      if (!account) {
      return res.status(404).json({code: 404, message:"Invalid email! Please enter again"});
      }

      const validPassword = await bcrypt.compare(req.body.password, account.password);

      if (!validPassword) {
      return  res.status(404).json({  code:404, message: "Invalid password! Please enter again" });
      }

      // login success
      if (account && validPassword) {
        
        // kiem tra refreshToken hien co
        let existingRefreshToken = await RefreshToken.findOne({account_id: account.id});

        // Tái sử dụng refreshToken nếu có
        let refreshToken = existingRefreshToken ? existingRefreshToken.token : generateRefreshToken(account);

        if(!existingRefreshToken) {
          await RefreshToken.create({token: refreshToken, account_id: account.id});
        }

        const accessToken = generateAccessToken(account);
        const {password, ...others} = account._doc;

      return res.status(200).json({
          success: true,
          message: "Logged in successfully",
          code : 200,
          accessToken: accessToken,
          refreshToken: refreshToken,
          ...others,
        });
      }
    } catch (error) {
      console.log(error.message);
      res.status(500).json({
        success: false,
        code : 500,
        message: "Internal Server Error!!",
      });
    }
  };

// refresh token
exports.requestRefreshToken = async (req, res) => {

  const { refreshToken } = req.body;

  try {
    const refreshTokenDoc = await RefreshToken.findOne({ token: refreshToken });

    if (!refreshTokenDoc) {
      return res.status(403).json({ success: false, message: "Invalid refresh token or expired" });
    }

    jwt.verify(refreshToken, process.env.REFRESH_KEY, async (error, decoded) => {

      if (error) {
        const deleteResult = await RefreshToken.deleteOne({ token: refreshToken });

        if (deleteResult.deletedCount === 0) {
          console.warn("Refresh token not found for deletion:", refreshToken);
        }
        return res
          .status(403)
          .json({ success: false, message: "Invalid refresh token or expired" });
      }

      const account = await AccountModel.findById(decoded.account.id);

      if (!account) {
        return res.status(404).json({ success: false, message: "Cannot find any account" });
      }

      const newAccessToken = generateAccessToken(account);
      const newRefreshToken = generateRefreshToken(account);
      await RefreshToken.findByIdAndUpdate(refreshTokenDoc.id, { token: newRefreshToken });

      res.status(200).json({ accessToken: newAccessToken, refreshToken: newRefreshToken });
    });
  } catch (error) {
    console.log(error.message);

    res.status(500).json({ message: "Server error" });
  }
};

exports.getAccount = async (req, res) => {
  try {
    const accountId = req.params.id;

    const account = await AccountModel.findById(accountId);

    if (!account) {
      return res.status(404).json({ error: "Acount not found" });
    }

    res.status(200).json(account);
  } catch (error) {
    res.status(500).json(error);
  }
};
