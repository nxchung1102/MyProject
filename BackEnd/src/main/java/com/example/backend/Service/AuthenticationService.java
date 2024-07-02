package com.example.backend.Service;

import com.example.backend.Dto.Request.RequestAuthentication;
import com.example.backend.Dto.Request.RequestLogout;
import com.example.backend.Dto.Request.RequestVerify;
import com.example.backend.Dto.Response.ResponseAuthentication;
import com.example.backend.Dto.Response.ResponseVerify;
import com.example.backend.Exception.ErrorCode;
import com.example.backend.Exception.GlobalException;
import com.example.backend.Model.Accounts;
import com.example.backend.Model.InvalidToken;
import com.example.backend.Repositories.AccountsDAO;
import com.example.backend.Repositories.InvalidTokenDAO;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    InvalidTokenDAO tokenDAO;
    AccountsDAO repoAccountsDAO;
    PasswordEncoder passwordEncoder;
    @NonFinal
    @Value("${jwt.signerKey}")
    protected String signKey;

    public ResponseVerify checkExpiration(RequestVerify request) throws JOSEException, ParseException {
        var token = request.getToken();
        boolean flag = true;
        try {
            verifyToken(token);
        } catch (GlobalException e) {
            flag = false;
        }
        return ResponseVerify.builder()
                .verify(flag)
                .build();
    }

    public ResponseAuthentication authenticate(RequestAuthentication request) throws JOSEException {
        var user = repoAccountsDAO.findById(request.getUserName()).orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_EXIST));


        boolean authenticated = passwordEncoder.matches(request.getPassWord(), user.getPassWord());

        if (!authenticated) {
            throw new GlobalException(ErrorCode.UNAUTHENTICATED);
        }
        var token = genarateToken(user);

        return ResponseAuthentication.builder()
                .token(token)
                .authenticated(authenticated)
                .build();
    }

    public String genarateToken(Accounts acc) throws JOSEException {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(acc.getEmail())
                .issuer("TheC.com")
                .issueTime(new Date())
                .expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS)
                        .toEpochMilli()))
                .jwtID(UUID.randomUUID().toString())
                .claim("scope", buildScope(acc)).build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        jwsObject.sign(new MACSigner(signKey.getBytes()));
        return jwsObject.serialize();
    }

    private String buildScope(Accounts accounts) {
        StringJoiner joiner = new StringJoiner(" ");
        if (!CollectionUtils.isEmpty(accounts.getRoles()))
            accounts.getRoles().forEach(role -> {
                joiner.add("ROLE_" + role.getName());
                if (!CollectionUtils.isEmpty(role.getAuthorities()))
                    role.getAuthorities().forEach(authorities -> joiner.add(authorities.getName()));
            });
        return joiner.toString();
    }

    public void logout(RequestLogout req) throws ParseException, JOSEException {
        var getToken = verifyToken(req.getToken());
        String tokenId = getToken.getJWTClaimsSet().getJWTID();
        Date expirationTime = getToken.getJWTClaimsSet().getExpirationTime();
        InvalidToken invalidToken = InvalidToken.builder()
                .id(tokenId)
                .expirationTime(expirationTime)
                .build();
        tokenDAO.save(invalidToken);
    }

    private SignedJWT verifyToken(String token) throws JOSEException, ParseException {
        JWSVerifier verifier = new MACVerifier(signKey.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);
        Date expiration = signedJWT.getJWTClaimsSet().getExpirationTime();
        var vrified = signedJWT.verify(verifier);
        if (!(vrified && expiration.after(new Date()))) {
            throw new GlobalException(ErrorCode.UNAUTHENTICATED);
        }
        if (tokenDAO.existsById(signedJWT.getJWTClaimsSet().getJWTID())) {
            throw new GlobalException(ErrorCode.UNAUTHENTICATED);
        }
        return signedJWT;
    }
}
