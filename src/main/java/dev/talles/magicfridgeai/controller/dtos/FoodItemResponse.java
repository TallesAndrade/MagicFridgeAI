package dev.talles.magicfridgeai.controller.dtos;
import dev.talles.magicfridgeai.enums.CategoryFood;
import java.time.LocalDateTime;

public record FoodItemResponse(Long id,
                               String nome,
                               CategoryFood category,
                               Integer quantity,
                               LocalDateTime expirationDate) {

}
