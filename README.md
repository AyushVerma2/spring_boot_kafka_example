### For Producer Example
 kafka producer demo using spring boot
##### Download kafka from : https://www.apache.org/dyn/closer.cgi?path=/kafka/2.4.0/kafka_2.12-2.4.0.tgz

##### tar -xzf kafka_2.12-2.4.0.tgz
##### cd kafka_2.12-2.4.0
### Start servers(Zookeeper+Kafka+Brokers+Consumers):
Kafka uses ZooKeeper so you need to first start a ZooKeeper server if you don't already have one. 
You can use the convenience script packaged with kafka to get a quick-and-dirty single-node ZooKeeper instance.

> bin/zookeeper-server-start.sh config/zookeeper.properties

### Now start the Kafka server:
> bin/kafka-server-start.sh config/server.properties

### Crete topic with name test
Let's create a topic named "test" with a single partition and only one replica:
> bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test

### Start consumer
> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning


### run the spring boot applicaiton:
>test on broser "http://localhost:8080/user/testing" , 
>you will see in consumer termial testing will be printed.


## For word count example:
 1. Start Kafka server(> bin/zookeeper-server-start.sh config/zookeeper.properties)
 2.Prepare input topic and start producer
   To Create topic "streams-plaintext-input":
    > bin/kafka-topics.sh --create \
    --bootstrap-server localhost:9092 \
    --replication-factor 1 \
    --partitions 1 \
    --topic streams-wordcount-input \
    --config cleanup.policy=compact
    
   To Creete output topic:
    > bin/kafka-topics.sh --create \
    --bootstrap-server localhost:9092 \
    --replication-factor 1 \
    --partitions 1 \
    --topic streams-wordcount-output \
    --config cleanup.policy=compact
    
   ### created topic can be described with the same kafka-topics tool:
   > bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe
   
   ### 
#### Start producer:
 > bin/kafka-console-producer.sh --broker-list localhost:9092 --topic streams-plaintext-input
#### Start Consumer:
  bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 \
    --topic streams-wordcount-output \
    --from-beginning \
    --formatter kafka.tools.DefaultMessageFormatter \
    --property print.key=true \
    --property print.value=true \
    --property key.deserializer=org.apache.kafka.common.serialization.StringDeserializer \
    --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
    
  #### Start starts the WordCount demo application
  
  #### Now let's write some message with the console producer into the input topic streams-plaintext-input by entering a single line of text and then hit <RETURN>. This will send a new message to the input topic, where the message key is null and the message value is the string encoded text line that you just entered (in practice, input data for applications will typically be streaming continuously into Kafka, rather than being manually entered as we do in this quickstart):
1
2
> bin/kafka-console-producer.sh --broker-list localhost:9092 --topic streams-plaintext-input
all streams lead to kafka
 
 
#### References:
https://kafka.apache.org/quickstart

https://kafka.apache.org/24/documentation/streams/quickstart
