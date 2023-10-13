package com.example.camelmicroservicea.activemq_and_routetemplate.ActiveMq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMqSenderRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        //timer
//        from("timer:active-mq-timer?timer=1000")
//                .transform().constant("My message for activemq")
//                .log("${body}")
//                .to("activemq:my-activemq-queue");
        //queue
        from("activemq:topic:ABHAYA?selector=(module='TEST' AND event='MYTEST' AND action='MYACTION')")
                .log("We Recieved Headers ===> ${headers}")
                .log("We Recieved Body ===> ${body}");

    }
}
