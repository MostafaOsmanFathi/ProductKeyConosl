package com.productkeyconsole.util;

import java.io.FileNotFoundException;

public interface SaveToFile {
    String SAVEINPATH = "src/main/java/com/productkeyconsole/repo/";

    void SaveInFile() throws FileNotFoundException;
}
