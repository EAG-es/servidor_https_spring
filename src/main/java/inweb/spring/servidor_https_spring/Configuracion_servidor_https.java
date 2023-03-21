package inweb.spring.servidor_https_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author emilio
 */
@Configuration
public class Configuracion_servidor_https {
    public static final String k_path_restful_sin_csrf = "/restful"; 

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.requiresChannel(channel -> 
            channel.anyRequest().requiresSecure()).authorizeHttpRequests(authorize ->
                authorize.anyRequest().permitAll());
        http.csrf().ignoringRequestMatchers(k_path_restful_sin_csrf, k_path_restful_sin_csrf + "/**"); // .disable(); 
        return http.build();
    }

}
