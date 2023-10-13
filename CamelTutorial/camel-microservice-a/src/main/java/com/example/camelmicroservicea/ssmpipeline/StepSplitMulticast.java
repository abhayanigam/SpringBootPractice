package com.example.camelmicroservicea.ssmpipeline;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class StepSplitMulticast extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:start")
            .routeId("MyId")
            .log("Received message: ${body}")
            .to("log:MyId?level=INFO&showAll=true&multiline=true");

        /*
        * .to("log:MyRouteLogger?level=INFO&showAll=true&multiline=true") and .to("log:AnotherRouteLogger?level=INFO&showAll=true&multiline=true") endpoints to log messages.
        * In the log endpoints, we specify ?level=INFO&showAll=true&multiline=true to configure the log pattern and level.
        * The key part here is showAll=true, which includes the routeId in the log output.
        */

//        from("direct:start")
//            .log("Received message")
////            .log("Received message: ${body}")
//            .step("Step 1") // Step 1 marker
//            .to("log:Step1")
//            .step("Step 2") // Step 2 marker
//            .to("log:Step2")
//            .step("Step 3") // Step 3 marker
//            .to("log:Step3");

//        from("direct:start")
//            .split(body().tokenize(",")) // Split the message by commas
//            .to("log:SplitRoute?level=INFO");

//        from("direct:start")
//            .multicast() // Multicast the message
//            .to("log:Message 1")
//            .to("log:Message 2")
//            .to("log:Message 3");


    }
}
