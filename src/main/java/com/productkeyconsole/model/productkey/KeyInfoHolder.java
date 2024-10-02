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
 * Holds information related to a product key, such as its status and expiration date.
 *
 * <p>This class is used to encapsulate key metadata.
 *
 * @version 1.0
 * @since 2024
 */
public record KeyInfoHolder(ProductKeyInfo keyInfo, Key key) {

}