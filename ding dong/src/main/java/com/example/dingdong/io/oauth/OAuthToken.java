package com.example.dingdong.io.oauth;

import java.io.Serializable;

import javax.crypto.spec.SecretKeySpec;

public class OAuthToken implements Serializable {
    private static final String TAG = OAuthToken.class.getSimpleName();

    private String token;

    private String tokenSecret;

    private transient SecretKeySpec secretKeySpec;

    public OAuthToken(String token, String tokenSecret) {
        this.token = token;
        this.tokenSecret = tokenSecret;
    }

    public OAuthToken() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }

    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    public SecretKeySpec getSecretKeySpec() {
        return secretKeySpec;
    }

    public void setSecretKeySpec(SecretKeySpec secretKeySpec) {
        this.secretKeySpec = secretKeySpec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof OAuthToken))
            return false;
        OAuthToken that = (OAuthToken) o;
        if (secretKeySpec != null ? !secretKeySpec.equals(that.secretKeySpec) : that.secretKeySpec != null)
            return false;
        if (!token.equals(that.token))
            return false;
        return tokenSecret.equals(that.tokenSecret);

    }

    @Override
    public int hashCode() {
        if (token != null) {
            int result = token.hashCode();
            result = 31 * result + tokenSecret.hashCode();
            result = 31 * result + (secretKeySpec != null ? secretKeySpec.hashCode() : 0);
            return result;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "OAuthToken{" + "token='" + token + '\'' + ", tokenSecret='" + tokenSecret + '\'' + ", secretKeySpec="
                + secretKeySpec + '}';
    }
}
