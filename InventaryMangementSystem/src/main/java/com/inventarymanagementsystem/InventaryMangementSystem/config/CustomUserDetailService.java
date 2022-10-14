package com.inventarymanagementsystem.InventaryMangementSystem.config;

import com.inventarymanagementsystem.InventaryMangementSystem.model.CustomerUserDetails;
import com.inventarymanagementsystem.InventaryMangementSystem.repository.WorkerRepository;


import com.inventarymanagementsystem.InventaryMangementSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private WorkerRepository workerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= workerRepository.findByUsername(username);
        System.out.println(user.getUsername()+"   "+user.getPassword()+"  "+user.getRole());
        if(user==null)
            throw  new UsernameNotFoundException("User Not Found");
        return new CustomerUserDetails(user);
    }
}
