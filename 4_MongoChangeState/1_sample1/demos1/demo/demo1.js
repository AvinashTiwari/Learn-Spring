'use strict'
const common = require('./common');

(async function(){
    const collection = await common.getCollection('demo1');
   try{
    const cusrsor = await collection.aggregate([{$changeStream:{}}])

   while(await cusrsor.hasNext()){
       const doc = await cusrsor.next()
       common.prettyDoc(doc);
   }
} catch(err ){
    console.log(err.stack)
}



})()