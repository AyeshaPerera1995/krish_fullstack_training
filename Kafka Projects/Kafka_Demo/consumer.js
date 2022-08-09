import { Kafka } from "kafkajs";

const kafka = new Kafka({
    clientId:'employee-service',
    brokers:['localhost:9092'] 
})

const consumer = kafka.consumer({groupId:'project'});
await consumer.subscribe({topic: 'employee-topic',fromBeginning:true});

await consumer.run({
    eachMessage: async ({topic, partition, message}) => {
        console.log({
            partition,
            offset: message.offset,
            value: message.value.toString(),
        });
    },
});