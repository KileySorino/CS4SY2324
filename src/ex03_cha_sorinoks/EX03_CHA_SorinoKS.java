/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex03_cha_sorinoks;

/**
 *
 * @author Kiley
 */
public class EX03_CHA_SorinoKS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        HSRChar Herta = new HSRChar("Herta", "Herta Space Station", 4, "Erudition", "Ice");
        HSRChar Gepard = new HSRChar("Gepard", "Belobog", 5, "Preservation", "Ice");
        HSRChar DanHengIL = new HSRChar("Dan Heng IL", "The Xianzhou Luofu", 5, "Destruction", "Imaginary");
        
        Song One = new Song(1, "Samudrartha", "Svah Sanishyu", "2m 52s", "Yusuf");
        Song Two = new Song(2, "Wildfire", "Of Snow and Ember", "3m 38s", "Jonathan Steingard");
        Song Three = new Song(3, "Take the Journey", "Out of Control", "1m 49s", "Anthony Lynch");
        
        Singer Serval = new Singer("Serval Laundau", 5, 2000, "Detect My Love");
        Singer Pela = new Singer("Pelageya Sergeyevna", 3, 1500, "Yume No Dead End");
        
        One.displaySong();
        Two.displaySong();
        Three.displaySong();
        
       
        Serval.changeFavSong("Sana ako na lang");
       
        Serval.performForAudience(10, Pela);
        
    }
    
}
