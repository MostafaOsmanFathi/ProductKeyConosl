package com.productkeyconsole.model.productkey;

public record ProductKeyInfo(String productName, String description) {
    @Override
    public String toString() {
        return "productName: " + productName + " description: " + description;
    }
}
