package com.inventarymanagementsystem.InventaryMangementSystem.controller;

import com.inventarymanagementsystem.InventaryMangementSystem.model.JwtRequest;
import com.inventarymanagementsystem.InventaryMangementSystem.model.JwtResponse;
import com.inventarymanagementsystem.InventaryMangementSystem.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventaryController {

    @Autowired
    private JwtUtility jwtUtility;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/home")
    public String home()
    {
       return "Hey I am anuj sundriyal";
    }
    @GetMapping("/admin")
    public String admin()
    {
        return "This is Admin Page";
    }

    @PostMapping("/authenticate")
    public JwtResponse authenicate(@RequestBody JwtRequest jwtRequest) throws Exception{
      try{
        authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      jwtRequest.getUsername(),
                      jwtRequest.getPassword()
              )
      );
    }catch(BadCredentialsException badCredentialsException){
        throw  new Exception("INVALID_CREDENTIAL",badCredentialsException);
      }
      final UserDetails userDetails=userDetailsService.loadUserByUsername(jwtRequest.getUsername());
      final String token=jwtUtility.generateToken(userDetails);

      return new JwtResponse(token);
    }
}
