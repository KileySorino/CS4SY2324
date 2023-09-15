/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex03_cha_sorinoks;

/**
 *
 * @author Kiley
 */
public class Singer {
    
    private static int totalPerformances; 
    private String name, favSong;
    private int noOfPerformances;
    private double earnings;
    
    public Singer(String n, int num, double earn, String s){
        name = n;
        noOfPerformances = num;
        earnings = earn;
        favSong = s;
        totalPerformances = noOfPerformances;
        
    }
    
    public void performForAudience(int numOfPeople){
        System.out.println("===");
        System.out.println(name + ":");
        System.out.println(" ");
        System.out.println("Before: ");
        System.out.println("Performances: " + noOfPerformances);
        System.out.println("Earnings: " + earnings);
        noOfPerformances++;
        earnings += 100*numOfPeople;
        System.out.println(" ");
        System.out.println("After: ");
        System.out.println("Performances: " + noOfPerformances);
        System.out.println("Earnings: " + earnings);
        System.out.println(" ");
    }
    
    public void performForAudience(int numOfPeople, Singer singer){
        //fuck but uh name = other singer
        
        totalPerformances = noOfPerformances + singer.noOfPerformances;
        
        System.out.println("===");
        System.out.println(name + ":");
        System.out.println(" ");
        System.out.println("Before: ");
        System.out.println("Performances: " + noOfPerformances);
        System.out.println("Earnings: " + earnings);
        
        noOfPerformances++;
        earnings += 50*numOfPeople;
       
        System.out.println(" ");
        System.out.println("After: ");
        System.out.println("Performances: " + noOfPerformances);
        System.out.println("Earnings: " + earnings);
        System.out.println(" ");
        
        System.out.println("---");
        System.out.println(singer.name + ":");
        System.out.println(" ");
        System.out.println("Before: ");
        System.out.println("Performances: " + singer.noOfPerformances);
        System.out.println("Earnings: " + singer.earnings);
        
        singer.noOfPerformances++;
        singer.earnings += 50*numOfPeople;
        
        System.out.println(" ");
        System.out.println("After: ");
        System.out.println("Performances: " + singer.noOfPerformances);
        System.out.println("Earnings: " + singer.earnings);
        System.out.println(" ");
        
        
        totalPerformances++;
        System.out.println(totalPerformances);
    }

    public void changeFavSong(String newSong){
        System.out.println(" ");
        System.out.println("===");
        System.out.println("Previous Favorite Song: " + favSong);
        favSong = newSong;
        System.out.println("New Favorite Song: " + favSong);
        System.out.println(" ");
    }
    
}
