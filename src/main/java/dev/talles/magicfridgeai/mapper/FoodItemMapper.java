package dev.talles.magicfridgeai.mapper;

import dev.talles.magicfridgeai.controller.dtos.FoodItemRequest;
import dev.talles.magicfridgeai.controller.dtos.FoodItemResponse;
import dev.talles.magicfridgeai.model.FoodItem;
import org.springframework.stereotype.Component;

@Component
public class FoodItemMapper {

    public FoodItem toEntity(FoodItemRequest request) {
        return new FoodItem(null,
                request.nome(),
                request.category(),
                request.quantity(),
                request.expirationDate());

    }

    public FoodItemResponse toResponse(FoodItem entity){
        return new FoodItemResponse(entity.getId(),
                entity.getName(),
                entity.getCategory(),
                entity.getQuantity(),
                entity.getExpirationDate());
    }
}
