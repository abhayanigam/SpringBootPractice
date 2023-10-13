package com.example.camelmicroservicea.aggregatemessages;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

public class AggregateMessages implements AggregationStrategy{
	
	private static final String SEPARATOR = System.getProperty( "line.separator" );

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if(oldExchange == null) {
			return newExchange;
		}
		String oldBody = oldExchange.getIn().getBody(String.class);
		String newBody = newExchange.getIn().getBody(String.class);
		oldExchange.getIn().setBody(oldBody+SEPARATOR+ newBody);
		return oldExchange;
		
	}

}