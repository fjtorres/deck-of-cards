package com.github.fjtorres.deckOfCards;

/**
 * Application class to execute a deck.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Poker deck: Start");
        Deck<PokerCard> pokerDeck = new Deck<>(PokerCard.allCards());

        pokerDeck.shuffle();

        while(!pokerDeck.isEmpty()) {
            pokerDeck.dealOneCard().ifPresent(System.out::println);
        }
        System.out.println("Poker deck: End");
    }
}
