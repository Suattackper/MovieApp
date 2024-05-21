const express = require("express");
const authController = require("../controller/auth.controller");
const accountJWT = require("../middleware/auth");
const route = express.Router();

// get account by id
route.get("/", accountJWT, authController.getAccount);

// POST - register
route.post("/registered", authController.registered);

// POST - login
route.post("/login", authController.login);

module.exports = route;
