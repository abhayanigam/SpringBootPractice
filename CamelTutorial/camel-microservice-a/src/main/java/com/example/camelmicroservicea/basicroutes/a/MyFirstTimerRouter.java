package com.example.camelmicroservicea.basicroutes.a;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Component
public class MyFirstTimerRouter extends RouteBuilder {
//    @Autowired
//    private GetCurrentTimeBean getCurrentTimeBean;

    @Autowired
    private SimpleLoggingProcessingComponent simpleLoggingProcessingComponent;

    @Autowired
    private MyLogger myLogger;

    @Override
    public void configure() throws Exception {
        // queue -> timer
        // transformation
        // database -> log
        // Exchange [ExchangePattern: InOnly, BodyType: null, Body: [Body is null]]
        from("timer:first-timer?period=3s")
                .log("Before transform : ${body}")
                .transform().constant("picking the message from first-timer and transforming as a constant message")
                .log("Body : ${body}")
//                .transform().constant("TIme now is " + LocalDateTime.now())
//                .bean("getCurrentTimeBean") // instead of doing this use autowire
                .bean(GetCurrentTimeBean.class,"getCurrentTime") // when you have more than 1 method you can also mention here
                .log("After bean : ${body}")

        // Processing:
        // Once i receive a message i want to do some operation or something which does not make a change on the body of the message itself
        // Transformation:
        // However if you are doing anything that changes the body of the message then that is message then that is called a transformation
            .bean(simpleLoggingProcessingComponent)
            .process(new SimpleLoggingProcessor())
//                .process(exchange -> {
//                    myLogger.logInfo("Processing Message {} " + exchange.getIn().getBody(String.class));
//                })
            .to("log:first-timer");
    }
}

// Whenever spring is doing a component scan of this particular package is would find this component and
// what it would do is it would create a bean with name get current time
//@Component
class GetCurrentTimeBean{
    public String getCurrentTime(){
        return "Time now is " + LocalDateTime.now();
    }
}

//@Component
class SimpleLoggingProcessingComponent{
    private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
    public void process(String message){
        logger.info("SimpleLoggingProcessingComponent {}" + message);
    }
}

class SimpleLoggingProcessor implements Processor {
    private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessor.class);
    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("SimpleLoggingProcessor {}" + exchange.getMessage().getBody());
    }
}

//@Component
class MyLogger{

    private Logger logger = LoggerFactory.getLogger(MyLogger.class);

    public void logInfo(String message){
//        logger.info(message);
        logger.debug(message);
    }

    public void logError(String message , Throwable exception){
        logger.error(message,exception);
    }
}