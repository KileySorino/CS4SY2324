/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package exercise13charmsorinokiley;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 *
 * @author Kiley
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML private Label subjectName, subjectGrade;
    @FXML private Label subjectUnit;
    @FXML private ImageView subjectIcon;
    @FXML private Button next;
    @FXML private Button previous;
    @FXML private TextField search;
    @FXML private Text alert;
    private Image icon;
    Subject displayedSubject;
    
    @FXML
    private void nextSubject (){
        displayedSubject = displayedSubject.newSubject(displayedSubject, "next");
        check(displayedSubject);
        display(displayedSubject);
        
    }
    
    @FXML
    private void previousSubject(){
        displayedSubject = displayedSubject.newSubject(displayedSubject, "previous");
        check(displayedSubject);
        display(displayedSubject);
    }
    
    @FXML
    private void submitString(){
        if(search.getText().equalsIgnoreCase("")){
            alert.setVisible(false);
        }
        else{
            try{
                Subject.searchSubject(search.getText());
                alert.setVisible(false);
                displayedSubject = Subject.searchSubject(search.getText());
                check(displayedSubject);
                display(displayedSubject);
            }
            catch(NullPointerException e){
                alert.setVisible(true);
                submitInt();
            }
        
        }
    }
    
    private void submitInt(){
         try {
            int subjectIndex = Integer.parseInt(search.getText());
            displayedSubject = Subject.searchSubject(subjectIndex);
            alert.setVisible(false);
            check(displayedSubject);
            display(displayedSubject);
            }
        catch(NumberFormatException e){
            alert.setVisible(true);
            }
        catch(IndexOutOfBoundsException f){
            alert.setVisible(true);
            }
    }
    

    private void check(Subject s){
        if(s.getSubjectIndex(s)==0){
            previous.setVisible(false);
            next.setVisible(true);
        }
        else if(s.getSubjectIndex(s)==(s.getListLength()-1)){
            next.setVisible(false);
            previous.setVisible(true);
        }
        else{
            previous.setVisible(true);
            next.setVisible(true);
        }
        
    }
            
  
    
    private void display(Subject s){
        icon = new Image(Subject.class.getResourceAsStream(s.getImgFileName()));
        subjectIcon.setImage(icon);
        subjectName.setText(s.getName());
        subjectUnit.setText(Double.toString(s.getUnits()));
        subjectGrade.setText(Double.toString(s.getGrade()));
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Subject math = new Subject("Math", "math.png", 4, 1.75);
        Subject bio = new Subject("Biology", "biology.png", 3, 2.0);
        Subject chem = new Subject("Chemistry", "chemistry.png", 3, 1.5);
        Subject physics = new Subject("Physics", "physics.png", 3, 1.75);
        Subject cs = new Subject("CS", "computer science.png", 1, 1.5);
        
        alert.setVisible(false);

        displayedSubject = math;
        check(displayedSubject);
        display(displayedSubject);
    }    
    
}
