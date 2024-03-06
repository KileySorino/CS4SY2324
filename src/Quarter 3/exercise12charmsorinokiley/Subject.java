/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise12charmsorinokiley;

import java.util.ArrayList;

/**
 *
 * @author Kiley
 */
public class Subject {
    protected String name, imgFileName;
    protected double units, grade;
    protected static ArrayList<Subject> subjectList = new ArrayList<>();
	
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
    public void setUnits(double newUnits) {
        units = newUnits;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double newGrade) {
        grade = newGrade;
    }
    public static ArrayList<Subject> getSubjectList() {
        return subjectList;
    }
    
    
    public Subject nextSubject(Subject d){
        int j = 0;
         for(Subject s : subjectList){
            if(s.getName().equals(d.getName())){
                break;
            } 
            j++; 
        }
         
        int i = j;
        i++;
        
    	if( i > subjectList.size() - 1) {
            i = 0;
        } 
        return subjectList.get(i);
                
    
    }
}
