package top.wrh.learn.sbalbbc.verification.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
public class TokenStoreConfig {


    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }
}
