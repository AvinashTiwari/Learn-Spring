const mongoose = require("mongoose");
const Company = require("../models/Company");
let compnay;
beforeAll(() => {
  mongoose.Promise = global.Promise;
  mongoose.connect("mongodb://localhost/taxi-aggregator", {
    useNewUrlParser: true,
    useCreateIndex: true,
  });
});

beforeEach(async () => {
  compnay = new Company();
  compnay.name = "First Company";
  compnay = await compnay.save();
});
afterEach(async () => {
  await Company.deleteMany();
});

afterAll((done) => {
  mongoose.disconnect(done);
});

describe("company test", () => {
  test("create company", async () => {
    const count = await Company.countDocuments();
    expect(count).toBe(1);
  });

  test("read company", async () => {
    const readcompany = await Company.findById(compnay.id);
    expect(readcompany.name).toBe(compnay.name);
  });

  test("update company", async () => {
    await Company.updateOne({ _id: compnay.id }, { name: "Name modified" });
    const readcompany = await Company.findById(compnay.id);
    expect(readcompany.name).toBe("Name modified");
  });
});
