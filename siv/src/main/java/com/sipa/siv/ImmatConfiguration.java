package com.sipa.siv;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ImmatConfiguration {

    /*@Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.sipa.siv.wsdl");
        return marshaller;
    }*/

    /*@Bean
    public ImmatClient immatClient(Jaxb2Marshaller marshaller) {
        ImmatClient client = new ImmatClient();
        //client.setDefaultUri("http://www.webservicex.com/stockquote.asmx");
        //client.setMarshaller(marshaller);
        //client.setUnmarshaller(marshaller);
        return client;
    }*/

    @Bean
    public TypeIdentification typeIdentification () {
        TypeIdentification typeIdentification = new TypeIdentification();
        typeIdentification.setApiKey("17a5d479949770e1edd5e7bb74707cc43de50ae808f69a30d40cb1379546bd3c");
        typeIdentification.setCodeTMS("44-001559");
        typeIdentification.setLogin("interface");
        typeIdentification.setPassword("q?63g_PU");
        return typeIdentification;
    }

    /**
     *
     ·         CTVO : BQ-528-WG

     ·         DA : 36 AZH 971

     ·         DC : 714 BAB 59

     ·         DSV (non-gage) : 6966 VP 73
     */
}
