/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercise07charmsorinokiley;

/**
 *
 * @author Kiley
 */
public class Exercise07charmsorinokiley {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FireType Diting = new FireType("Diting", 100, 47);
        
        Location XL = new Location( "Xianzhou Luofu", "Immortal's Delight");
        
        NPC Qingni = new NPC("Qingni", XL);
        
        Trainer Yukong = new Trainer("Yukong", XL);
        
        Yukong.inspect(Diting);
        Yukong.inspect(XL);
        Yukong.inspect(Qingni);
        
 
    }
    
}
