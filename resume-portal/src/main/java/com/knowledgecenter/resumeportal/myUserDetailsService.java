package com.knowledgecenter.resumeportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.knowledgecenter.resumeportal.models.*;

@Service
public class myUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUserName(userName);
        System.out.println("Username is: "+userName);
        user.orElseThrow( () -> new UsernameNotFoundException("Not Found: "+ userName));
        
        return user.map(MyUserDetails::new).get();
    }
    
}