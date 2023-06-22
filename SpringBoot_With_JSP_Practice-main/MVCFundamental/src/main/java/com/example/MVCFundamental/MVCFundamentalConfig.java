package com.example.MVCFundamental;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

@Configuration
public class MVCFundamentalConfig implements WebMvcConfigurer {

//    To render the pdf file in the web under webapp>web-inf>pdf url like : localhost:8080/files/name.pdf
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/files/**")
                    .addResourceLocations("/WEB-INF/pdf/");
        }

//       This to add Language translation. url like : http://localhost:8081/registration?lang=es and created 2 files under
//       resources folder : messages.properties and messages_es.properties (for spanish translation)
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(localeChangeInterceptor());
        }

        @Bean
        public LocaleResolver localeResolver() {
            SessionLocaleResolver slr = new SessionLocaleResolver();
            slr.setDefaultLocale(Locale.US);
            return slr;
        }

        @Bean
        public HandlerInterceptor localeChangeInterceptor() {
            LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
            lci.setParamName("lang");
            return lci;
        }

// Alternate of the application.properties file
//        @Bean
//        public ViewResolver viewResolver() {
//            InternalResourceViewResolver bean = new InternalResourceViewResolver();
//            bean.setPrefix("/WEB-INF/jsp/");
//            bean.setSuffix(".jsp");
//            bean.setOrder(0);
//            return bean;
//        }


}
