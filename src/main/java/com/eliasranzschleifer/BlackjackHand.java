package com.eliasranzschleifer;
import java.util.ArrayList;
import java.util.List;
/**
* Created by ddceliasr on 4/8/16.
*/
public class BlackjackHand {
    private final Card secretCard;
    private final List<Card> publicCards;

    public BlackjackHand(Card secretCard, Card publicCard) {
        this.secretCard = secretCard;
        this.publicCards = new ArrayList<>();
        dealCard(publicCard);
    }

    public void dealCard(Card card) {
        publicCards.add(card);
    }

    public int score(boolean isPlayersHand) {
        int score = 0;
        if (isPlayersHand) {
            score += secretCard.getWeight();
        }

        for (Card publicCard : publicCards) {
            score += publicCard.getWeight();
        }
        return score;
    }

    @Deprecated
    public boolean isBust(int score) {
        return isBust();
    }

    public boolean isBust() {
        int score = this.score(true);
        return score > 21;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "secretCard=" + secretCard +
                ", publicCards=" + publicCards +
                ", score=" + score(true) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlackjackHand hand = (BlackjackHand) o;

        if (secretCard != null ? !secretCard.equals(hand.secretCard) : hand.secretCard != null) return false;
        return publicCards != null ? publicCards.equals(hand.publicCards) : hand.publicCards == null;

    }

    @Override
    public int hashCode() {
        int result = secretCard != null ? secretCard.hashCode() : 0;
        result = 31 * result + (publicCards != null ? publicCards.hashCode() : 0);
        return result;
    }

    public Card getSecretCard() {
        return secretCard;
    }

    public List<Card> getPublicCards() {
        return publicCards;
    }
}