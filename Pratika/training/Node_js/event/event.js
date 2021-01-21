const events=require('events');
const eventEmitter=new events.EventEmitter()

eventEmitter.on('myEvent',(x)=>{
    console.log("Myevent is triggered",x);

})

eventEmitter.emit('myEvent','First');