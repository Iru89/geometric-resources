package com.tfg.geometricresources.config;

import com.tfg.geometricresources.model.dto.PublicKeyDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
public class PublicKeyConfig {

    @Value("${geometric.publicKeyUrl}")
    private String url;

    @Bean
    public RSAPublicKey publicKey(){

        RestTemplate restTemplate = new RestTemplate();
        PublicKeyDto publicKeyDto = restTemplate.getForObject(url, PublicKeyDto.class);
        String publicKeyBase64 = publicKeyDto.getPublicKeyBase64();
        byte[] bytesPublicKey = Base64.getDecoder().decode(publicKeyBase64);

        try {

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(bytesPublicKey));
            return publicKey;

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }
}
