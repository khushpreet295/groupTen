/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;
//@author khushpreet singh, karanpreet kaur gill, sukhjeet singh
public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

     
       // Login
boolean loggedIn = false;
while (!loggedIn) {
    System.out.println("\nPlease log in to start playing.");
    System.out.print("Enter your username: ");
    String username = scanner.nextLine();
    System.out.print("Enter your password: ");
    String password = scanner.nextLine();
    ;
        // Game setup
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            game.addPlayer(playerName);
        }
        game.createDeckAndDistribute(game.getPlayers());

        // Start game
        boolean playAgain = true;
        while (playAgain) {
            game.playRound();
            game.showScoreboard();
            Player roundWinner = game.getRoundWinner();
            System.out.println("Winner of this round: " + (roundWinner != null ? roundWinner.getName() : "No winner"));
            game.resetScores();
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAnotherRound = scanner.nextLine();
            playAgain = playAnotherRound.equalsIgnoreCase("yes");
        }

        // Final winner
        Player finalWinner = game.getRoundWinner();
        System.out.println("Final Winner: " + (finalWinner != null ? finalWinner.getName() : "No winner"));
    }}}

