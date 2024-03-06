/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise13charmsorinokiley;

/**
 *
 * @author Kiley
 */
import java.util.*;

public class Subject {
    private String name, imgFileName;
    private double units, grade;
    private static ArrayList<Subject> subjectList = new ArrayList();
	
    public Subject(String n, String i, double u, double g){
        name = n;
        imgFileName = i;
        units = u;
        grade = g;
	subjectList.add(this);
    }
    public String getName() {
        return name;
    }
    public String getImgFileName(){
        return imgFileName;
    }
    public double getUnits() {
        return units;
    }
    public void setUnits(double units) {
        units = units;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        grade = grade;
    }
    public static int getListLength() {
        return subjectList.size();
    }
    public static int getSubjectIndex(Subject s) throws NullPointerException {
        if(subjectList.contains(s)) return subjectList.indexOf(s);
        else throw new NullPointerException();
    }
    public static int getSubjectIndex(String s) throws NullPointerException {
        if(subjectList.contains(searchSubject(s))) return subjectList.indexOf(searchSubject(s));
        else throw new NullPointerException();
    }
    public static Subject searchSubject(String search) throws NullPointerException {
        for(Subject s : subjectList){
            if(s.getName().equalsIgnoreCase(search)) return s;
        }
        throw new NullPointerException();
    }
    public static Subject searchSubject(int index) throws IndexOutOfBoundsException {
        return subjectList.get(index);
    }

    
    public Subject newSubject(Subject d, String w){
        int j = 0;
         for(Subject s : subjectList){
            if(s.getName().equals(d.getName())){
                break;
            } 
            j++; 
        }
         
        int i = j;
        
        if(w.equals("next")){
        i++;
        }
        else{
        i--;}
        
    	if( i > subjectList.size() - 1) {
            i = subjectList.size();
        } 
        else if(i < 0){
            i = 0;}
        return subjectList.get(i);
                
    
    }
}
