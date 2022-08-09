import { Kafka } from "kafkajs";

const kafka = new Kafka({
    clientId:'employee-service',
    brokers:['localhost:9092'] // if you use AWS you need to put it here.............
})

const producer = kafka.producer();

const publish = async () =>{
    await producer
        .connect()
        .catch((e) => console.log('error on connection to kafka',e));

    for(let i = 0; i < 10; i++){
        await producer.send({
            topic: 'employee-topic',
            messages: [
                {key:"emp001", value: JSON.stringify({empName: 'Nairobi'+i})},    
            ],
        });
    }

    };
    publish().catch((e) => console.error(e));