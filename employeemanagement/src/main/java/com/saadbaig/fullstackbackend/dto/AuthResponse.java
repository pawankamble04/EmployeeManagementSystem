package com.saadbaig.fullstackbackend.dto;

import java.util.List;

public record AuthResponse(
        String accessToken,
        String tokenType,
        long expiresInMs,
        List<String> roles
) {
}
