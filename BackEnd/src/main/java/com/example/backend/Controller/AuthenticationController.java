package com.example.backend.Controller;

import com.example.backend.Dto.Request.RequestAuthentication;
import com.example.backend.Dto.Request.RequestLogout;
import com.example.backend.Dto.Request.RequestRefresh;
import com.example.backend.Dto.Request.RequestVerify;
import com.example.backend.Dto.Response.ResponseApi;
import com.example.backend.Dto.Response.ResponseAuthentication;
import com.example.backend.Dto.Response.ResponseVerify;
import com.example.backend.Service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService service;

    @PostMapping("/login")
    public ResponseApi<ResponseAuthentication> authenticate(@RequestBody RequestAuthentication request) throws JOSEException {
        return ResponseApi.<ResponseAuthentication>builder()
                .result(service.authenticate(request))
                .build();
    }

    @PostMapping("/introspect")
    public ResponseApi<ResponseVerify> authenticate(@RequestBody RequestVerify request) throws ParseException, JOSEException {
        return ResponseApi.<ResponseVerify>builder()
                .result(service.checkExpiration(request))
                .build();
    }

    @PostMapping("/refresh")
    public ResponseApi<ResponseAuthentication> refreshToken(@RequestBody RequestRefresh request) throws JOSEException, ParseException {
        return ResponseApi.<ResponseAuthentication>builder()
                .result(service.refreshToken(request))
                .build();
    }

    @PostMapping("/logout")
    public ResponseApi<Void> logout(@RequestBody RequestLogout request) throws ParseException, JOSEException {
        service.logout(request);
        return ResponseApi.<Void>builder().build();
    }
}
