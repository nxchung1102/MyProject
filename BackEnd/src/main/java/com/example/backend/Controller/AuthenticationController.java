package com.example.backend.Controller;

import com.example.backend.Dto.Request.RequestAuthentication;
import com.example.backend.Dto.Request.RequestVerify;
import com.example.backend.Dto.Response.ResponseApi;
import com.example.backend.Dto.Response.ResponseAuthentication;
import com.example.backend.Dto.Response.ResponseVerify;
import com.example.backend.Service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService service;

    @PostMapping("/login")
    public ResponseApi<ResponseAuthentication> authenticate(@RequestBody RequestAuthentication request) throws Exception {
        var rs = service.authenticate(request);
        return ResponseApi.<ResponseAuthentication>builder()
                .result(rs)
                .build();
    }

    @PostMapping("/introspect")
    public ResponseApi<ResponseVerify> authenticate(@RequestBody RequestVerify request) throws Exception {
        var rs = service.verify(request);
        return ResponseApi.<ResponseVerify>builder()
                .result(rs)
                .build();
    }
}
