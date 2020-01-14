### spring_boot_kafka_producer_example 
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

#### References:
https://kafka.apache.org/quickstart


