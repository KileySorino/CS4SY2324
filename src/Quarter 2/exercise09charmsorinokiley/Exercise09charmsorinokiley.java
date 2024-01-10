/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercise09charmsorinokiley;

/**
 *
 * @author Kiley
 */
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Exercise09charmsorinokiley {

    /**
     * @param args the command line arguments
     */
    


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int notfound = 0;
        int alreadycaptured = 0;
        int fullteam = 0;
        int notinteam = 0;
        
        Trainer player = new Trainer("Steve");
        Monster m0 = new Monster("RATTATA", "Normal", "None", "None", 15, 5);
        Monster m1 = new Monster("MEOWTH", "Normal", "None", "None", 15, 5);
        Monster m2 = new Monster("KANGASKHAN", "Normal", "None", "None", 15, 5);
        Monster m3 = new Monster("TAUROS", "Normal", "None", "None", 15, 5);
        Monster m4 = new Monster("DITTO", "Normal", "None", "None", 15, 5);
        Monster m5 = new Monster("EEVEE", "Normal", "None", "None", 15, 5);
        Monster m6 = new Monster("PORYGON", "Normal", "None", "None", 15, 5);
        Monster m7 = new Monster("SNORLAX", "Normal", "None", "None", 15, 5);
        Monster m8 = new Monster("SENTRET", "Normal", "None", "None", 15, 5);
        Monster m9 = new Monster("DUNSPARCE", "Normal", "None", "None", 15, 5);

        String input = "";
        String user = "";
        String monster = "";
        String name = "";
        
        while(!input.equals("EXIT")){
            boolean inArea = true;
            System.out.println("What will the trainer do? ");
            System.out.println("[ CATCH | RELEASE | EXIT ]");
            user = sc.nextLine();
            input = user.toUpperCase();
            
            Monster selected = null;
            if(input.equals("CATCH") || input.equals("RELEASE")){
                System.out.println("Which monster? ");
                
                name = sc.nextLine();
                monster = name.toUpperCase();
               
                try {
                    selected = Monster.selectMonster(monster);
                } catch (MonsterNotFoundException e) {
                    inArea = false;
                    notfound++;
                    System.out.println(e.getMessage());
                    continue;
                    
                }
                
            }
            
            switch(input){
                case "CATCH":
                    try{
                    player.sureCapture(selected);}
                    catch(AlreadyCapturedException e){
                        alreadycaptured++;
                        System.out.println(e.getMessage());
                    }
                    catch(FullTeamException e){
                        fullteam++;
                        System.out.println(e.getMessage());
                    }
                    finally {break;}
                    
                case "RELEASE":
                    try{
                    player.release(selected);}
                    catch(NotInTeamException e){
                        
                        notinteam++;
                        if(inArea == false){break;}
                        else{System.out.println(e.getMessage());}
                    }
                    finally{break;}
                case "EXIT":
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        }
        
        System.out.printf("Encountered errors:%n"
                + "MonsterNotFoundException: %d%n"
                + "AlreadyCapturedException: %d%n"
                + "FullTeamException: %d%n"
                + "NotInTeamException: %d%n", 
                notfound, alreadycaptured, fullteam, notinteam);
    }
    
}

    

