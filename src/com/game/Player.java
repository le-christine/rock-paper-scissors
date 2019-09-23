package com.game;

import java.util.*;

/**
 * An abstract Player class that manages
 * the state of the player (if they won or lost and how many points
 * they have or what move they made).
 */
abstract class Player {
    private int wins;
    private int losses;
    private String name;

    public void setName() {
        System.out.println("Enter your name: ");
        Scanner name = new Scanner(System.in);
        this.name = name.nextLine();
        System.out.println("Welcome " + this.name + "!");
    }

    public String getName() {
        return name;
    }

    public void setName1() {
        System.out.println("Player 1, enter your your name: ");
        Scanner name = new Scanner(System.in);
        this.name = name.nextLine();
        System.out.println("Welcome " + this.name + "!");
    }

    public void setName2() {
        System.out.println("Player 2, enter your your name: ");
        Scanner name = new Scanner(System.in);
        this.name = name.nextLine();
        System.out.println("Welcome " + this.name + "!");
    }


    public void declareWin() {
        System.out.println("Congrats, winner " + this.name + "!");
        this.wins += 1;
    }

    public void declareLoss() {
        System.out.println("Sorry " + this.name + ", try again.");
        this.losses += 1;
    }




}
