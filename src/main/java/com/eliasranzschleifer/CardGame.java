package com.eliasranzschleifer;

// import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {
//        GUI gui = new GUI(3,3);
//        Scanner input = new Scanner(System.in);
//        String gameChoice = null;


//        System.out.println("What game would you like to play?\nBlackjack (b) ");
//        gameChoice = input.nextLine();

        Game game;
        game = new BlackJack();
//        switch (gameChoice){
//            case "b":
//                game = new BlackJack();
//                System.out.println("You chose blackjack!");
//                break;
//            default:
//                game = new BlackJack();
//                System.out.println("You entered an invalid game. You're playing blackjack!");
//        }

        game.play();
        System.out.println(game);
    }
}


