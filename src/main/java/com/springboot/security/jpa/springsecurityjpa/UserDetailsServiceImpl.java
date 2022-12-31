package com.springboot.security.jpa.springsecurityjpa;

import com.springboot.security.jpa.springsecurityjpa.model.MyUserDetails;
import com.springboot.security.jpa.springsecurityjpa.model.Users;
import com.springboot.security.jpa.springsecurityjpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

@Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users=userRepository.findByUserName(username);
        users.orElseThrow(() -> new UsernameNotFoundException("Not found: " + users));
        return  users.map(MyUserDetails::new).get();
    }

    /**
     * this is to save user in to the db
     * @param user
     */
    public Users saveUser(Users user)
    {
        return userRepository.save(user);

    }
}
