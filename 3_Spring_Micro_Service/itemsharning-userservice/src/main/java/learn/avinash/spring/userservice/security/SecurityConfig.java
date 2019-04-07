package learn.avinash.spring.userservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class SecurityConfig extends ResourceServerConfigurerAdapter {
    private static final String[] public_matcher = {};

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)http.authorizeRequests().anyRequest()).authenticated();
        http.authorizeRequests()
                .antMatchers(public_matcher)
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
