/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex04_cha_sorinoks;

import java.util.Scanner;

/**
 *
 * @author Kiley
 */
public class EX04_CHA_SorinoKS {

    /**
     * @param args the command line arguments
     * 
     * 
     * 
     */
    
        private static Move rock, paper, scissors;
        private static int roundsToWin = 2, PlayerScore, ComputerScore;
        private static Scanner sc = new Scanner(System.in);
        
        public static String input(){
            return sc.nextLine();
        }
    

        public static void Intro(){

            System.out.println("Welcome to Rock, Paper, Scissors. Please choose an option:");
            System.out.println("1. Start game");
            System.out.println("2. Change number of rounds");
            System.out.println("3. Exit application");
                
            String option = sc.nextLine();
        
            switch (option){
                case "1" -> {
                    System.out.println("\nThis match will be first to " + roundsToWin +" wins.");
                    Game();
                }
            
                case "2" -> {
                    System.out.println("How many rounds would you like?");
                    String rounds = sc.nextLine();
                    roundsToWin = Integer.parseInt(rounds);
                    
                    if (roundsToWin < 1){System.out.println("Please pick a number greater than or equal to 1");
                    Intro();
                    }
                    
                    else{
                    System.out.println("\nRounds changed to: " + roundsToWin + " rounds!\n");
                    Intro();
                    }
                }

                case "3" -> System.out.println("Thank you for playing!");

                }
     
            }
        
        public static Move PlayerMove(){
            System.out.println("Select your move: \n 1. Rock\n 2. Paper\n 3. Scissors");
            String user = input();
            int userMove = Integer.parseInt(user);
            switch (userMove) {
                case 1 -> {
                    return rock; }
                case 2 -> {
                    return paper;}
                case 3 -> {
                    return scissors;}
                default -> {
                    System.out.println("Pick an integer from 1-3\n");
                    throw new IllegalArgumentException("Method only allows for integers from 1 to 3");
                    
                    
                }
            }
           
          
        }
        
        public static Move ComputerMove(){
            int random = (int) Math.floor(Math.random()*3) + 1;
            switch (random) {
                case 1 -> {
                    return rock;}
                case 2 -> {
                    return paper;}
                case 3 -> {
                    return scissors;}

            }
            return null;
        }
        
        public static void Game(){
            Move Cmove, Pmove;
            int winRound;
            String result = null;
            
            
            
            Cmove = ComputerMove();
            System.out.println("\nThe computer has selected its move.\n");
            Pmove = PlayerMove();
            
                         
                winRound = Move.compareMoves(Cmove, Pmove);
                        
                switch(winRound){
                    case 0 -> {
                        ComputerScore++;
                        result = "Computer Wins this round";
                        }
                    
                    case 1 -> {
                        PlayerScore++;
                        result = "Player Wins this round";
                        }
                    case 2 ->{
                        result = "This round is a Tie!";
                        }
                    }
                
                System.out.println("Player chose "+ Pmove.getName() + ". Computer chose " + Cmove.getName() + ".");
                System.out.println(result);
                
                System.out.println("Player: " + PlayerScore + " - Computer: " + ComputerScore);

            
            if (roundsToWin != PlayerScore && roundsToWin != ComputerScore){
                Game();
            }
            
            else if (roundsToWin == PlayerScore){
                System.out.println("Player wins!\n");
                ComputerScore = 0;
                PlayerScore = 0;
                Intro();
            }
            
            else {
                System.out.println("Computer wins!\n");
                ComputerScore = 0;
                PlayerScore = 0;
                Intro();
            }
           
        
        }
      
    public static void main(String[] args) {
        rock = new Move("Rock");
	paper = new Move("Paper");
	scissors = new Move("Scissors");
		
	rock.setStrongAgainst(scissors);
	paper.setStrongAgainst(rock);
	scissors.setStrongAgainst(paper);
        
        Intro();
        
    }
    
}
