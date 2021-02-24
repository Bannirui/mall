package com.example.mall.user.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.mall.common.exception.ValidateException;
import com.example.mall.user.constant.SysRetCodeEnum;
import lombok.Builder;
import lombok.Setter;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author dingrui
 * @date 2021-02-22
 * @description jwt token
 */
@Builder
public class JwtTokenUtil {

    /**
     * 传输信息，必须是json格式
     */
    private String msg;

    /**
     * 所验证的jwt
     */
    @Setter
    private String token;

    private final String secret = "324iu23094u598ndsofhsiufhaf_+0wq-42q421jiosadiusadiasd";

    public String creatJwtToken() throws NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {
        // 先对信息进行aes加密 防止被破解
        msg = new AESUtil(msg).encrypt();
        String token = null;
        token = JWT.create()
                .withIssuer("wlgzs")
                .withExpiresAt(Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant()))
                .withClaim("user", msg)
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    /**
     * @author dingrui
     * @date 2021/2/23
     * @return
     * @description 解密jwt并验证是否正确
     */
    public String freeJwt() throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        DecodedJWT decodedJWT = null;
        // 使用hmac256加密算法
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withIssuer("wlgzs")
                .build();
        decodedJWT = verifier.verify(token);
        // 获得token的头部，载荷和签名，只对比头部和载荷
        String[] headPayload = token.split("\\.");
        // 获得jwt解密后头部
        String header = decodedJWT.getHeader();
        // 获得jwt解密后载荷
        String payload = decodedJWT.getPayload();
        if (!header.equals(headPayload[0]) && !payload.equals(headPayload[1])) {
            throw new ValidateException(SysRetCodeEnum.TOKEN_VALID_FAILED.getCode(), SysRetCodeEnum.TOKEN_VALID_FAILED.getMsg());
        }
        return new AESUtil(decodedJWT.getClaim("user").asString()).decrypt();
    }

}
