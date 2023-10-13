package com.example.camelmicroservicea.mongoroutes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class InsertRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {	
		from("direct:insertMongo")
	        .bean(Body_Bean.class, "createBody")
	//      .setHeader("CamelMongoDbCollection", constant("message")) // Specify the collection
	//		.to("mongodb:mongo?database=taask&operation=insert")
	        .to("mongodb:mongo?database=taask&collection=message&operation=insert")
	        .log("Inserted ...");

	    from("timer:insertTimer?delay=1000&repeatCount=1")
	        .setBody(simple("Trigger insertMongo route"))
	        .log("Inserting ..")
	        .to("direct:insertMongo")
	        .log("Inserting Done ${body}")
	        .log("Header ${headers}");
	}

}

//@Component
class Body_Bean {
	public String createBody() {
        String body = "{\"activestatus\": \"Inactive\", \"name\": \"Ritu S\", \"message\": \"This is a sample message 2\" }";

        return body;
    }
}