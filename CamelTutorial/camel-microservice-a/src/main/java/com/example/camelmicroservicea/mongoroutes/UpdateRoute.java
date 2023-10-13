package com.example.camelmicroservicea.mongoroutes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mongodb.MongoDbConstants;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;
import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;

//@Component
public class UpdateRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("direct:updateMongo")
			.bean(UpdateMessage.class,"updateMessage")
				.log("Body : ${body}")
	        .to("mongodb:mongo?database=taask&collection=message&operation=update")
	        .log("Updated ...");

	    from("timer:updateTimer?delay=1000&repeatCount=1")
	        .to("direct:updateMongo")
	        .log("Updating ..");
		
	}

}

//@Component
class UpdateMessage{
	public void updateMessage(Exchange exchange) {
	    Map<String, Object> headers = exchange.getIn().getHeaders();
		String newMessage = "New message for active record";

		List<Bson> bodyList = new ArrayList<>();
		Bson filter = Filters.eq("activestatus", "delete");
		bodyList.add(filter);

		BasicDBObject updateFields = new BasicDBObject();
		updateFields.append("message", new BsonString(newMessage));
		BsonDocument updateObj = new BsonDocument().append("$set", updateFields.toBsonDocument());
		bodyList.add(updateObj);

		exchange.getIn().setHeader(MongoDbConstants.MULTIUPDATE, true);
		exchange.getIn().setHeader(MongoDbConstants.UPSERT, true);

		// Set the headers back to the exchange
		exchange.getIn().setBody(bodyList);
	}
}