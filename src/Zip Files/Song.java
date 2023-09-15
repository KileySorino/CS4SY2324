/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex03_cha_sorinoks;

/**
 *
 * @author Kiley
 */
public class Song{
    private String name, album, length, performer;
    private int id;
    
    public Song(int i, String n, String a, String l, String p){
        id = i;
        name = n;
        album = a;
        length = l;
        performer = p;
    }
    
    public void displaySong(){
        System.out.println("Song Number: " + id);
        System.out.println("Name: " + name);
        System.out.println("Album: " + album);
        System.out.println("Length: " + length);
        System.out.println("Performer: " + performer);
        System.out.println(" ");
    }
}
