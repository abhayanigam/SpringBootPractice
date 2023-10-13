package com.example.camelmicroservicea;

import com.example.camelmicroservicea.aggregatemessages.Aggregate_Route;
import com.example.camelmicroservicea.mongoroutes.FindByIdRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.bson.types.ObjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelMicroserviceAApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CamelMicroserviceAApplication.class, args);

		/*
		// For Step split and multiprocessing
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new StepSplitMulticast()); // Add your route here
		context.start();

		// Create a ProducerTemplate to send messages
		ProducerTemplate producerTemplate = context.createProducerTemplate();
		// Send a message to the "direct:start" route
		// For simple message
		producerTemplate.sendBody("direct:start", "Hello Abhaya !");

		// For step
//		producerTemplate.sendBody("direct:start", null);

		// For split
//		producerTemplate.sendBody("direct:start", "['a','b']");
//
		// For multiprocessing
//		producerTemplate.sendBody("direct:start", null);

		// Stop the Camel context
		context.stop();


		// Route Template
//		CamelContext context = new DefaultCamelContext();
//		context.addRoutes(new MyRouteTemplate());
//		context.start();
//
//		TemplatedRouteBuilder.builder(context, "MyRouteTemplate")
//				.parameter("routeId","direct:start")
//				.parameter("name", "one")
//				.parameter("logName", "Hello")
//				.add();
//
//		context.stop();
		
		
		// For AggregateRoute
//		CamelContext context = new DefaultCamelContext();
//		context.addRoutes(new Aggregate_Route());
//		context.start();
//		ProducerTemplate producerTemplate = context.createProducerTemplate();
//		for (int i = 1; i <= 5; i++) {
//		    // Send messages for Group A
//		    producerTemplate.sendBodyAndHeader("direct:start", "Message A" + i, "myHeader", "groupA");
//		    // Send messages for Group B
//		    producerTemplate.sendBodyAndHeader("direct:start", "Message B" + i, "myHeader", "groupB");
//		}
//		context.stop();
 
		 */

	}

}
