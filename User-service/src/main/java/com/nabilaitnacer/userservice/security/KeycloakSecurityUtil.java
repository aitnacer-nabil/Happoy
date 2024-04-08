package com.nabilaitnacer.userservice.security;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KeycloakSecurityUtil {
     Keycloak keycloak;

        @Value("${keycloak.auth-server-url}")
        private String keycloakServerUrl;
       @Value("${keycloak.realm}")
        private String realm;
        @Value("${keycloak.client-id}")
        private String clientId;
        @Value("${keycloak.name}")
        private String name;
        @Value("${keycloak.password}")
        private String password;
        @Value("${keycloak.grant-type}")
        private String grantType;

        public Keycloak getKeycloak() {
            if (keycloak == null) {
                keycloak = KeycloakBuilder.builder()
                        .serverUrl(keycloakServerUrl)
                        .realm(realm)
                        .username(name)
                        .password(password)
                        .clientId(clientId)
                        .grantType(grantType)
                        .build();
            }
            return keycloak;
        }

}
