package es.neesis.webservicesserver;

import es.neesis.webservicesserver.client.ConversionsClient;
import es.neesis.webservicesserver.config.ConversionsConfig;
import es.neesis.webservicesserver.ws.numbers.NumberToDollarsResponse;
import es.neesis.webservicesserver.ws.numbers.NumberToWordsResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConversionsConfig.class, loader = AnnotationConfigContextLoader.class)
public class ConversionsTests {

    @Autowired
    private ConversionsClient conversionsClient;

    @Test
    public void numbersToDollars() {
        NumberToDollarsResponse testConversion = conversionsClient.numberToDollars(1);
        assertEquals("one ", testConversion.getNumberToDollarsResult());
    }

    @Test
    public void numbersToWords() {
        NumberToWordsResponse testConversion = conversionsClient.numberToWords(1);
        assertEquals("one ", testConversion.getNumberToWordsResult());
    }
}
