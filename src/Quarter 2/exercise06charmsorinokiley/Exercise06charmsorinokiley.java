/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercise06charmsorinokiley;

/**
 *
 * @author Kiley
 */
public class Exercise06charmsorinokiley {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FireType Charmander = new FireType("Charmander", 100, 48);
        Charmander.special();
        
        WaterType Squirtle = new WaterType("Squirtle", 100, 42);
        Squirtle.special();
        
        GrassType Bulbasaur = new GrassType("Bulbasaur", 100, 45);
        Bulbasaur.special();
        Bulbasaur.rest();
       
        
        
        SimpleMonster.fight(Bulbasaur, Charmander);
        
        SimpleMonster.fight(Squirtle, Charmander);
        
        SimpleMonster.fight(Squirtle, Bulbasaur);
        
    }
    
}
