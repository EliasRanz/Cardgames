package com.eliasranzschleifer;

import org.junit.Test;

import static com.eliasranzschleifer.BlackJack.winningHand;
import static com.eliasranzschleifer.BlackJack.winningHand;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by ddceliasr on 3/31/16.
 */
public class BlackjackTest {
    @Test
    public void scoreTest() {
        Card card = new Card(3, Card.Suit.HEARTS, Card.Value.THREE);
        Card secretCard = new Card(10, Card.Suit.HEARTS, Card.Value.TEN);
        Hand hand = new Hand(secretCard,card);



        assertThat("Public score is 3",hand.score(false), is(3));
        assertThat("Score is 13",hand.score(true), is(13));
    }
    @Test
    public void dealerWinsWhenScoreIsHigherAndNotBust() {
        Card playerCard = new Card(3, Card.Suit.HEARTS, Card.Value.THREE);
        Card playerSecretCard = new Card(10, Card.Suit.HEARTS, Card.Value.TEN);
        Hand playerHand = new Hand(playerSecretCard,playerCard);

        Card dealerCard = new Card(5, Card.Suit.HEARTS, Card.Value.FIVE);
        Card dealerSecretCard = new Card(9, Card.Suit.HEARTS, Card.Value.NINE);
        Hand dealerHand = new Hand(dealerSecretCard,dealerCard);

        assertThat("Dealer Wins",winningHand(playerHand,dealerHand),is(dealerHand));

    }

    @Test
    public void playerWinsWhenScoreIsHigherAndNotBust() {
        Card playerCard = new Card(5, Card.Suit.HEARTS, Card.Value.FIVE);
        Card playerSecretCard = new Card(9, Card.Suit.HEARTS, Card.Value.NINE);
        Hand playerHand = new Hand(playerSecretCard,playerCard);

        Card dealerCard = new Card(3, Card.Suit.HEARTS, Card.Value.THREE);
        Card dealerSecretCard = new Card(10, Card.Suit.HEARTS, Card.Value.TEN);
        Hand dealerHand = new Hand(dealerSecretCard,dealerCard);

        assertThat("Player Wins",winningHand(playerHand,dealerHand),is(playerHand));
    }
    @Test
    public void playerWinsWhenScoreIsHigherAndDealerBust() {
        Card playerCard = new Card(5, Card.Suit.HEARTS, Card.Value.FIVE);
        Card playerSecretCard = new Card(9, Card.Suit.HEARTS, Card.Value.NINE);
        Hand playerHand = new Hand(playerSecretCard,playerCard);

        Card dealerCard = new Card(3, Card.Suit.HEARTS, Card.Value.THREE);
        Card dealerSecretCard = new Card(10, Card.Suit.HEARTS, Card.Value.TEN);
        Hand dealerHand = new Hand(dealerSecretCard,dealerCard);
        Card dealerPublicCard = new Card(10, Card.Suit.CLUBS,Card.Value.TEN);
        dealerHand.dealCard(dealerPublicCard);

        assertThat("Player Wins",winningHand(playerHand,dealerHand),is(playerHand));
    }
}
