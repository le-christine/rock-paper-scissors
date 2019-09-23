package com.game;

import java.util.Random;
import java.util.Scanner;

public class newPlayer extends Player {
    private String move;

    public void setMove() {
        System.out.println(this.getName() + ", make a choice: rock, paper, or scissors: ");
        Scanner move = new Scanner(System.in);
        String input = move.nextLine().toLowerCase();

        if (!input.contains("rock") && !input.contains("paper") && !input.contains("scissors")) {
            System.out.println("Error. Invalid choice.");
            setMove();
        } else {
            this.move = input;
        }
    }

    public String getMove() {
        return move;
    }


    public void showPlayerPicked() {
        System.out.println(this.getName() + " picks: " + this.getMove());
    }


}
