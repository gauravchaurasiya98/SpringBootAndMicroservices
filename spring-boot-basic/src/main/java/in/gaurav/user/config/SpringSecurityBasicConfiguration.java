package in.gaurav.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityBasicConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // All http requests should be authenticated.
        httpSecurity.authorizeHttpRequests(authorizeHttpRequestsCustomizer -> authorizeHttpRequestsCustomizer.anyRequest().authenticated());
        // If a request has not authenticated then a sign in dialog box will be displayed.
        httpSecurity.httpBasic(Customizer.withDefaults());
        // Disable CSRF for POST & PUT requests.
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        // It will return DefaultSecurityFilterChain.
        return httpSecurity.build();
    }

}
