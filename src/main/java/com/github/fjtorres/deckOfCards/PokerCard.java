package com.github.fjtorres.deckOfCards;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class to represent a poker card.
 */
public class PokerCard extends Card<PokerCardValue, PokerSuit> {

    /**
     * Amount of cards for poker.
     */
    public static int DECK_SIZE = PokerSuit.values().length * PokerCardValue.values().length;

    /**
     * Retrieves the list of cards for all suites.
     *
     * @return All poker cards.
     */
    public static List<PokerCard> allCards() {

        return Stream.of(PokerSuit.values())
                .map(suitOfCards -> Stream.of(PokerCardValue.values())
                .map(cardValue -> new PokerCard(cardValue, suitOfCards))
                .collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public PokerCard(PokerCardValue value, PokerSuit suit) {
        super(value, suit);
    }

    @Override
    public String toString() {
        return String.format("%s of %s", getValue(), getSuit().getSymbol());
    }
}
