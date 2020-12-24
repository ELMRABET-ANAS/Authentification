package com.example.authentfication.security;

public interface SecurityParams {

    public static final String HEADER_NAME="authorization";
    public static final String SECRET="JwtSecretKey";
    public static final long EXPIRATION=1*60*1000;
    public static final long EXPIRATION2=5*60*1000;
    public static final String HEADER_PREFIX="Bearer ";
}
