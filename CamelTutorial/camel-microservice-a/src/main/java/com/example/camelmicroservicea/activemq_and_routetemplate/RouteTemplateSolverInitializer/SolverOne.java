package com.example.camelmicroservicea.activemq_and_routetemplate.RouteTemplateSolverInitializer;

import org.apache.camel.builder.RouteBuilder;

import java.util.HashMap;

import org.apache.camel.Predicate;
import org.apache.camel.RouteTemplateContext;
import org.apache.camel.builder.PredicateBuilder;
import org.springframework.stereotype.Component;


@Component
public class SolverOne extends RouteBuilder {
    @Override
    public void configure() throws Exception {
    	
		// create a route template with the given name
		System.out.println("==========TEMPLATE REGISTERED==========");
		routeTemplate("Solver")
				// here we define the required input parameters (can have default values)
				.templateParameter("module")
				.templateParameter("allowedEvents")
				.templateParameter("message")
				
				
				.from("activemq:topic:ABHAYA?selector=(module='{{module}}')")
				.log("Entered...")
	          	.setHeader("allowedEvents", simple("{{allowedEvents}}"))
				.filter(header("allowedEvents").contains(header("event")))
				.setHeader("message", simple("{{message}}"))
				.choice()
				    .when(simple("${header.action} == 'AFTER'"))
				        .log("${headers.message} !!!")
				    .otherwise()
				        .log("Message not processed")
				.endChoice();
    }

}
