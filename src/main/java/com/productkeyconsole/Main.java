/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole;

import com.productkeyconsole.control.ProgramFlowController;
import com.productkeyconsole.service.AccountService;
import com.productkeyconsole.util.SaveToFile;

import java.io.FileNotFoundException;
import java.util.ServiceLoader;

/**
 * The entry point of the Product Key Console Application.
 * Initializes the application and controls the program flow.
 *
 * <p>This class invokes the controllers and services that manage the system's core functionalities.
 *
 * @author Mostafa Osman
 * @version 1.0
 * @since 2024
 */
public class Main {
    /**
     * Starts the program by inshiating the account services and calling loading files of the program
     */
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
