package com.eliasranzschleifer;

import java.util.Scanner;

/**
* Created by ddceliasr on 4/8/16.
*/
public class BlackJack implements Game {
    Deck deck;
    BlackjackHand playerHand;
    BlackjackHand dealerHand;

    public BlackJack() {
        deck = new Deck();
        playerHand = buildHand();
        dealerHand = buildHand();
    }

    public void play() {
        Scanner input = new Scanner(System.in);
        String playChoice = null;
        Card dealtCard;
        boolean playerIsBust = playerHand.isBust();
        System.out.println(playerHand);
        int playerScore = playerHand.score(true);
        do {
            playerScore = playerHand.score(true);
            System.out.println("Your score is " + playerScore);
            System.out.println("Would you like to hit? (y/n): ");
            playChoice = input.nextLine();
            if(playChoice.equals("y")) {
                dealtCard = deck.dealCard();
                System.out.println(dealtCard);
                playerHand.dealCard(dealtCard);
                System.out.println(playerHand);
                playerIsBust = playerHand.isBust();
                if(playerIsBust) {
                    System.out.println("You're bust...");
                    break;
                }

            } else {
                System.out.println("You have opted to not hit, you're score is: " + playerScore);
            }
        } while (playChoice.equals("y") && !playerIsBust);

        System.out.println();
        System.out.println();
        System.out.println(dealerHand);
        System.out.println();

        boolean dealerIsBust = false;
        int dealerScore = dealerHand.score(true);
        while(dealerScore < 16 && !dealerIsBust) {
            dealerHand.dealCard(deck.dealCard());

            System.out.println("Visible dealer score is: " + dealerHand.score(false)); //only show 'public' score
            //update any changed state before exiting the loop...
            dealerScore = dealerHand.score(true);
            dealerIsBust = dealerHand.isBust();
        }
        if(dealerIsBust) {
            System.out.println("Dealer is bust...");
        }
        String winningMessage = String.format("The Dealer's score is %s, and your score is %s. You %s.", dealerScore, playerHand.score(true), winningHand(playerHand,dealerHand).equals(playerHand) ? "win" : "lose");
        System.out.println(winningMessage);
    }

    public BlackjackHand buildHand() {
        Card secretCard = deck.dealCard();
        Card publicCard = deck.dealCard();
        BlackjackHand hand = new BlackjackHand(secretCard,publicCard);

        return hand;
    }
    public String finalScore(int playerScore,int dealerScore, boolean playerIsBust,boolean dealerIsBust) {
        // String.format("The Dealer's score is %s, and your score is %s. You %s.");
        System.out.println("Dealer Score is: " + dealerScore + " Bust? " + dealerIsBust);
        System.out.println("Player Score is: " + playerScore + " Bust? " + playerIsBust);

        // String.format("The Dealer's score is %s, and your score is %s. You %s.", dealerScore, playerScore, winningHand(playerHand).equals(playerHand) ? "win" : "lose");

        if(playerScore > dealerScore && !playerIsBust && !dealerIsBust) {
            return "WIN and both players not bust";
        } else if(playerScore < dealerScore && !playerIsBust && !dealerIsBust) {
            return "LOSE and both players not bust";
        } else if(playerScore < dealerScore && !playerIsBust) {
            return "WIN and player is not bust";
        } else if(playerScore < dealerScore && !dealerIsBust) {
            return "LOSE and dealer is not bust";
        } else {
            return "LOSE";
        }
    }

    protected static BlackjackHand winningHand(BlackjackHand playerHand,BlackjackHand dealerHand) {
        int playerScore = playerHand.score(true);
        int dealerScore = dealerHand.score(true);
        boolean playerIsBust = playerHand.isBust();
        boolean dealerIsBust = dealerHand.isBust();
        BlackjackHand winningHand = dealerHand;
        if(playerScore > dealerScore && !playerIsBust && !dealerIsBust) {
            winningHand = playerHand;
        } else if(playerScore > dealerScore && !playerIsBust) {
            winningHand = playerHand;
        } else if(playerScore < dealerScore && dealerIsBust && !playerIsBust){
            winningHand = playerHand;
        }
        return winningHand;
    }


}