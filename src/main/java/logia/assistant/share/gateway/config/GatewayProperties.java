package logia.assistant.share.gateway.config;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import io.github.jhipster.config.JHipsterDefaults;

/**
 * The Class GatewayProperties.
 *
 * @author Dai Mai
 */
@Configuration
@ConfigurationProperties(prefix = "jhipster", ignoreUnknownFields = true)
public class GatewayProperties {
    
    /** The security. */
    private final Security security = new Security();
    
    /**
     * Gets the security.
     *
     * @return the security
     */
    public Security getSecurity() {
        return security;
    }
    
    /**
     * The Class Security.
     *
     * @author Dai Mai
     */
    public static class Security {

        /** The client authorization. */
        private final ClientAuthorization clientAuthorization = new ClientAuthorization();

        /** The authentication. */
        private final Authentication authentication = new Authentication();

        /** The remember me. */
        private final RememberMe rememberMe = new RememberMe();

        /**
         * Gets the client authorization.
         *
         * @return the client authorization
         */
        public ClientAuthorization getClientAuthorization() {
            return clientAuthorization;
        }

        /**
         * Gets the authentication.
         *
         * @return the authentication
         */
        public Authentication getAuthentication() {
            return authentication;
        }

        /**
         * Gets the remember me.
         *
         * @return the remember me
         */
        public RememberMe getRememberMe() {
            return rememberMe;
        }

        /**
         * The Class ClientAuthorization.
         *
         * @author Dai Mai
         */
        public static class ClientAuthorization {

            /** The access token uri. */
            private String accessTokenUri = JHipsterDefaults.Security.ClientAuthorization.accessTokenUri;

            /** The token service id. */
            private String tokenServiceId = JHipsterDefaults.Security.ClientAuthorization.tokenServiceId;

            /** The client id. */
            private String clientId = JHipsterDefaults.Security.ClientAuthorization.clientId;

            /** The client secret. */
            private String clientSecret = JHipsterDefaults.Security.ClientAuthorization.clientSecret;

            /**
             * Gets the access token uri.
             *
             * @return the access token uri
             */
            public String getAccessTokenUri() {
                return accessTokenUri;
            }

            /**
             * Sets the access token uri.
             *
             * @param accessTokenUri the new access token uri
             */
            public void setAccessTokenUri(String accessTokenUri) {
                this.accessTokenUri = accessTokenUri;
            }

            /**
             * Gets the token service id.
             *
             * @return the token service id
             */
            public String getTokenServiceId() {
                return tokenServiceId;
            }

            /**
             * Sets the token service id.
             *
             * @param tokenServiceId the new token service id
             */
            public void setTokenServiceId(String tokenServiceId) {
                this.tokenServiceId = tokenServiceId;
            }

            /**
             * Gets the client id.
             *
             * @return the client id
             */
            public String getClientId() {
                return clientId;
            }

            /**
             * Sets the client id.
             *
             * @param clientId the new client id
             */
            public void setClientId(String clientId) {
                this.clientId = clientId;
            }

            /**
             * Gets the client secret.
             *
             * @return the client secret
             */
            public String getClientSecret() {
                return clientSecret;
            }

            /**
             * Sets the client secret.
             *
             * @param clientSecret the new client secret
             */
            public void setClientSecret(String clientSecret) {
                this.clientSecret = clientSecret;
            }
        }

        /**
         * The Class Authentication.
         *
         * @author Dai Mai
         */
        public static class Authentication {

            /** The jwt. */
            private final Jwt jwt = new Jwt();

            /**
             * Gets the jwt.
             *
             * @return the jwt
             */
            public Jwt getJwt() {
                return jwt;
            }

            /**
             * The Class Jwt.
             *
             * @author Dai Mai
             */
            public static class Jwt {

                /** The secret. */
                private String secret = JHipsterDefaults.Security.Authentication.Jwt.secret;

                /** The token validity in seconds. */
                private long tokenValidityInSeconds = JHipsterDefaults.Security.Authentication.Jwt
                    .tokenValidityInSeconds;

                /** The token validity in seconds for remember me. */
                private long tokenValidityInSecondsForRememberMe = JHipsterDefaults.Security.Authentication.Jwt
                    .tokenValidityInSecondsForRememberMe;

                /**
                 * Gets the secret.
                 *
                 * @return the secret
                 */
                public String getSecret() {
                    return secret;
                }

                /**
                 * Sets the secret.
                 *
                 * @param secret the new secret
                 */
                public void setSecret(String secret) {
                    this.secret = secret;
                }

                /**
                 * Gets the token validity in seconds.
                 *
                 * @return the token validity in seconds
                 */
                public long getTokenValidityInSeconds() {
                    return tokenValidityInSeconds;
                }

                /**
                 * Sets the token validity in seconds.
                 *
                 * @param tokenValidityInSeconds the new token validity in seconds
                 */
                public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
                    this.tokenValidityInSeconds = tokenValidityInSeconds;
                }

                /**
                 * Gets the token validity in seconds for remember me.
                 *
                 * @return the token validity in seconds for remember me
                 */
                public long getTokenValidityInSecondsForRememberMe() {
                    return tokenValidityInSecondsForRememberMe;
                }

                /**
                 * Sets the token validity in seconds for remember me.
                 *
                 * @param tokenValidityInSecondsForRememberMe the new token validity in seconds for remember me
                 */
                public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
                    this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
                }
            }
        }

        /**
         * The Class RememberMe.
         *
         * @author Dai Mai
         */
        public static class RememberMe {

            /** The key. */
            @NotNull
            private String key = JHipsterDefaults.Security.RememberMe.key;

            /**
             * Gets the key.
             *
             * @return the key
             */
            public String getKey() {
                return key;
            }

            /**
             * Sets the key.
             *
             * @param key the new key
             */
            public void setKey(String key) {
                this.key = key;
            }
        }
    }
}
