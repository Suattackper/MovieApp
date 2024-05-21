const express = require("express");
const dotenv = require("dotenv");

const body_parser = require("body-parser");
const mongoose = require("mongoose");
const authRoute = require("./routes/auth.route");


const app = express();
app.use(body_parser.json());
app.use(express.json());
dotenv.config();
 
// route -  authentication
app.use("/api", authRoute);



const PORT = process.env.PORT || 3000;
// connect db
mongoose
  .connect(process.env.MONGO_URL)
  .then(() => {
    console.log("Database is connected");
  })
  .catch((error) => console.log(error));

app.listen(PORT, () => {
  console.log("Server is running");
});
