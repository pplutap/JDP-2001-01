package com.kodilla.ecommercee.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TokenGenerator {

    public String generateToken() {
        Random random = new Random();
        byte bytes[] = new byte[10];
        random.nextBytes(bytes);
        String randomString = bytes.toString();

        LocalDateTime timeStamp = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
        String tokenTime = timeStamp.format(timeFormatter);
        String token = randomString + tokenTime;
        return token;
    }
}
