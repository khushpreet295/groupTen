/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Map;

//@author khushpreet singh, karanpreet kaur gill, sukhjeet singh
public class CommunicationManager {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayScoreboard(Map<Player, Integer> scores) {
        displayMessage("\nScoreboard:");
        for (Player player : scores.keySet()) {
            displayMessage(player.getName() + ": " + scores.get(player));
        }
    }

    public void announceRoundWinner(Player roundWinner) {
        displayMessage("Winner of this round: " + (roundWinner != null ? roundWinner.getName() : "No winner"));
    }

    public void announceFinalWinner(Player finalWinner) {
        displayMessage("Final Winner: " + (finalWinner != null ? finalWinner.getName() : "No winner"));
    }
}
