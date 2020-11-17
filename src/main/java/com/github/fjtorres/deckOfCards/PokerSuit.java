package com.github.fjtorres.deckOfCards;

/**
 * Enumeration with all the suits for poker.
 */
public enum PokerSuit {
    HEARTS("\u2665"), SPADES("\u2664"), CLUBS("\u2663"), DIAMONDS("\u2662");

    private final String symbol;

    PokerSuit(String pSymbol) {
        this.symbol = pSymbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
