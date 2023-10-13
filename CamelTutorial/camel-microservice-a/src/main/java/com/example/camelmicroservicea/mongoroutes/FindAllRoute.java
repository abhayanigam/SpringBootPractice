package com.example.camelmicroservicea.mongoroutes;
import com.mongodb.client.model.Filters;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mongodb.MongoDbConstants;
import org.bson.conversions.Bson;

//@Component
public class FindAllRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:findDocumentAll")
            .bean(FindAllMessage.class,"findAllMessage")
            .log("Body : ${body}")
            .to("mongodb:mongo?database=taask&collection=message&operation=findAll")
            .log("Found document by _id: ${body}");

        from("timer:Timer?delay=1000&repeatCount=1")
            .to("direct:findDocumentAll")
            .log("Found ..");
    }
}

//@Component
class FindAllMessage{
    public void findAllMessage(Exchange exchange) {
        Bson filter = Filters.eq("activestatus", "Inactive");
//        ObjectId objectId = new ObjectId("651bf047bd144e71040c916d");
//        Bson filter = Filters.eq("_id" ,objectId);
        exchange.getIn().setHeader(MongoDbConstants.CRITERIA, true);
        exchange.getIn().setBody(filter);
    }
}
