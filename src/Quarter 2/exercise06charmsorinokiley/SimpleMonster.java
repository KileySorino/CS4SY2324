/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise06charmsorinokiley;

import java.util.ArrayList;

/**
 *
 * @author Kiley
 */


public class SimpleMonster {
   protected final String name, type, strongAgainst, weakAgainst;
   protected int maxHP;
   protected int hp, atk, def, xp, lvl, baseAtk, baseDef;
   protected static ArrayList<SimpleMonster> monsterList = new ArrayList<>();
   
   // private fields changed to protected

    public SimpleMonster(String n, String t, String s, String w, int m, int base){
        name = n;
        type = t;
        strongAgainst = s;
        weakAgainst = w;
        maxHP = m;
        hp = m;
        baseAtk = atk = base;
        baseDef = def = base;
        monsterList.add(this);
    }

    public String getName() {
        return name;
    }
    public int getMaxHP() {
        return maxHP;
    }
    public int getHP() {
        return hp;
    }
    public int getAtk() {
        return atk;
    }
    public int getDef() {
        return def;
    }
    public static ArrayList<SimpleMonster> getMonsterList() {
        return monsterList;
    }

    public void attack(SimpleMonster m){
        int damage = (int) ((atk*atk)/(double)(atk+m.getDef()));    // damage is calculated as  double, then cast as int
        boolean strong = false, weak = false;
        if(strongAgainst.equals(m.type)){
            damage *= 2;
            strong = true;
        }
        if(weakAgainst.equals(m.type)){
            damage *= 0.5;
            weak = true;
        }
        m.hp -= damage;
        if(m.hp < 0) m.hp = 0;
            System.out.println(name  + " attacked " + m.getName() +
            " and dealt " + damage + " damage, reducing it to " + m.getHP() + "HP.");
        if(strong) System.out.println("It was super effective!");
        if(weak) System.out.println("It wasn't very effective...");

        if(m.hp <= 0){
            m.hp = 0;
            System.out.println(m.getName() + " fainted.");
        }
        System.out.println(" "); // Add a new line for easier readability
    }

    public void special(){
        System.out.println(name + " did a pose.");
    }

    public void restoreHealth(){
        hp = maxHP;
    }
    
    public void restoreAtk(){
        atk = baseAtk;
    }
    
    public void restoreDef(){
        atk = baseDef;
    }
    
    public void restoreStats(){
        restoreHealth();
        restoreAtk();
        restoreDef();
    }
    
     public static void fight(SimpleMonster attacker, SimpleMonster defender){
        boolean winnerAnnounced = false;
        attacker.restoreStats();
        defender.restoreStats();
        
        System.out.println("\nNEW FIGHT!!!\n");
        System.out.println("===== Fight Start! =====\n");
        System.out.println("===== " + attacker.getName() + " vs " + defender.getName() + " =====\n");
        
        attacker.special();
        defender.special();
        
        while(winnerAnnounced != true){
                     
            if(attacker.getHP() == 0 || defender.getHP() == 0){
              System.out.println("We have a winner!!!");
              if (attacker.getHP() > defender.getHP()){
                    System.out.println(attacker.getName() + " wins!!!");
                    System.out.println("\n===== Fight End! =====");
                    winnerAnnounced = true;
                    
                }
                else{
                    System.out.println(defender.getName() + " wins!!!");
                    System.out.println("\n===== Fight End! =====");
                    winnerAnnounced = true;
                    
                }
            
            
            }else {
                attacker.attack(defender);
                if(defender.getHP() != 0){
                defender.attack(attacker);
                }
                
                else{
                    System.out.println("We have a winner!!!");
                    winnerAnnounced = true;
                    System.out.println(attacker.getName() + " wins!!!");
                    System.out.println("\n===== Fight End! =====");
                    break;
                }
            }
      
        }
    }

}



