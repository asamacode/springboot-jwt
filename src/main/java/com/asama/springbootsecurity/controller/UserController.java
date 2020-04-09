package com.asama.springbootsecurity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asama.springbootsecurity.domain.LoginRequest;
import com.asama.springbootsecurity.domain.LoginResponse;
import com.asama.springbootsecurity.domain.RandomStuff;
import com.asama.springbootsecurity.domain.User;
import com.asama.springbootsecurity.service.CustomUserDetails;
import com.asama.springbootsecurity.service.UserService;
import com.asama.springbootsecurity.utils.JwtTokenProvider;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@PostMapping("/login")
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        User user = userService.getUserByName(loginRequest.getUsername());
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt, user.getLastName());
    }
	@GetMapping("/random")
	@PreAuthorize("hasAuthority('ADMIN_USER')")
	public RandomStuff randomStuff() {
		return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
	}

}
