package com.carbontracker.Utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

import static io.jsonwebtoken.Jwts.*;

@Component
public class JwtUtil {

    @Value(value = "${security.jwt.access-token.expiration:900000}")
    private long accessTokenExpiryInMillis;

    @Value(value = "${security.jwt.refresh-token.expiration:604800000}")
    private long refreshTokenExpiryInMillis;

    @Value(value = "${security.jwt.signing-secret:defaultSigningSecret}")
    private String signingSecret;

    public String generateAccessToken(String userId) {
        final Instant createdAt = Instant.now();
        final Instant expiresAt = createdAt.plusMillis(accessTokenExpiryInMillis);// 1 hour
        final SecretKey key = Keys.hmacShaKeyFor(signingSecret.getBytes(StandardCharsets.UTF_8));
        return builder()
                .subject(userId)
                .issuedAt(Date.from(createdAt))
                .expiration(Date.from(expiresAt))
                .signWith(key)
                .compact();
    }

    public String generateRefreshToken(String userId) {
        final Instant createdAt = Instant.now();
        final Instant expiresAt = createdAt.plusMillis(refreshTokenExpiryInMillis);// 7 days
        final SecretKey key = Keys.hmacShaKeyFor(signingSecret.getBytes(StandardCharsets.UTF_8));
        return builder()
                .subject(userId)
                .issuedAt(Date.from(createdAt))
                .expiration(Date.from(expiresAt))
                .signWith(key)
                .compact();
    }

    public String validateToken(String token){
        SecretKey key = Keys.hmacShaKeyFor(
                signingSecret.getBytes(StandardCharsets.UTF_8)
        );

        try {
            Claims claims = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            return claims.getSubject();

        } catch (ExpiredJwtException ex) {
            throw new RuntimeException("JWT token has expired", ex);

        } catch (JwtException | IllegalArgumentException ex) {
            throw new RuntimeException("Invalid JWT token", ex);
        }
    }
}