const AccountModel = require("../model/account.model");
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");
const { token } = require("morgan");

// register
exports.registered = async (req, res) => {
  try {
    const { email, phone, password } = req.body;

    // checking if it already exists in db
    const existingEmail = await AccountModel.findOne({ email });
    const existingPhone = await AccountModel.findOne({ phone });

    if (existingEmail || existingPhone) {
      return res.status(400).json({ msg: "Email or Phone number already exists" });
    }

    // hash
    const salt = await bcrypt.genSalt(10);
    const hash = await bcrypt.hash(password, salt);

    let account = new AccountModel({
      email,
      phone,
      password: hash,
    });

    account = await account.save();

    const payload = {
      id: account._id,
    };

    jwt.sign(payload, process.env.SECRET_KEY, { expiresIn: "1h" }, (error, token) => {
      if (error) {
        throw error;
      }
      res.status(200).json({ success: true, token: token});
    });
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
};

// login
exports.login = async (req, res) => {
  try {
    const account = await AccountModel.findOne({ email: req.body.email });

    // check email if it exists
    if (!account) {
      res.status(404).json("Invalid email! Please enter again");
    }

    const validPassword = await bcrypt.compare(req.body.password, account.password);

    if (!validPassword) {
      res.status(404).json("Invalid password! Please enter again");
    }

    // login success and create token
    if (account && validPassword) {
      const payload = {
        account: {
          id: account._id,
        },
      };

      jwt.sign(payload, process.env.SECRET_KEY, { expiresIn: "1h" }, (error, token) => {
        if (error) {
          throw error;
        }

        //destructuring
        const {password, ...others} = account._doc;

        res.status(200).json({
          success: true,
          message: "Account logged in successfully",
          token: token,
          account: {...others},
        });
      });
    }
  } catch (error) {
    console.log(error.message);
    res.status(500).json({
      success: false,
      message: "Internal Server Error!!",
    });
  }
};

// get account by id
exports.getAccount = async (req, res) => {
  try {

    const account = await AccountModel.findById(req.account.id).select("-password");
            res.status(200).json({
                success: true,
                account: account,
            });
    
  } catch (error) {
    console.log(error.message);
    res.status(500).json({
      success: false,
      message: "Server Error",
    });
  }
};
