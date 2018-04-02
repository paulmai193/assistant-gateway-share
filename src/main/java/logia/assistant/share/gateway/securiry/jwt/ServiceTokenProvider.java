package logia.assistant.share.gateway.securiry.jwt;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import logia.assistant.share.gateway.config.GatewayProperties;

/**
 * The Class ServiceTokenProvider.
 *
 * @author Dai Mai
 */
@Component
public class ServiceTokenProvider extends TokenProvider {
    
    /** The token. */
    private String token;
    
    /**
     * Instantiates a new service token provider.
     *
     * @param jHipsterProperties the j hipster properties
     */
    public ServiceTokenProvider(GatewayProperties jHipsterProperties) {
        super(jHipsterProperties);
    }
    
    /**
     * Gets the token.
     *
     * @param serviceName the service name
     * @param secretKey the secret key
     * @return the token
     */
    public String getToken(String serviceName, String secretKey) {
        if (Objects.isNull(this.token) || !this.validateToken(token)) {
            this.createSystemToken(serviceName, secretKey);
        }
        return this.token;
    }
    
    /**
     * Gets the bearer token.
     *
     * @param serviceName the service name
     * @param secretKey the secret key
     * @return the bearer token
     */
    public String getBearerToken(String serviceName, String secretKey) {
        return "Bearer " + this.getToken(serviceName, secretKey);
    }

    /**
     * Creates the system token.
     *
     * @param serviceName the service name
     * @param secretKey the secret key
     * @return the string
     */
    private String createSystemToken(String serviceName, String secretKey) {
        GrantedAuthority authority = new SimpleGrantedAuthority(AuthoritiesConstants.SYSTEM);
        SystemUserDetails systemUserTokenDetail = new SystemUserDetails().appendPassword(secretKey).appendUsername(serviceName).appendAuthority(authority);
        Authentication authentication = new UsernamePasswordAuthenticationToken(systemUserTokenDetail, null, systemUserTokenDetail.getAuthorities());
        return createToken(authentication , false);
    }

    /**
     * The Class SystemUserDetails.
     *
     * @author Dai Mai
     */
    public static class SystemUserDetails implements Serializable, UserDetails {

        /** The Constant serialVersionUID. */
        private static final long serialVersionUID = 1L;

        /** The username. */
        private String username;

        /** The password. */
        private String password;
        
        /** The authorities. */
        private Set<GrantedAuthority> authorities = new HashSet<>();
        
        /* (non-Javadoc)
         * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
         */
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.authorities;
        }
        
        /**
         * Append authority.
         *
         * @param authority the authority
         * @return the system user details
         */
        public SystemUserDetails appendAuthority(GrantedAuthority authority) {
            this.authorities.add(authority);
            return this;
        }

        /* (non-Javadoc)
         * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
         */
        @Override
        public String getPassword() {
            return this.password;
        }
        
        /**
         * Append password.
         *
         * @param password the password
         * @return the system user details
         */
        public SystemUserDetails appendPassword(String password) {
            this.password = password;
            return this;
        }

        /* (non-Javadoc)
         * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
         */
        @Override
        public String getUsername() {
            return this.username;
        }
        
        /**
         * Append username.
         *
         * @param username the username
         * @return the system user details
         */
        public SystemUserDetails appendUsername(String username) {
            this.username = username;
            return this;
        }

        /* (non-Javadoc)
         * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
         */
        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        /* (non-Javadoc)
         * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
         */
        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        /* (non-Javadoc)
         * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
         */
        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        /* (non-Javadoc)
         * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
         */
        @Override
        public boolean isEnabled() {
            return true;
        }
        
    }
    
}
