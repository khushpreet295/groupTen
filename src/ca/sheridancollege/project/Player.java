/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
//@author khushpreet singh, karanpreet kaur gill, sukhjeet singh
import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCards(List<Card> cards) {
        hand.addAll(cards);
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int getScore() {
        int score = 0;
        for (Card card : hand) {
            score += card.getRank().getValue();
        }
        return score;
    }
    public void resetHand() {
        hand.clear();
    }
}
