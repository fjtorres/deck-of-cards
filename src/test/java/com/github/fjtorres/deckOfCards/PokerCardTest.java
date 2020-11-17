package com.github.fjtorres.deckOfCards;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for {@link PokerCard} methods.
 */
class PokerCardTest {

    @Test
    @DisplayName("Value cannot be null to create a card")
    public void valueCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new PokerCard(null, PokerSuit.DIAMONDS));
    }

    @Test
    @DisplayName("Suit cannot be null to create a card")
    public void suitCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new PokerCard(PokerCardValue.ACE, null));
    }

    @Test
    @DisplayName("Two cards with the same value and suite should be equals")
    public void equalsCards() {
        assertEquals(PokerCardObjectMother.createDiamondAce(), PokerCardObjectMother.createDiamondAce());
    }

    @Test
    @DisplayName("Two cards with different values should not be equals")
    public void notEqualsCards() {
        assertNotEquals(PokerCardObjectMother.createDiamondAce(), PokerCardObjectMother.createDiamondKing());
    }
}