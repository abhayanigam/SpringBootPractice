package com.example.camelmicroservicea.schedule;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MyScheduledRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("quartz://myScheduledRoute?cron=0/10+*+*+*+*+?") // Schedule every 10 seconds
                .to("log:ScheduledRoute?level=INFO");

        from("quartz://myScheduledRoute2?cron=0/10+*+*+*+*+?")
                .log("Scheduled Route 2 - Received Headers: ${headers}")
                .log("Scheduled Route 2 - Received Body: ${body}");

        from("scheduler:myScheduledRoute1?delay=5000")
                .log("Scheduled Route 1 - Received Headers: ${headers}")
                .log("Scheduled Route 1 - Received Body: ${body}");
    }
}
/**
 * from(...): This is the starting point of the Camel route, specifying where the route should begin processing messages. In this case, it begins with a Quartz2 scheduler.
 *
 * "quartz2://myScheduledRoute?cron=0/10+*+*+*+*+?": This is the URI (Uniform Resource Identifier) that defines the Quartz2 endpoint for scheduling the route. It has the following components:
 *
 * "quartz2://": This part indicates that we are using the Quartz2 component to schedule the route.
 *
 * "myScheduledRoute": This is a unique identifier or name for the scheduled route. It's arbitrary and helps you distinguish different schedules if you have multiple schedules within your Camel context.
 *
 * "cron=0/10+*+*+*+*+?": This part specifies the scheduling details using a cron expression. The cron expression 0/10+*+*+*+*+? has the following components:
 *
 * 0/10: This part defines the seconds field and means that the route should be triggered every 10 seconds (0, 10, 20, 30, etc.).
 *
 * *+*+*+*+*+?: These parts define the cron fields for minutes, hours, days of the month, months, days of the week, and the year. Using * for these fields means that the route should run every minute, every hour, every day, every month, every day of the week, and without specifying a particular year.
 */
