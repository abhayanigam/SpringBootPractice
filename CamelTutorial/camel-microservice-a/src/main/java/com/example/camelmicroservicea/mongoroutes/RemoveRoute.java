package com.example.camelmicroservicea.mongoroutes;

import com.mongodb.client.model.Filters;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;

//@Component
public class RemoveRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:findDocumentRemove")
            .bean(RemoveMessage.class,"removeMessage")
            .log("Body : ${body}")
            .to("mongodb:mongo?database=taask&collection=message&operation=remove")
            .log("Found document by _id: ${body}");

        from("timer:Timer?delay=1000&repeatCount=1")
            .to("direct:findDocumentRemove")
            .log("Found ..");
    }
}

//@Component
class RemoveMessage{
    public void removeMessage(Exchange exchange) {
        Bson filter = Filters.eq("activestatus", "delete");
//        ObjectId objectId = new ObjectId("651bf047bd144e71040c916d");
//        Bson filter = Filters.eq("_id" ,objectId);
        exchange.getIn().setBody(filter);
    }
}
