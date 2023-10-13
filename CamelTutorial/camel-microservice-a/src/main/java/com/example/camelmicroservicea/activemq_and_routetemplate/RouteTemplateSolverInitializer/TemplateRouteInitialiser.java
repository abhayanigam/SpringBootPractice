package com.example.camelmicroservicea.activemq_and_routetemplate.RouteTemplateSolverInitializer;

import com.mongodb.client.model.Filters;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mongodb.MongoDbConstants;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import org.apache.camel.Exchange;
import org.apache.camel.builder.TemplatedRouteBuilder;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

@Component
public class TemplateRouteInitialiser extends RouteBuilder {
    //Don't Remove this method and change the value unless you are Apache Camel Champion and you know you what's going to happen
    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void configure() throws Exception {
        from("timer://ActivateTemplate?delay=1s&repeatCount=1")
                .log("==========INITIALIZING KPI TEMPLATES==========")
                .setHeader("TemplateDatabase", constant("taask"))
                .setHeader("TemplateCollection", constant("message"))
                .setHeader(MongoDbConstants.CRITERIA, constant(Filters.eq("status", "active")))
                .toD("mongodb:mongo?database=${headers.TemplateDatabase}&collection=${headers.TemplateCollection}&operation=findall")
                .choice()
                    .when(body())
                        .split().jsonpath("$")
                            .marshal().json(JsonLibrary.Jackson)
                            .bean(this,"createTemplate")
                            .log("header ${headers}")
                            .log("Body ${body}")
                            .log("Initialised Kpi Template <==> ${header.KpiTemplate}")
                    .end()
                .endChoice();
    }

    public void createTemplate(Exchange exchange) throws Exception{
        String body = exchange.getIn().getBody(String.class);
        Configuration conf = Configuration.defaultConfiguration().setOptions(Option.SUPPRESS_EXCEPTIONS);
        DocumentContext dc = JsonPath.using(conf).parse(body);
        exchange.getIn().setHeader("KpiTemplate", dc.read("$.TemplateProperties.kpi_name"));
        
        TemplatedRouteBuilder.builder(exchange.getContext(), dc.read("$.TemplateName"))
        .routeId( dc.read("$.TemplateProperties.clientId") + "_" + dc.read("$.TemplateProperties.kpi_name"))
        .parameters(dc.read("$.TemplateProperties"))
        .add();
    }
}

