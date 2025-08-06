package dev.talles.magicfridgeai.controller.dtos;
import dev.talles.magicfridgeai.enums.CategoryFood;
import java.time.LocalDate;

public record FoodItemResponse(Long id,
                               String nome,
                               CategoryFood category,
                               Integer quantity,
                               LocalDate expirationDate) {

}
