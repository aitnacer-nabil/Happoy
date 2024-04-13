package com.nabilaitnacer.userservice.utils;

import java.util.UUID;

public class Utils {
    public static String generateUUID() {
        long currentTimeMillis = System.currentTimeMillis();
        UUID uuid = new UUID(currentTimeMillis, currentTimeMillis);
        return uuid.toString();
    }
}
