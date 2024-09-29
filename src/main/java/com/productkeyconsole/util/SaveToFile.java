package com.productkeyconsole.util;

import java.io.FileNotFoundException;

public interface SaveToFile {
    void SaveInFile(Object obj) throws FileNotFoundException;
}
