/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise06charmsorinokiley;

/**
 *
 * @author Kiley
 */
public class WaterType extends SimpleMonster {
      /*
WaterType: a Monster that has a type "water", strong against "fire", weak against "grass", and whose atk is 0.7 times the base value and def is 1.3 times the base value. 
    The special of WaterTypes increase their def by 2 points at the cost of reducing their HP by 10% of their maxHP.*/
    

    public WaterType(String n, int m, int base) {
        super(n, "water", "fire", "grass", m, base);
        atk = (int) (0.7 * base);
        def = (int) (1.3 * base);
        }
    
    
    @Override
    public void special(){
        def += 2;
        hp -= maxHP * 0.1;
        System.out.println(name + " Defense In
