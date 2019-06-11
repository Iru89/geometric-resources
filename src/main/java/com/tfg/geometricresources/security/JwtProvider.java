package com.tfg.geometricresources.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;


@Component
public class JwtProvider {

    private static final String ISSUER = "authIru";
    private static final String GEOMETRIC_RESOURCES = "GeometricResources";

    private RSAPublicKey publicKey;

    public JwtProvider(RSAPublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public ObjectId getUserIdFromJWT(String token) {

        try{
            DecodedJWT decodedJWT = JWT.decode(token);

            Claim claimUserId = decodedJWT.getClaim("userId");
            if(!claimUserId.isNull()){
                return new ObjectId(claimUserId.asString());
            }
            return null;
        }catch (JWTDecodeException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean validateToken(String authToken) {
        try{
            Algorithm algorithm = getAlgorithm(publicKey);
            DecodedJWT decodedJWT = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .withAudience(GEOMETRIC_RESOURCES)
                    .acceptLeeway(5)            //Aceptem 5 seg de marge en exp nbf i iat
                    .build()
                    .verify(authToken);
            return true;
        }catch (JWTVerificationException e ){
            return false;
        }
    }

    public DecodedJWT decodedJWT(String authToken) {
        Algorithm algorithm = getAlgorithm(publicKey);
        DecodedJWT decodedJWT = JWT.require(algorithm)
                .withIssuer(ISSUER)
                .acceptLeeway(5)            //Aceptem 5 seg de marge en exp nbf i iat
                .build()
                .verify(authToken);
        return JWT.decode(authToken);
    }

    private Algorithm getAlgorithm(PublicKey publicKey) {
        RSAPublicKey RSAPublicKey = (RSAPublicKey) publicKey;
        return Algorithm.RSA512(RSAPublicKey, null);
    }


//    private String[] getRoles(MyUserDetails myUserDetails) {
//        return myUserDetails.getAuthorities().stream().map(a->a.getAuthority()).toArray(String[]::new);
//    }

}

