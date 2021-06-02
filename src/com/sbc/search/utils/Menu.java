package com.sbc.search.utils;

import java.util.Scanner;

public class Menu {
    private static final int MAX_MENU_OPTION = 3;
    private static final int MIN_MENU_OPTION = 1;
    private static final int MAX_SUB_MENU = 'f';
    private static final int MIN_SUB_MENU = 'a';
    private String option;
    private Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
    }

    public void showStartingMessage() {
        System.out.println("Welcome to SBC Search Algorithms.");
    }

    public void getOptionInput() {
        option = sc.nextLine();
    }

    public int getOptionA() {
        return Integer.parseInt(option);
    }

    public char getOptionB() {
        return option.toLowerCase().charAt(0);
    }

    public void showMainMenu() {
        System.out.println("\n1. A*");
        System.out.println("2. CSP");
        System.out.println("3. Exit");
        System.out.println("Select an option: ");
    }

    private void showError(int whichError) {
        switch (whichError) {
            case 1:
                System.out.println("Enter a valid option (1-2).");
                break;
            case 2:
                System.out.println("Enter a valid option (a-f).");
                break;
        }
    }

    private int strToNum(String str) {
        int i = 0;
        double number = 0;

        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            number = number * 10 + (str.charAt(i) - '0');
            i++;
        }
        return (int) number;
    }

    private int checkOption() {
        StringBuilder stringBuilder = new StringBuilder();
        String ascii = "";
        long numeric;
        int opt = -1;

        for (int i = 0; i < option.length(); i++) {
            stringBuilder.append((int) option.charAt(i));
            char c = option.charAt(i);
        }
        ascii = stringBuilder.toString();
        numeric = strToNum(ascii);
        if (numeric >= '1' && numeric <= '5') {
            opt = Character.getNumericValue(Integer.parseInt(ascii));
        }
        return opt;
    }

    public boolean checkMainOption() {
        int opt = checkOption();
        if (opt >= MIN_MENU_OPTION && opt <= MAX_MENU_OPTION) {
            return true;
        }
        showError(1);
        return false;
    }

    public void menuHeuristicas() {
        System.out.println("\n");
        System.out.println("a) Heuristica exacta");
        System.out.println("b) Historial de localitzacions");
        System.out.println("\n");
        System.out.println("Select an option: ");
    }

    private int checkCharOption() {
        int opt = -1;

        if (option.length() > 1) {
            return opt;
        }
        int numeric = option.toLowerCase().charAt(0);
        if (numeric >= 'a' && numeric <= 'f') {
            opt = numeric;
        }
        return opt;
    }

    public boolean validateInput() {
        int aux = checkCharOption();
        if (aux >= MIN_SUB_MENU && aux <= MAX_SUB_MENU) {
            return true;
        }
        showError(2);
        return false;
    }

    public boolean exitProgram() {
        return Integer.parseInt(option) == MAX_MENU_OPTION;
    }

    public boolean exit() {
        return option.toLowerCase().charAt(0) == MAX_SUB_MENU;
    }


}
