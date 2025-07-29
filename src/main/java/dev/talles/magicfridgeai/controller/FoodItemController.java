package dev.talles.magicfridgeai.controller;

import dev.talles.magicfridgeai.controller.dtos.FoodItemRequest;
import dev.talles.magicfridgeai.controller.dtos.FoodItemResponse;
import dev.talles.magicfridgeai.service.FoodItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {
    private final FoodItemService service;

    public FoodItemController(FoodItemService foodItemService) {
        this.service = foodItemService;
    }

    @PostMapping
    public ResponseEntity<FoodItemResponse> createFood(@RequestBody FoodItemRequest request){
        FoodItemResponse response = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<FoodItemResponse>> listFood(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listFood());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItemResponse> foodId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getFoodById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FoodItemResponse> updateFood(@PathVariable Long id,@RequestBody FoodItemRequest foodUpdated){


        return ResponseEntity.status(HttpStatus.OK).body(service.updateFood(id, foodUpdated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id){
        service.deleteFood(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
