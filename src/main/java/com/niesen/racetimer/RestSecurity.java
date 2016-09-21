package com.niesen.racetimer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestSecurity {

    private static String API_TOKEN;

    @Value("${security.api.token}")
    protected void setApiToken(String apiToken) {
        API_TOKEN = apiToken;
    }

    public static void checkToken(String token) {
        if (!API_TOKEN.equals(token)) {
            throw new HttpForbiddenException();
        }
        return;
    }
}
