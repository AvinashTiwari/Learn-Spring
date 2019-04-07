package learn.avinash.spring.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class JwtTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> additionaInfo = new HashMap<>();
        String userId = "dummy_id";
        additionaInfo.put("userId", userId);
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionaInfo);

        return  oAuth2AccessToken;

    }
}
