package com.example.camelmicroservicea.mongoroutes;

import com.mongodb.client.model.*;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.List;

//@Component
public class BulkWriteRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:BulkWriteDocument")
            .bean(BulkWriteMessage.class,"bulkWriteMessage")
            .log("Body : ${body}")
            .to("mongodb:mongo?database=taask&collection=message&operation=bulkWrite")
            .log("Found document by _id: ${body}");

        from("timer:Timer?delay=1000&repeatCount=1")
            .to("direct:BulkWriteDocument")
            .log("Found ..");
    }
}

//@Component
class BulkWriteMessage{
    public void bulkWriteMessage(Exchange exchange) {
        ObjectId objectId = new ObjectId("651bf047bd144e71040c916d");
        List<WriteModel<Document>> bulkOperations = Arrays.asList(
                new InsertOneModel<>(new Document("scientist", "Pratap")),
                new UpdateOneModel<>(new Document("_id", objectId),
                        new Document("$set", new Document("scientist", "Marie Curie"))),
                new DeleteOneModel<>(new Document("_id", "3")));
        exchange.getIn().setBody(bulkOperations);
    }
}
