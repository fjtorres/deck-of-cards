package com.github.fjtorres.deckOfCards;

/**
 * Object mother class to build poker cards.
 */
public class PokerCardObjectMother {

    public static PokerCard createDiamondAce() {
        return new PokerCard(PokerCardValue.ACE, PokerSuit.DIAMONDS);
    }

    public static PokerCard createDiamondKing() {
        return new PokerCard(PokerCardValue.KING, PokerSuit.DIAMONDS);
    }
}
