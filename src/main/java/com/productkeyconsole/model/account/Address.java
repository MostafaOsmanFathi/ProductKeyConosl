/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole.model.account;
/**
 * Represents a physical address associated with an account.
 *
 * <p>This class is used to store address details for customers and sellers.
 *
 * @version 1.0
 * @since 2024
 */
public record Address(String street, String city, String state, String zip) {

    @Override
    public  String toString() {
        return street + " " + city + " " + state + " " + zip;
    }
}
