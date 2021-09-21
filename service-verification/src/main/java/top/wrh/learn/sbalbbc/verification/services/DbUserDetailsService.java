package top.wrh.learn.sbalbbc.verification.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbUserDetailsService implements UserDetailsService {


    @Autowired
    //@Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = passwordEncoder.encode("123456");
        if ("wrh".equals(username))
            return new User("wrh",password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        else
            throw new UsernameNotFoundException(username);
    }
}
