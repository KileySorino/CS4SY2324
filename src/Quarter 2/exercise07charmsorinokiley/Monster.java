/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise07charmsorinokiley;

import java.util.ArrayList;

/**
 *
 * @author Kiley
 */


import java.util.ArrayList;

public abstract class Monster implements Interactive{
    protected final String name, type, strongAgainst, weakAgainst;
    protected int maxHP, hp, atk, baseAtk, def, baseDef, xp, lvl;
    protected boolean guard, charge;
    protected static ArrayList<Monster> monsterList = new ArrayList<>();

    public Monster(String n, String t, String s, String w, int m, int base){
        name = n;
        type = t;
        strongAgainst = s;
        weakAgainst = w;
        maxHP = m;
        hp = m;
        baseAtk = atk = base;
        baseDef = def = base;
        xp = 0;
        lvl = 1;
        monsterList.add(this);
        guard = false;
        charge = false;
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
    
    public int getXP(){
        return xp;
    }
    
    public int getLvl(){
        return lvl;
    }
    
    public static ArrayList<Monster> getMonsterList() {
        return monsterList;
    }

    public void attack(Monster m){
        int damage = (int) ((atk*atk)/(double)(atk+m.getDef()));    // damage is calculated as double, then cast as int
        boolean strong = false, weak = false;
        if(strongAgainst.equals(m.type)){
            damage *= 2;
            strong = true;
        }
        if(weakAgainst.equals(m.type)){
            damage *= 0.5;
            weak = true;
        }
        if(m.guard){
            m.guard = false;
            damage *= 0.7;
        }
        if(charge){
            charge = false;
            damage *= 1.3;
        }
        m.hp -= damage;
        if(m.hp < 0) m.hp = 0;
            System.out.println(name  + " attacked " + m.getName() +
            " and dealt " + damage + " damage, reducing it to " + m.getHP() + "HP.");
        if(strong) System.out.println("It was super effective!");
        if(weak) System.out.println("It wasn't very effective...");
        gainXP(2);                                                  // every attack raises XP by 2

        if(m.getHP() <= 0){
            m.hp = 0;
            System.out.println(m.getName() + " fainted.");
            gainXP(10);                                             // defeating a monster raises XP by 10
        }
        System.out.println(" "); // Add a new line for easier readability
    }

    public void guard(){
        guard = true;
        System.out.println(name + " put up its guard. It will receive 30% less damage on the next attack.");
    }

    public void charge(){
        charge = true;
        System.out.println(name + " charged. Its next attack will do 30% more damage.");
    }

    public void rest(){
        hp += maxHP * 0.15;
        if(hp > maxHP) hp = maxHP;
        System.out.println(name + " rested. It's health is now " + hp + ".");
    }

    public abstract void special();

    public void resetHealth(){
        hp = maxHP;
    }
    
    
    public void restoreAtk(){
        atk = baseAtk;
    }
    
    public void restoreDef(){
        atk = baseDef;
    }
    
    public void restoreStats(){
        resetHealth();
        restoreAtk();
        restoreDef();
    }
    
     public static void fight(Monster attacker, Monster defender){
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
                    System.out.println(attacker.getName() + " Level and XP is now: Lvl " + attacker.getLvl() + " | XP " + attacker.getXP());
                    System.out.println("\n===== Fight End! =====");
                    winnerAnnounced = true;
                    
                }
                else{
                    System.out.println(defender.getName() + " wins!!!");
                    System.out.println(defender.getName() + " Level and XP is now: Lvl " + defender.getLvl() + " | XP " + defender.getXP());
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
                    System.out.println(attacker.getName() + " Level and XP is now: Lvl " + attacker.getLvl() + " | XP: " + attacker.getXP());
                    System.out.println("\n===== Fight End! =====");
                    break;
                }
            }
        }}


    // handles all increases in XP
    private void gainXP(int i){
        xp += i;
        if(xp >= 100){
            xp %= 100;
            lvl++;
            maxHP += 5;
            hp += 5;
            atk += 2;
            def += 2;
            System.out.println(name + " levelled up to " + lvl + "!");
        }
    }
    
    @Override
    public void interact(){
        System.out.println(name + " | Type: " + type);
    }

}

