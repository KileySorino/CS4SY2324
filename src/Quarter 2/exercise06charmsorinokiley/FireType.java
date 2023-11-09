/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise06charmsorinokiley;

/**
 *
 * @author Kiley
 */
public class FireType extends SimpleMonster {
    
    /*FireType: a Monster that has a type "fire", strong against "grass", weak against "water", and whose atk is 1.3 times the base value and def is 0.7 times the base value. 
    The special of FireTypes increase their atk by 2 points at the cost of reducing their HP by 10% of their maxHP.

*/
    public FireType(String n, int m, int base) {
        super(n, "fire", "grass", "water", m, base);
        atk = (int) (1.3 * base);
        def = (int) (0.7 * base);
}        
    
    @Override
    public void special(){
        atk += 2;
        hp -= maxHP * 0.1;
        System.out.println(name + " Attack Increase!\n" + "Current Attack: " + this.atk + "! | Current HP: " + this.hp + "\n");
    }
    
    
}
