package com.eliasranzschleifer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* Created by ddceliasr on 4/8/16.
*/
public class Deck {
    private List<Card> deck = new ArrayList<>();
    public Deck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                int weight;
                switch (value) {
                    case JACK:
                    case QUEEN:
                    case KING:
                        weight = 10;
                        break;
                    default:
                        weight = value.ordinal() + 1;
                }

                Card card = new Card(weight,suit,value);
                deck.add(card);
            }
        }
        shuffleDeck(3);
    }

    public Card dealCard() {
        Card dealtCard = deck.get(0);
        deck.remove(dealtCard);
        return dealtCard;
    }

    private void shuffleDeck(int shuffleAmount) {
        for(int i=0;i<=shuffleAmount;i++) {
            Collections.shuffle(deck);
        }
    }
}
