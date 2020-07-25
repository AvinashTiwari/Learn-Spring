const mongoose = require("mongoose");
const Company = require("../models/Company");

beforeAll(() => {
  mongoose.Promise = global.Promise;
  mongoose.connect("mongodb://localhost/taxi-aggregator", {
    useNewUrlParser: true,
    useCreateIndex: true,
  });
});

beforeEach(() => {});
afterEach(async () => {
  await Company.deleteMany();
});

afterAll((done) => {
  mongoose.disconnect(done);
});

describe("company test", () => {
  test("create company", async () => {
    let compnay = new Company();
    compnay.name = "First Company";
    compnay = await compnay.save();

    const count = await Company.countDocuments();
    expect(count).toBe(1);
  });
});
