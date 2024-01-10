/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise09charmsorinokiley;

/**
 *
 * @author Kiley
 */
import java.util.*;

public class Trainer {
    protected String name;
    protected Monster activeMonster;
    protected ArrayList<Monster> team = new ArrayList<>();

    public Trainer(String n){
        this.name = n;
        this.activeMonster = null;
        this.team = new ArrayList<>();
    }
    
    public String getName(){
        return name;
    }

    public Monster getActiveMonster(){
        return activeMonster;
    }
    public ArrayList<Monster> getTeam(){
        return team;
    }

    public void capture(Monster m){
        if(m.getHP() < m.getMaxHP()*0.2){
            team.add(m);
            System.out.println(this.getName() + " caught " + m.getName() + ".");
        }
        else{
            System.out.println(this.getName() + " failed to catch " + m.getName() + ".");
        }
    }
    public void battle(Monster m){
        activeMonster.attack(m);
    }
    public void battle(Trainer t){
        activeMonster.attack(t.getActiveMonster());
    }
    public void sureCapture(Monster m) throws AlreadyCapturedException, FullTeamException{
        boolean found = false;
        for(Monster i : team){
            if(i.getName().equals(m.getName())){
                found = true;
                throw new AlreadyCapturedException("[Monster is already in Trainer's Team.]");
            }}
        
        if(team.size() < 6){
            team.add(m);
            System.out.printf("%s was successfully captured.\n", m.getName());
        }
        else{
            throw new FullTeamException("[Team is already full.]");
        }
                       
    }
    public void release(Monster m) throws NotInTeamException {
        boolean found = false;
        for(Monster i : team){
            if(i.getName().equals(m.getName())){
                found = true;
                team.remove(m);
                System.out.printf("%s was released from the team.\n", m.getName());
                
            }}
        if(!found){
            throw new NotInTeamException ("[Monster is not in Trainer's Team.]");
        
        }
        
    }
    

}

