/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//@author khushpreet singh, karanpreet kaur gill, sukhjeet singh
public class Game {

    private List<Player> players;
    private DeckManager deckManager;
    private GameScoreManager scoreManager;
    private CommunicationManager communicationManager;
    

    public Game() {
        players = new ArrayList<>();
        deckManager = new DeckManager();
        scoreManager = new GameScoreManager();
        communicationManager = new CommunicationManager();
    }

    public void addPlayer(String name) {
        Player player = new Player(name);
        players.add(player);
        scoreManager.addPlayer(player);
    }


    public void createDeckAndDistribute(List<Player> players) {
        deckManager.createDeck(players);
    }

     //play a round of the game.

    public void playRound() {
        for (Player player : players) {
            scoreManager.addScore(player, 0);
        }

        boolean gameOn = true;
        while (gameOn) {
            for (Player player : players) {
                Scanner scanner = new Scanner(System.in);
                System.out.println(player.getName() + ", press enter to draw a card...");
                scanner.nextLine();
                Card drawnCard = deckManager.drawCard();
                System.out.println(player.getName() + " drew: " + drawnCard);
                scoreManager.addScore(player, drawnCard.getRank().getValue());
                if (scoreManager.getScore(player) >= 21) {
                    gameOn = false;
                    break;
                }
            }
        }
    }

     //display the scoreboard.
     
    public void showScoreboard() {
        communicationManager.displayScoreboard(scoreManager.getScores());
    }

     //reset player scores for a new round.
     
    public void resetScores() {
        scoreManager.resetScores();
        for (Player player : players) {
            player.resetHand();
        }
    }

   // winner of the round based on total scores.
    
    public Player getRoundWinner() {
        return scoreManager.getRoundWinner();
    }
    public List<Player> getPlayers() {
        return players;
    }
}
