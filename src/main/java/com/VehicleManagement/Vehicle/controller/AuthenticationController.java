package com.VehicleManagement.Vehicle.controller;

import com.VehicleManagement.Vehicle.dto.JwtAuthenticationResponse;
import com.VehicleManagement.Vehicle.dto.RefreshTokenRequest;
import com.VehicleManagement.Vehicle.dto.SignUpRequest;
import com.VehicleManagement.Vehicle.dto.SigninRequest;
import com.VehicleManagement.Vehicle.model.User;
import com.VehicleManagement.Vehicle.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest)
    {
        return  ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest)
    {
        return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest)
    {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }


}
