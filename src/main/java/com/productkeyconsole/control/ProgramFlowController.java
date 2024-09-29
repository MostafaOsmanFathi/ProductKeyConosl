package com.productkeyconsole.control;

public class ProgramFlowController {

    private ProgramFlowController() {

    }

    static void startProgramFlow() {
        AccountController.login();
    }

    public static void main(String[] args) {
        startProgramFlow();
    }


}
