'use strict'
const common = require('./common');
const Consumer = require('./consumer');

const campign = new Consumer('campaign');

(async function(){
    const collection = await common.getCollection('cart');
   try{
    const cusrsor = await collection.aggregate([{$changeStream:{fullDocument:'updateLookup'}}])

   while(await cusrsor.hasNext()){
       const doc = await cusrsor.next()
       campign.process(doc);
   }
} catch(err ){
    console.log(err.stack)
}



})()