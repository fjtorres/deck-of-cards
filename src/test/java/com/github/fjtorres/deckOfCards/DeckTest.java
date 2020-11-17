package com.github.fjtorres.deckOfCards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for {@link Deck}.
 */
class DeckTest {

    private Deck<PokerCard> deck;

    @BeforeEach
    public void setUp() {
       deck = new Deck<>(PokerCard.allCards());
    }

    @Test
    @DisplayName("Check if check throws an illegal argument exception for null list.")
    public void checkIllegalArgumentForNullList() {
        assertThrows(IllegalArgumentException.class, () -> new Deck<>(null));
    }

    @Test
    @DisplayName("Check if check throws an illegal argument exception for empty list.")
    public void checkIllegalArgumentForEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> new Deck<>(Collections.emptyList()));
    }

    @Test
    @DisplayName("Check if after deal all possible cards we don't have duplicated cards.")
    public void checkIfAfterDealAllCardsWeDoNotHaveDuplications() {

        Set<PokerCard> cards = new HashSet<>();

        boolean hasCards = true;

        while(hasCards) {
            Optional<PokerCard> nextCard = deck.dealOneCard();
            if (nextCard.isPresent()) {
                cards.add(nextCard.get());
            } else {
                hasCards = false;
            }
        }

        assertEquals(PokerCard.DECK_SIZE, cards.size());
    }

    @Test
    @DisplayName("Check if after deal a card the size of the deck changes")
    public void checkIfAfterDealACardTheSizeOfTheDeckChanges() {

        deck.dealOneCard();
        assertEquals(PokerCard.DECK_SIZE - 1, deck.size());
    }

    @Test
    @DisplayName("Check if shuffle method reset the deck after deal some cards")
    public void checkIfShuffleMethodResetTheDeckAfterDealSomeCards() {

        deck.dealOneCard();
        deck.shuffle();
        assertEquals(PokerCard.DECK_SIZE, deck.size());
    }

}