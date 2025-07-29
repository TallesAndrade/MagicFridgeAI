package dev.talles.magicfridgeai.controller.dtos;

import dev.talles.magicfridgeai.enums.CategoryFood;

import java.time.LocalDateTime;

public record FoodItemRequest(String name,
                              CategoryFood category,
                              Integer quantity,
                              LocalDateTime expirationDate) {
}
