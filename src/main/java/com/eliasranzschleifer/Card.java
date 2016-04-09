package com.eliasranzschleifer;

/**
 * Created by ddceliasr on 4/8/16.
 */
public class Card {
        public enum Suit {
            HEARTS,SPADES,CLUBS,DIAMONDS
        }

        public enum Value {
            ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING
        }

        private final int weight;
        private final Suit suit;
        private final Value value;

        public Card(int weight, Suit suit, Value value) {
            this.weight = weight;
            this.suit = suit;
            this.value = value;
        }

    public int getWeight() {
        return weight;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
        public String toString() {
            return "Card{" +
                    "weight=" + weight +
                    ", suit=" + suit +
                    ", value=" + value +
                    '}';
        }
    }
