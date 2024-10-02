/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole.util;

import java.io.FileNotFoundException;
/**
 * Utility class for saving data to files, such as account details or product keys.
 *
 * <p>This class provides methods to write data to text files in a structured format.
 *
 * @version 1.0
 * @since 2024
 */
public interface SaveToFile {
    String SAVEINPATH = "src/main/java/com/productkeyconsole/repo/";

    void SaveInFile() throws FileNotFoundException;
}
