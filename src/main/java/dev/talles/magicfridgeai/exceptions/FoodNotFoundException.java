package dev.talles.magicfridgeai.exceptions;

public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException(String message) {
        super(message);
    }

    public FoodNotFoundException() {
        super("Food not Found");
    }
}
