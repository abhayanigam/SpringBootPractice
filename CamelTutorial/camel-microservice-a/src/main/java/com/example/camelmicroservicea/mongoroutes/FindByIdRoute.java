package com.example.camelmicroservicea.mongoroutes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.bson.types.ObjectId;

//@Component
public class FindByIdRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:findDocumentById")
            .bean(FindByIdMessage.class,"findByIdMessage")
            .log("Body : ${body}")
            .to("mongodb:mongo?database=taask&collection=message&operation=findById")
            .log("Found document by _id: ${body}");

        from("timer:Timer?delay=1000&repeatCount=1")
            .to("direct:findDocumentById")
            .log("Found ..");
    }
}

//@Component
class FindByIdMessage{
    public void findByIdMessage(Exchange exchange) {
        ObjectId objectId = new ObjectId("651bf047bd144e71040c916d");
        exchange.getIn().setBody(objectId);
    }
}
