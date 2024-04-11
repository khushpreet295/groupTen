/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

//@author khushpreet singh, karanpreet kaur gill, sukhjeet singh
import java.util.HashMap;
import java.util.Map;

public class GameScoreManager {

    private Map<Player, Integer> scores;

    public GameScoreManager() {
        scores = new HashMap<>();
    }

    public void addPlayer(Player player) {
        scores.put(player, 0);
    }

    public void addScore(Player player, int points) {
        scores.put(player, scores.get(player) + points);
    }

    public Map<Player, Integer> getScores() {
        return scores;
    }

    public int getScore(Player player) {
        return scores.getOrDefault(player, 0);
    }

    public Player getRoundWinner() {
        Player roundWinner = null;
        int highestScore = Integer.MIN_VALUE;

        for (Map.Entry<Player, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > highestScore) {
                highestScore = entry.getValue();
                roundWinner = entry.getKey();
            }
        }

        return roundWinner;
    }

    public void resetScores() {
        scores.replaceAll((player, score) -> 0);
    }
}
