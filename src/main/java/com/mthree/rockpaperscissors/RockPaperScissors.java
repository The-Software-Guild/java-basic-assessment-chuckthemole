/**
 *@author Charles Thomas
 *email: chuckthemole@gmail.com
 *date: 07/27/2021
 *purpose: Program to play rock/paper/scissors against the program
 */

package com.mthree.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static final int MIN_NUMBER_OF_ROUNDS = 1;
    static final int MAX_NUMBER_OF_ROUNDS = 10;
    static final int ROCK = 1;
    static final int PAPER = 2;
    static final int SCISSORS = 3;
    static final int TIE = 0;
    static final int COMPUTER_WIN = -1;
    static final int USER_WIN = 1;

    public static int playSingleGame() {
        Scanner scanner = new Scanner(System.in);
        int rockPaperScissorsPlayer;
        int rockPaperScissorsComputer;
        
        do {
            System.out.println("\n***************************************");
            System.out.println("Pick Rock(1), Paper(2), or Scissors(3).");
            rockPaperScissorsPlayer = scanner.nextInt();
        } while (rockPaperScissorsPlayer != 1 && rockPaperScissorsPlayer != 2 && rockPaperScissorsPlayer != 3);
        System.out.println("You picked...");
        printSelection(rockPaperScissorsPlayer);

        Random rand = new Random();
        rockPaperScissorsComputer = rand.nextInt(3);
        rockPaperScissorsComputer += 1;
        System.out.println("Computer picks...");
        printSelection(rockPaperScissorsComputer);

        return findWinnerOfSingleGame(rockPaperScissorsPlayer, rockPaperScissorsComputer);
    }
    
    public static int findWinnerOfSingleGame(int player, int computer) {
        if (player == computer) {
            System.out.println("Tie!");
            return TIE;
        } else if (player == ROCK) {
            if (computer == PAPER) {
                System.out.println("Computer Wins!");
                return COMPUTER_WIN;
            } else {
                System.out.println("User Wins!");
                return USER_WIN;
            }
        } else if (player == PAPER) {
            if (computer == ROCK) {
                System.out.println("User Wins!");
                return USER_WIN;
            } else {
                System.out.println("Computer Wins!");
                return COMPUTER_WIN;
            }
        } else {
            if (computer == ROCK) {
                System.out.println("Computer Wins!");
                return COMPUTER_WIN;
            } else {
                System.out.println("User Wins!");
                return USER_WIN;
            }
        }
    }
    
    public static void findOverallWinner(int ties, int computerWins, int userWins) {
        System.out.println();
        System.out.println("******Overall Stats******");
        System.out.println("Ties: " + ties);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("User Wins: " + userWins);
        if (userWins > computerWins) {
            System.out.println("User Wins!");
        } else if (userWins < computerWins) {
            System.out.println("Computer Wins!");
        } else {
            System.out.println("Tie!");
        }
    }
    
    public static void printSelection(int selection) {
        switch (selection) {
            case ROCK -> System.out.println("Rock");
            case PAPER -> System.out.println("Paper");
            case SCISSORS -> System.out.println("Scissors");
            default -> System.out.println("Error!");
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playAgain;
        
        do {
            int ties = 0;
            int computerWins = 0;
            int userWins = 0;
            
            System.out.println("\nHow many rounds of rock/paper/scissors would you like to play? (between 1-10 inclusive) ");
            int numberOfRounds = scanner.nextInt();
            if (numberOfRounds < MIN_NUMBER_OF_ROUNDS || numberOfRounds > MAX_NUMBER_OF_ROUNDS) {
                System.out.println("Invalid number of rounds!");
                break;
            }
                
            for (int i = 0; i < numberOfRounds; i++) {
                int outcome = playSingleGame();
                if (outcome == TIE) {
                    ties++;
                }
                if (outcome == COMPUTER_WIN) {
                    computerWins++;
                }
                if (outcome == USER_WIN) {
                    userWins++;
                }
            }
            
            findOverallWinner(ties, computerWins, userWins);
            
            do {
                System.out.println("Play again? (0=no 1=yes)");
                playAgain = scanner.nextInt();
            } while (playAgain != 0 && playAgain != 1);
            
        } while (playAgain == 1);
        
        System.out.println("********Game Over********");
    }
}
