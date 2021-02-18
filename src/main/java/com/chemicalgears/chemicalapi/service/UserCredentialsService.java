package com.chemicalgears.chemicalapi.service;

import com.chemicalgears.chemicalapi.entity.UserCredentials;
import com.chemicalgears.chemicalapi.repository.UserCredentialsRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserCredentialsService implements UserDetailsService {

    private final UserCredentialsRepository userCredentialsRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    UserCredentialsService(UserCredentialsRepository userCredentialsRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userCredentialsRepository = userCredentialsRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserCredentials findById(Long id) {
        return userCredentialsRepository.findById(id).get();
    }

    public Boolean registerUser(UserCredentials userCredentials) {
        userCredentials.setPassword(bCryptPasswordEncoder.encode(userCredentials.getPassword()));
        if(userCredentialsRepository.findByUsernameAndPassword(userCredentials.getUsername(),
                userCredentials.getPassword()).isEmpty()) {
            userCredentialsRepository.save(userCredentials);
            return true;
        }
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userCredentialsRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

}
