package com.productkeyconsole;

import com.productkeyconsole.control.ProgramFlowController;
import com.productkeyconsole.service.AccountService;
import com.productkeyconsole.util.SaveToFile;

import java.io.FileNotFoundException;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AccountService.getAccountService().loadFromFileCustomer();
        AccountService.getAccountService().loadFromFileSeller();
        ProgramFlowController.startProgramFlow();
        ServiceLoader<SaveToFile> loader = ServiceLoader.load(SaveToFile.class);
        for (SaveToFile saveToFile : loader) {
            saveToFile.SaveInFile();
        }

    }
}
