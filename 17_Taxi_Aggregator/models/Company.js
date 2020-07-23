const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const CompanySchema = new Schema({
  name: { type: String, require: true },
});

module.exports = mongoose.model("company", CompanySchema);
