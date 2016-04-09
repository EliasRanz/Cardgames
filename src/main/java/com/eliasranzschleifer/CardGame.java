package com.eliasranzschleifer;

import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String gameChoice = null;

        System.out.println("What game would you like to play?\nBlackjack (b) ");
        gameChoice = input.nextLine();

        if(gameChoice.equals("b")) {
            BlackJack blackjack = new BlackJack();
        }
    }
}


