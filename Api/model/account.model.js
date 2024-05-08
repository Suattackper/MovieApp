const mongoose = require("mongoose");

const AccountSchema = new mongoose.Schema(
  {
    email: {
      type: String,
      unique: true,
      require: true
    },

    phone: {
      type: String,
      unique: true,
      require: true
    },

    password: {
      type: String,
      require: true,
    },
  },
  {timestamps: true}
);


const AccountModel = mongoose.model("account", AccountSchema);

module.exports = AccountModel;
