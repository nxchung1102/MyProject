package com.example.backend.Config;

import com.example.backend.Dto.Request.RequestVerify;
import com.example.backend.Service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.text.ParseException;
import java.util.Objects;

@Component
public class JwtCustom implements JwtDecoder {
    @NonFinal
    @Value("${jwt.signerKey}")
    private String signKey;

    @Autowired
    private AuthenticationService service;

    private NimbusJwtDecoder nimbusJwtDecoder = null;

    @Override
    public Jwt decode(String token) throws JwtException {
        try {
            var res = service.checkExpiration(RequestVerify
                    .builder().token(token).build());
            if (!res.getVerify()) {
                throw new JwtException("token invalid");
            }
        } catch (JOSEException | ParseException e) {
            throw new JwtException(e.getMessage());
        }
        if (Objects.isNull(nimbusJwtDecoder)) {
            SecretKeySpec keySpec = new SecretKeySpec(signKey.getBytes(), "HS512");
            nimbusJwtDecoder = NimbusJwtDecoder.withSecretKey(keySpec)
                    .macAlgorithm(MacAlgorithm.HS512)
                    .build();
        }

        return nimbusJwtDecoder.decode(token);
    }
}
