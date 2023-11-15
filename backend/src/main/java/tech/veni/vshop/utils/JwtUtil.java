package tech.veni.vshop.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.google.common.base.Strings;

import java.util.Date;

public class JwtUtil {
    private static final long expiredSeconds = 3 * 60 * 60;  //三个小时过期
    private static final String secret = "202130441436";

    public static String generateJwt(String uid) {
        Date expiredAt = new Date(System.currentTimeMillis() + expiredSeconds * 1000);
        String token = JWT.create()
                .withExpiresAt(expiredAt)  //设置过期时间
                .withClaim("uid", uid)
                .sign(Algorithm.HMAC256(secret));  //使用HMAC
        return token;
    }

    public static String parseJwt(String token) {
        if (Strings.isNullOrEmpty(token)) {
            throw new JWTVerificationException("empty token");
        }
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
        return jwtVerifier.verify(token).getClaim("uid").asString();
    }
}
