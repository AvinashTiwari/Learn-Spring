const mongoose = require("mongoose");
const Company = require("../models/Company");
const Taxi = require("../models/Taxi");

beforeAll(() => {
  mongoose.Promise = global.Promise;
  mongoose.connect("mongodb://localhost/taxi-aggregator", {
    useNewUrlParser: true,
    useCreateIndex: true,
  });
});

beforeEach(async () => {});
afterEach(async () => {
  await Company.deleteMany();
  await Taxi.deleteMany();
});

afterAll((done) => {
  mongoose.disconnect(done);
});

describe("Taxi test", () => {
  test("Reading SubDocument", async () => {
    let taxi = new Taxi();
    taxi.brand = "Toyota";
    taxi.model = "Yaris";
    taxi.year = 2020;
    taxi.owner = { name: "Driver 1", experience: 15 };
    taxi = await taxi.save();
    const readTaxi = await Taxi.findOne();
    expect(readTaxi.owner.name).toBe("Driver 1");
  });

  test("Populate References", async () => {
    let company = new Company();
    company.name = "First Company";
    company = await company.save();

    let taxi1 = new Taxi();
    taxi1.brand = "Toyota";
    taxi1.model = "Yaris";
    taxi1.year = 2020;
    taxi1.owner = { name: "Driver 1", experience: 15 };
    taxi1 = await taxi1.save();

    let taxi2 = new Taxi();
    taxi2.brand = "Beze";
    taxi2.model = "Class E";
    taxi2.year = 2020;
    taxi2.owner = { name: "Driver 7", experience: 7 };
    taxi2 = await taxi2.save();

    company.taxies = [taxi1.id, taxi2.id];
    company = await company.save();
    console.log(company);

    const readCompany = await Company.findById(company.id);

    console.log(readCompany.populate());

    //expect(readCompany.taxis[0].model).toBe("Yaris");
    //expect(readCompany.taxis[1].model).toBe("Class E");
  });
});
