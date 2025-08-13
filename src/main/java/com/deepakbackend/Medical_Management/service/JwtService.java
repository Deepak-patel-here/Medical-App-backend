package com.deepakbackend.Medical_Management.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private final String SECRET_KEY = "dG91Y2hzdHJvbmdlcmRlZXJmYW1vdXNtb2Rlcm5zdGFnZWRvZ29yZGVyYmVzaGFsbHM=";
    public String generateToken(String subject){
        Map<String,Object> claims=new HashMap<>();

        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*60*60))
                .and()
                .signWith(getKey())
                .compact();
    }

    public SecretKey getKey(){
        byte [] bytes= Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(bytes);
    }

    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }


    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token).getPayload();
        return claimsResolver.apply(claims);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
