const mongoose = require("mongoose");

const watchlistSchema = new mongoose.Schema({
  name: {
    type: String
  },
  slug: {
    type: String,
  },
  thumbUrl: {
    type: String
  },
  accountid: {
    type: String,
  },
});

let WatchList = mongoose.model("WatchList", watchlistSchema);

module.exports = WatchList;
