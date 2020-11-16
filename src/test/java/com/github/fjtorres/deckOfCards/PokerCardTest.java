package com.github.fjtorres.deckOfCards;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for {@link PokerCard} methods.
 */
class PokerCardTest {

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