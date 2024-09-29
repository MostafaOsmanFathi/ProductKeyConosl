package com.productkeyconsole.view;

import de.vandermeer.asciitable.AsciiTable;

import java.util.Scanner;

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
            args[i]=scanner.nextLine();
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
