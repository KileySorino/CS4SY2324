/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package exercise12charmsorinokiley;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Kiley
 */
public class ViewController implements Initializable {
    
    
    @FXML private Label subjectName1, subjectName2, subjectGrade1, subjectGrade2;
    @FXML private Label subjectUnit1, subjectUnit2;
    @FXML private ImageView subjectIcon1, subjectIcon2;
    private Image icon1, icon2;
    Subject displayedSubject, nextSubject;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        displayedSubject = displayedSubject.nextSubject(displayedSubject);
        display(displayedSubject);
        
        
    }
    
    private void display(Subject s) {
        icon1 = new Image(Subject.class.getResourceAsStream(s.getImgFileName()));
        subjectIcon1.setImage(icon1);
        subjectName1.setText(s.getName());
        subjectUnit1.setText(Double.toString(s.getUnits()));
        subjectGrade1.setText(Double.toString(s.getGrade()));
        
        nextSubject = s.nextSubject(s);
        icon2 = new Image(Subject.class.getResourceAsStream(nextSubject.getImgFileName()));
        subjectIcon2.setImage(icon2);
        subjectName2.setText(nextSubject.getName());
        subjectUnit2.setText(Double.toString(nextSubject.getUnits()));
        subjectGrade2.setText(Double.toString(nextSubject.getGrade()));
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Subject math = new Subject("Math", "math.png", 4, 1.75);
        Subject bio = new Subject("Biology", "biology.png", 3, 2.0);
        Subject chem = new Subject("Chemistry", "chemistry.png", 3, 1.5);
        Subject physics = new Subject("Physics", "physics.png", 3, 1.75);
        Subject cs = new Subject("CS", "computer science.png", 1, 1.5);

        displayedSubject = math;
        display(displayedSubject);
    }    
    
}
