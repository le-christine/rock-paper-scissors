package com.game;

import java.util.Scanner;

public class Game {
    // ==== GAME FOR PLAYER VS COMPUTER ====
    public static void showOutcomes(newPlayer p, Computer c) {
        p.showPlayerPicked();
        c.showComputerPicked();
    }

    public static void compareChoices(newPlayer p, Computer c) {
        String pChoice = p.getMove();
        String cChoice = c.getComputerMove();
        try {
            if ((pChoice.equalsIgnoreCase("Paper") && cChoice.equalsIgnoreCase("Rock")) ||
                    (pChoice.equalsIgnoreCase("Scissors") && cChoice.equalsIgnoreCase("Paper")) ||
                    (pChoice.equalsIgnoreCase("Rock") && cChoice.equalsIgnoreCase("Scissors"))) {
                p.declareWin();
            } else if (pChoice.equalsIgnoreCase(cChoice)) {
                System.out.println("It's a tie!");
            } else {
                p.declareLoss();
            }
        } catch(Exception e ){
            System.out.println(e.getMessage());
        }
    }

    // ==== GAME FOR PLAYER VS PLAYER ====

    public static void showOutcomesPlayers(newPlayer p1, newPlayer p2) {
        p1.showPlayerPicked();
        p2.showPlayerPicked();
    }

    public static void compareChoicesPlayers(newPlayer p1, newPlayer p2) {
        String p1Choice = p1.getMove();
        String p2Choice = p2.getMove();
        try {
            if ((p1Choice.equalsIgnoreCase("Paper") && p2Choice.equalsIgnoreCase("Rock")) ||
                    (p1Choice.equalsIgnoreCase("Scissors") && p2Choice.equalsIgnoreCase("Paper")) ||
                    (p1Choice.equalsIgnoreCase("Rock") && p2Choice.equalsIgnoreCase("Scissors"))) {
                p1.declareWin();
                p2.declareLoss();
            } else if (p1Choice.equalsIgnoreCase(p2Choice)) {
                System.out.println("It's a tie!");
            } else {
                p1.declareLoss();
                p2.declareWin();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String choice = null;

        System.out.println("" +
                "Welcome to Rock, Paper, Scissors!\n" +
                "\n" +
                "MAIN MENU\n" +
                "=====\n" +
                "1. Type '2 players' to play with another Player.\n" +
                "2. Type 'vs. computer' to play with Computer.\n" +
                "3. Type 'history' to view your game history.\n" +
                "4. Type 'quit' to stop playing.");

        Scanner getChoice = new Scanner(System.in);

        try {
            choice = getChoice.nextLine();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }


        switch (choice) {
            case "vs. computer":
                newPlayer human = new newPlayer();
                Computer computer = new Computer();
                human.setName();
                human.setMove();
                computer.setComputerChoice();
                showOutcomes(human, computer);
                compareChoices(human, computer);
                break;

            case "2 players":
                newPlayer human1 = new newPlayer();
                newPlayer human2 = new newPlayer();

                human1.setName1();
                human2.setName2();

                human1.setMove();
                human2.setMove();

                showOutcomesPlayers(human1,human2);
                compareChoicesPlayers(human1, human2);
                break;

            case "history":
                break;
            case "quit" :
                System.out.println("GG");
                break;
            default:
                System.out.println("Error. Choice unknown.");
                break;
        }
    }
}
