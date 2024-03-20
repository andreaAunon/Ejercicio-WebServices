package es.andrea.webservicesserver.config;

import es.andrea.webservicesserver.client.ConversionsClient;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

public class ConversionsConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("es.andrea.webservicesserver.ws.numbers");
        return marshaller;
    }

    // Controller
    @Bean
    public ConversionsClient conversionsClient(Jaxb2Marshaller marshaller) {
        ConversionsClient client = new ConversionsClient();
        client.setDefaultUri("http://localhost:8080/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
