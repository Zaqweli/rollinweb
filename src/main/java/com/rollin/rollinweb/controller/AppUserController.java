package com.rollin.rollinweb.controller;

import com.rollin.rollinweb.model.AppUser;
import com.rollin.rollinweb.model.SignUpRequest.SignUpRequest;
import com.rollin.rollinweb.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserService service;
    @Autowired
    private BCryptPasswordEncoder encoder;


    @PostMapping("/sign-up")
    public void signUp(@RequestBody SignUpRequest request) {

        AppUser user = new AppUser();
        user.setUsername(request.getUsername());
        user.setPasswordHash(encoder.encode(request.getPassword()));
        service.create(user);
    }
}
