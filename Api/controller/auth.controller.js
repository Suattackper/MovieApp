const AccountModel = require("../model/account.model");
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");
const { token } = require("morgan");

// register
exports.registered = async (req, res) => {
  try {
    const { email, phone, password } = req.body;

    // checking if it already exists in db
    const existAccount = await AccountModel.findOne({ email });

    if (existAccount) {
      return res.status(400).json({ message: "Email address already exists" });
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

    res.status(200).json({ success: true, message: "Create successfully", account: account });
  } catch (error) {
    console.log(error.message);
    res.status(500).json({ error: error.message });
  }
};

// login
exports.login = async (req, res) => {
  try {
    const account = await AccountModel.findOne({ email: req.body.email });

    // check email if it exists
    if (!account) {
      return res.status(404).json("Invalid email! Please enter again");
    }

    const validPassword = await bcrypt.compare(req.body.password, account.password);

    if (!validPassword) {
      return res
        .status(401)
        .json({ success: false, message: "Invalid password! Please enter again" });
    }

    // login success
    if (account && validPassword) {
      const accessToken = generateAccessToken(account);
      const refreshToken = generateRefreshToken(account);

      await RefreshToken.create({ token: refreshToken, account_id: account.id });

      const { password, ...others } = account._doc;

      return res.status(200).json({
        success: true,
        message: "Logged in successfully",
        accessToken: accessToken,
        refreshToken: refreshToken,
        ...others,
      });
    }
  } catch (error) {
    console.log(error.message);
    return res.status(500).json({
      success: false,
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

      return res.status(200).json({ accessToken: newAccessToken, refreshToken: newRefreshToken });
    });
  } catch (error) {
    console.log(error.message);

    res.status(500).json({ message: "Server error" });
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
