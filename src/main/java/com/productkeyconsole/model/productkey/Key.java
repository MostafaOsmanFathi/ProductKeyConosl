/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole.model.productkey;

import com.productkeyconsole.enumeration.KeyStatus;
import com.productkeyconsole.model.account.Account;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Objects;
/**
 * Represents a general product key in the system.
 *
 * <p>This class holds key data and provides methods for key-related actions.
 *
 * @version 1.0
 * @since 2024
 */
public class Key {
    private final String productKey;
    private KeyStatus keyStatus;
    private String assignedToEmail;
    private final LocalDate creationDate;
    private final LocalDate expiryDate;
    private LocalDate soldDate;


    public Key(@NotNull String keyValue) {
        this.productKey = keyValue;
        keyStatus = KeyStatus.AVAILABLE;
        creationDate = LocalDate.now();
        expiryDate = LocalDate.now().plusYears(3);
        soldDate = null;
    }

    private void checkExpiryDate() {
        if (creationDate.isAfter(expiryDate)) {
            keyStatus = KeyStatus.EXPIRED;
        }
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean checkProductAvaliblity() {
        checkExpiryDate();
        return this.keyStatus.equals(KeyStatus.AVAILABLE);
    }

    public String getProductKey(Account account) {
        if (checkProductAvaliblity() && account.getEmail().equals(this.assignedToEmail)) {
            return this.productKey;
        }
        return null;
    }

    public void sellKeyToEmail(Account account) {
        if (account != null && checkProductAvaliblity()) {
            this.assignedToEmail = account.getEmail();
            this.keyStatus = KeyStatus.SOLD;
            soldDate = LocalDate.now();
        }
    }

    public LocalDate getSoldDate() {
        return soldDate;
    }

    public boolean isExpired() {
        checkProductAvaliblity();
        return keyStatus.equals(KeyStatus.EXPIRED);
    }

    public void setKeyStatusToAvailable() {
        this.keyStatus = KeyStatus.AVAILABLE;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob instanceof Key) {
            return ((Key) ob).productKey.equals(this.productKey);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productKey);
    }
}
