const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const OwnerSchema = new Schema({
  name: { type: String, require: true },
  experience: { type: Number, require: true },
});

const TaxiSchema = new Schema({
  brand: { type: String, require: true },
  model: { type: String, require: true },
  year: { type: Number, require: true },
  Owner: OwnerSchema,
});

module.exports = mongoose.model("taxi", TaxiSchema);
