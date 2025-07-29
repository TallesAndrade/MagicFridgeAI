package dev.talles.magicfridgeai.service;

import dev.talles.magicfridgeai.controller.dtos.FoodItemRequest;
import dev.talles.magicfridgeai.controller.dtos.FoodItemResponse;
import dev.talles.magicfridgeai.exceptions.FoodNotFoundException;
import dev.talles.magicfridgeai.mapper.FoodItemMapper;
import dev.talles.magicfridgeai.model.FoodItem;
import dev.talles.magicfridgeai.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {
    private final FoodItemRepository repository;
    private final FoodItemMapper mapper;

    public FoodItemService(FoodItemRepository repository, FoodItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public FoodItemResponse save(FoodItemRequest request) {
        FoodItem entitySave = repository.save(mapper.toEntity(request));
        return mapper.toResponse(entitySave);

    }

    public List<FoodItemResponse> listFood(){
        List<FoodItem> list = repository.findAll();

        return list.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public FoodItemResponse getFoodById(Long id){
        FoodItem entity = repository.findById(id)
                .orElseThrow(FoodNotFoundException::new);
        return mapper.toResponse(entity);
    }

    public FoodItemResponse updateFood(Long id, FoodItemRequest foodUpdated) {
        FoodItem entity = repository.findById(id)
                .orElseThrow(FoodNotFoundException::new);

        if (foodUpdated.name() != null) {
            entity.setName(foodUpdated.name());
        }
        if (foodUpdated.category() != null) {
            entity.setCategory(foodUpdated.category());
        }
        if (foodUpdated.quantity() != null) {
            entity.setQuantity(foodUpdated.quantity());
        }
        if (foodUpdated.expirationDate() != null) {
            entity.setExpirationDate(foodUpdated.expirationDate());
        }

        FoodItem updatedEntity = repository.save(entity);
        return mapper.toResponse(updatedEntity);
    }

    public void deleteFood(Long id){
        repository.findById(id).orElseThrow(FoodNotFoundException::new);
        repository.deleteById(id);
    }

}
