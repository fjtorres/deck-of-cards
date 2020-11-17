package com.github.fjtorres.deckOfCards;

import java.util.Objects;

/**
 * Class to represent a card element.
 *
 * @param <S> Type of suit.
 * @param <V> Type of value.
 */
public class Card<V extends Enum<?>, S extends Enum<?>> {

    private final V value;
    private final S suit;

    public Card(V value, S suit) {
        validateInputParams(value, suit);
        this.value = value;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Card)) {
            return false;
        }

        final Card<?, ?> other = (Card<?, ?>) o;

        return Objects.equals(getValue(), other.getValue())
                && Objects.equals(getSuit(), other.getSuit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getSuit());
    }

    /**
     * Validate input params:
     * - Value cannot be null.
     * - Suit cannot be null.
     *
     * @param value Card value.
     * @param suit  Card suite.
     * @throws IllegalArgumentException If some constraint are not ok.
     */
    private void validateInputParams(V value, S suit) {
        if (value == null || suit == null) {
            throw new IllegalArgumentException("Value and suit are required to create a card.");
        }
    }

    public V getValue() {
        return value;
    }

    public S getSuit() {
        return suit;
    }
}
