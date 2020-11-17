package com.github.fjtorres.deckOfCards;

import java.util.*;

/**
 * Class to represent a deck of cards.
 *
 * @param <C> Type of card.
 */
public class Deck<C extends Card> {

    private final Random random = new Random();
    private final List<C> cards;
    private Stack<C> cardsStack;

    /**
     * Constructor.
     *
     * @param pCards Initial set of cards.
     */
    public Deck(List<C> pCards) {
        validateInputCards(pCards);
        cards = new ArrayList<>(pCards);
        createStack(cards);
    }

    /**
     * Method to initialize and permute cards in the deck.
     * - The deck will be initialized again with all the cards.
     * - The cards will be permuted randomly.
     */
    public synchronized void shuffle() {

        int size = cards.size();

        for (int i = 0; i < size; i++) {
            int indexToSwap = i + random.nextInt(size - i);
            swap(cards, i, indexToSwap);
        }

        createStack(cards);
    }

    /**
     * This method will return the next card from the deck. You should call shuffle method before to deal to receive random cards.
     *
     * @return Next card or empty.
     * @see #shuffle()
     */
    public synchronized Optional<C> dealOneCard() {
        if (isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(cardsStack.pop());
    }

    /**
     * Pending cards on deck?
     *
     * @return true if all cards was played.
     */
    public boolean isEmpty() {
        return cardsStack == null || cardsStack.empty();
    }

    /**
     * Current deck size.
     *
     * @return Deck size.
     */
    public int size() {
        return cardsStack.size();
    }

    /**
     * Validate input list of cards:
     * - Cannot be null.
     * - Cannot be empty.
     *
     * @param cards List of cards.
     * @throws IllegalArgumentException If some constraint are not ok.
     */
    private void validateInputCards(List<C> cards) {

        if (cards == null || cards.isEmpty()) {
            throw new IllegalArgumentException("A list of cards is required to create a deck.");
        }
    }

    /**
     * Initialize the stack with new cards.
     *
     * @param cards Cards to load in stack.
     */
    private void createStack(List<C> cards) {
        cardsStack = new Stack<>();
        cards.forEach(c -> cardsStack.push(c));
    }

    /**
     * Method to swap two elements on the list by index.
     *
     * @param list     List with elements.
     * @param indexOne First index.
     * @param indexTwo Second index.
     */
    private void swap(List<C> list, int indexOne, int indexTwo) {
        C card = list.get(indexOne);
        list.set(indexOne, list.get(indexTwo));
        list.set(indexTwo, card);
    }
}
