package com.springbootkafka.com.springbootkafka.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class DataProducer {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @GetMapping("/user/{data}")
    public String produceData(@PathVariable("data") String data){
        kafkaTemplate.send("test",data);
        return "Data Published successfully" ;
    }
}
