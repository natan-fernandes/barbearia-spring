package com.natan.barbearia.utils;

import com.natan.barbearia.models.User;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24h
    private static final String secretKey = "senhaMuitoSecreta";

    public String generateAcessToken(User user) {
        return Jwts.builder()
                .setSubject(user.getId() + "," + user.getEmail())
                .setIssuer("Barbearia BO")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("O token expirou", ex);
        } catch (IllegalArgumentException ex) {
            LOGGER.error("O token não pode ser vazio", ex);
        } catch (MalformedJwtException ex) {
            LOGGER.error("Token inválido", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("O token não é suportado", ex);
        } catch (SignatureException ex) {
            LOGGER.error("A assinatura do token não é valida", ex);
        }

        return false;
    }

    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
