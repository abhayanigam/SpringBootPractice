package com.example.camelmicroservicea.aggregatemessages;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class Aggregate_Route extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start")
                .aggregate(header("myHeader"), new AggregateMessages())
                .completionTimeout(3000)
                .completionSize(10)
                .to("direct:b");
        from("direct:b")
                .choice()
                .when(header("myHeader").isEqualTo("groupA"))
                .log("Aggregated messages for Group A: ${body}")
                .otherwise()
                .log("Aggregated messages for Group B: ${body}");
    }
}
