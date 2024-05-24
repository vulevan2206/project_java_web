package hcmute.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.PolicyException;
import java.io.InputStream;

@Configuration
public class AntiSamyConfig {

    @Bean
    public AntiSamy antiSamy() {
        try {
           
            InputStream inputStream = getClass().getResourceAsStream("/antisamy-slashdot.xml");
            
            Policy policy = Policy.getInstance(inputStream);
            //Trả về một đối tượng AntiSamy được khởi tạo với Policy.
            return new AntiSamy(policy);
        } catch (PolicyException e) {
            throw new RuntimeException("Failed to load AntiSamy policy", e);
        }
    }
}