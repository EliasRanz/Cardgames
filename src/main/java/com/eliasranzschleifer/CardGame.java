package com.eliasranzschleifer;

public class CardGame {
    public static void main(String[] args) {
        Game game;
        game = new BlackJack();
        game.play();
        System.out.println(game);
    }
}


