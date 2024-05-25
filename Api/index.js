const express = require("express");
const cors = require("cors");
const app = express();
const mongoose = require("mongoose");
const morgan = require("morgan");
const helmet = require("helmet");
const body_parser = require("body-parser");

//khởi động server: npm run start

//CONNECT DATABASE

const db = require("./Api/db");
db.connectDB();

//mvc----------------------------------------------------------------
app.use(body_parser.json());
app.use(express.json());
app.use(helmet());
app.use(cors());
app.use(morgan("common"));

//movie app ----------------------------------------------------------------
const WatchListRoute = require("./Api/routes/watchlist");
app.use("/watchlist",WatchListRoute);

app.listen(3000, () => {
    console.log("Server is running http://localhost:3000");
});
