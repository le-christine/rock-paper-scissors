package com.game;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    static String gameHistory = "\n";

    public static void main(String[] args) {
        startGame();
    }



    // ==== CONDITIONALS FOR PLAYER VS COMPUTER ====
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
                gameHistory+=("WIN: " + p.getName() + " picked " + pChoice
                        + ", Computer picked " + cChoice + "\n");
            } else if (pChoice.equalsIgnoreCase(cChoice)) {
                System.out.println("It's a tie!");
                gameHistory+=("TIE: " + p.getName() + " picked " + pChoice
                        + ", Computer picked " + cChoice + "\n");
            } else {
                p.declareLoss();
                gameHistory+=("LOSS: " + p.getName() + " picked " + pChoice
                        + ", Computer picked " + cChoice + "\n");

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ==== CONDITIONALS FOR PLAYER VS PLAYER ====

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
                gameHistory+=("WIN: " + p1.getName() + " picked " + p1Choice
                        + ", " +p2.getName() + " picked " + p2Choice+"\n");
                p2.declareLoss();
            } else if (p1Choice.equalsIgnoreCase(p2Choice)) {
                System.out.println("It's a tie!");
                gameHistory+=("TIE: " + p1.getName() + " picked " + p1Choice
                        + ", " +p2.getName() + " picked " + p2Choice+"\n");
            } else {
                p1.declareLoss();
                p2.declareWin();
                gameHistory+=("LOSS: " + p1.getName() + " picked " + p1Choice
                        + ", " +p2.getName() + " picked " + p2Choice+"\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ==== GAME ====
    public static void startGame() {
        String choice = "";

        while (!choice.equals("quit")) {
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
        } catch (Exception e) {
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
                    showOutcomesPlayers(human1, human2);
                    compareChoicesPlayers(human1, human2);
                    break;
                case "history":
                    System.out.println(gameHistory);
                    break;
                case "quit":
                    System.out.println("GG");
                    break;
                default:
                    System.out.println("Error. Choice unknown.");
                    break;
            }
        }
    }
}
