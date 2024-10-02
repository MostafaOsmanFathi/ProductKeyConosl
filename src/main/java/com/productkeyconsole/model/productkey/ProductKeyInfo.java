/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole.model.productkey;
/**
 * Contains detailed information about a product key, such as its associated product and licensing terms.
 *
 * @version 1.0
 * @since 2024
 */
public record ProductKeyInfo(String productName, String description) {
    @Override
    public String toString() {
        return "productName: " + productName + " description: " + description;
    }
}
