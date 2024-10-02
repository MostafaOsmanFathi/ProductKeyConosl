/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole.control;
/**
 * Controls the overall flow of the program, managing transitions between different application states.
 *
 * <p>This class is responsible for guiding the user through different actions like account creation, product key management, and more.
 *
 * @version 1.0
 * @since 2024
 */
public class ProgramFlowController {

    private ProgramFlowController() {

    }

    public static void startProgramFlow() {
        AccountController.login();
    }



}
