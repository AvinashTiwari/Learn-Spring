package learn.avinash.spring.util;

import org.springframework.stereotype.Component;

@Component
public class UserContext {
    public static final String CORRELATION_ID = "is-correlation-id";
    public static final String AUTH_TOKEN = "Authorization ";
    public static final String  USER_ID = "is-user-id";

    private String coorelationId = new String();
    private String authToken = new String();
    private String userId = new String();

    public String getCoorelationId() {
        return coorelationId;
    }

    public void setCoorelationId(String coorelationId) {
        this.coorelationId = coorelationId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
