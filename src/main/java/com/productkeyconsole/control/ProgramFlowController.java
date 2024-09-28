package com.productkeyconsole.control;


import java.awt.image.ConvolveOp;
import java.util.Scanner;

import de.vandermeer.asciitable.AsciiTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.productkeyconsole.view.ConsoleViewer.*;

public class ProgramFlowController {
    private static final ProgramFlowController programFlowController = new ProgramFlowController();
    private static final Logger log = LoggerFactory.getLogger(ProgramFlowController.class);
    private static Scanner scanner = new Scanner(System.in);

    static void login() {
        welcomeScreen();
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                loginScreen();
                break;
            case 2:
                CreateAccountScreen();
                break;
            default:
        }
    }

    private ProgramFlowController() {

    }

    public static void main(String[] args) {
        login();
    }

}
