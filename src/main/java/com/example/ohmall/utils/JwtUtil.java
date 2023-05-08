package com.example.ohmall.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtil {
    private final Algorithm algorithm;

    public JwtUtil(String secret) {
        this.algorithm = Algorithm.HMAC256(secret);
    }

    public String encode(Long userId) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        String jwtAccessToken = JWT.create()
                .withIssuer("천재오진성")
                .withSubject("유저 어세스 토큰 발급")
                .withClaim("userId", userId)
                .sign(algorithm);

        System.out.println(jwtAccessToken);

        return jwtAccessToken;
    }

    public Long decode(String token) {
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT verify = verifier.verify(token);
        return verify.getClaim("userId").asLong();
    }
}
