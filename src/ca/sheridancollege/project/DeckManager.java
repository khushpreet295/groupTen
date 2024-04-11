/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * @author khushpreet singh, karanpreet kaur gill, sukhjeet singh
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckManager {

    private List<Card> deck;

    public DeckManager() {
        deck = new ArrayList<>();
    }

    public void createDeck(List<Player> players) {
        initializeDeck();
        shuffleDeck();
        distributeCards(players);
    }

    private void initializeDeck() {
        deck.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(deck);
    }


    private void distributeCards(List<Player> players) {
        int numPlayers = players.size();
        int cardsPerPlayer = deck.size() / numPlayers;
        int remainingCards = deck.size() % numPlayers;
        int cardIndex = 0;

        for (Player player : players) {
            List<Card> playerCards = new ArrayList<>();
            for (int i = 0; i < cardsPerPlayer; i++) {
                playerCards.add(deck.get(cardIndex++));
            }
            player.addCards(playerCards);
        }

        //reming cards
        for (int i = 0; i < remainingCards; i++) {
            players.get(i).addCard(deck.get(cardIndex++));
        }
    }

    public Card drawCard() {
        if (deck.isEmpty()) {
            throw new IllegalStateException("Deck is empty. Cannot draw card.");
        }
        return deck.remove(0);
    }

    public int getDeckSize() {
        return deck.size();
    }
}
