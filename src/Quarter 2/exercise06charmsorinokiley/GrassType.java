/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise06charmsorinokiley;

/**
 *
 * @author Kiley
 */
public class GrassType extends SimpleMonster {
    /*
GrassType: a Monster that has a type "grass", strong against "water", weak against "fire", and whose atk and def is equal to the base value. 
    The rest() of GrassTypes heal by half the maxHP. The special of GrassTypes raise their health by 20% of the maxHP.
    

*/

    public GrassType(String n, int m, int base) {
        super(n, "grass", "water", "fire", m, base);
        atk = (int) base;
        def = (int) base;
    }
    
    public void rest(){
        hp += maxHP/2;
        System.out.println(name + " rested!");
        
        if (hp < maxHP){
            System.out.println("HP added!");
        }
        else {
            hp = maxHP;
            System.out.println("HP max!");
        }
        
        System.out.println("HP restored to: " + this.getHP() + "!\n");
    }
    
    @Override
    public void special(){
      hp += maxHP * 0.2;
      
      System.out.println(name + " used special!");
      
      if (hp < maxHP){
            System.out.println("HP added!");
        }
        else {
            hp = maxHP;
            System.out.println("HP max!");
        }
      
        System.out.println("HP restored to: " + this.getHP() + "!\n");
    }
}
