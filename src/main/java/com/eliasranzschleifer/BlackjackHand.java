package com.eliasranzschleifer;
import com.eliasranzschleifer.tree.BinaryTreeNode;
import com.eliasranzschleifer.tree.BlackJackBinaryTree;
import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;

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
        Set<Card> cards = new HashSet<>();
        if (isPlayersHand) {
            cards.add(secretCard);
        }

        cards.addAll(publicCards);
        Set<Card> aces = Sets.filter(cards, new Predicate<Card>() {
            @Override
            public boolean apply(Card card) {
                return card.getValue() == Card.Value.ACE;
            }
        });
        Set<Card> notAces = Sets.difference(cards, aces);
        int nonAceScore = 0;
        for (Card notAce : notAces) {
            nonAceScore += notAce.getWeight();
        }
        BlackJackBinaryTree tree = new BlackJackBinaryTree(nonAceScore);
        for (Card ace : aces) {
            for (BinaryTreeNode<Integer> node : tree.getLeaves()) {
                BinaryTreeNode<Integer> leftNode = new BinaryTreeNode<>();
                leftNode.setData(node.getData() + 1);
                node.setLeftNode(leftNode);

                BinaryTreeNode<Integer> rightNode = new BinaryTreeNode<>();
                rightNode.setData(node.getData() + 11);
                node.setRightNode(rightNode);
            }
        }
        int score = nonAceScore;
        for (BinaryTreeNode<Integer> leaf : tree.getLeaves()) {
            if(leaf.getData() != null && leaf.getData() <= 21 && leaf.getData() > score) {
                score = leaf.getData();
            }
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