package com.example.conatainer_tut.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class LifeCycleUsingAnnotations {
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LifeCycleUsingAnnotations() {
        super();
    }

    @Override
    public String toString() {
        return "LifeCycleUsingAnnotations{" +
                "subject='" + subject + '\'' +
                '}';
    }

    @PostConstruct
    public void init(){
        System.out.println("Init Method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy Method");
    }
}
