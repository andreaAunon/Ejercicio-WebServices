package es.neesis.webservicesserver.config;

import es.neesis.webservicesserver.client.ConversionsClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
public class ConversionsConfig {

    // Si hubiera varios habria que renombrarlo como marshallerConversions
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
        client.setDefaultUri("https://www.dataaccess.com/webservicesserver/NumberConversion.wso");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
