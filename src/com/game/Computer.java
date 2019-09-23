package com.game;

import java.util.Random;

public class Computer {
    private String computerChoice;

    public void setComputerChoice() {
        int randomChoice = new Random().nextInt(3);
        int choice = randomChoice + 1;
        //System.out.println(choice);
        this.computerChoice = choice == 1 ? "Rock" : choice == 2 ? "Paper" :
                choice == 3 ? "Scissors" : null;
    }

    public void showComputerPicked() {
        System.out.println("Computer picks: " + computerChoice);
    }

    public String getComputerMove() {
        return(computerChoice);
    }
}
