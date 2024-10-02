/*
 *  Copyright (c) 2024 Mostafa Osman
 *  All rights reserved.
 *
 *  This software and associated documentation files (the "Software") may not be
 *  used, copied, modified, merged, published, distributed, or sublicensed without
 *  explicit permission from the copyright owner.
 */
package com.productkeyconsole.view;

import de.vandermeer.asciitable.AsciiTable;

import java.util.Scanner;

/**
 * Manages the console-based user interface for the application.
 * <p>
 * <Here’s the Javadoc for the final class in your structure:
 * <p>
 * ---
 * <p>
 * ### `view/ConsoleViewer.java`
 * <p>
 * ```java
 * /**
 * Manages the console-based user interface for the Product Key Console Application.
 *
 * <p>This class is responsible for displaying information and interacting with the user via the console.
 * It handles user input, formatting output, and guiding users through various program functions.
 *
 * @version 1.0
 * @since 2024
 */
public class ConsoleViewer {

    private static final Scanner scanner = new Scanner(System.in);

    private ConsoleViewer() {
    }

    public static void makeHeader(String header) {
        var tmp = new AsciiTable();
        tmp.addRule();
        tmp.addRow(header);
        tmp.addRule();
        System.out.println(tmp.render());
    }

    public static void readInputs(String[] args, String[] argsName) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("enter " + argsName[i] + ":");
            args[i] = scanner.nextLine();
        }
    }

    public static void makeHeaderWithRows(String Header, String... Rows) {
        var tmp = new AsciiTable();
        tmp.addRule();
        tmp.addRow(Header);
        tmp.addRule();
        int cnt = 0;
        for (var row : Rows) {
            if (row.equals("---"))
                tmp.addRule();
            else
                tmp.addRow(++cnt + "." + row);
        }
        tmp.addRule();
        System.out.println(tmp.render());
    }
}
