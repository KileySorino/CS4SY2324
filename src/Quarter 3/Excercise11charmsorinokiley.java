/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package exercise11charmsorinokiley;

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
public class Exercise11charmsorinokiley extends Application {
    Subject displayedSubject = null;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Subject Window");
        
        /*Subjects*/
        Subject math = new Subject("Math", "math.png", 4, 1.75);
        Subject bio = new Subject("Biology", "biology.png", 3, 2.0);
        Subject chem = new Subject("Chemistry", "chemistry.png", 3, 1.5);
        Subject physics = new Subject("Physics", "physics.png", 3, 1.75);
        Subject cs = new Subject("CS", "computer science.png", 1, 1.5);

        displayedSubject = math;
        
        
        /*Window*/
        FlowPane subject = new FlowPane();
        Scene scene = new Scene(subject, 550, 450);
        primaryStage.setScene(scene);
        
        
        /*Image*/
        ImageView subjectIcon = new ImageView();
        Image img = new Image(Subject.class.getResourceAsStream(displayedSubject.getImgFileName()));
        subjectIcon.setImage(img);
        subjectIcon.setFitHeight(100);
        subjectIcon.setFitWidth(100);
        subjectIcon.setPreserveRatio(true);
        subject.getChildren().add(subjectIcon);
        
        
        /*Subject Name*/
        Text subjectName = new Text(displayedSubject.getName());
        subjectName.setFill(Color.BLACK);
        subjectName.setFont(new Font("Book Antiqua", 20));
        subject.getChildren().add(subjectName);
        
        /*Units*/
        Text subjectUnit = new Text("Units: " + Double.toString(displayedSubject.getUnits()));
        subjectUnit.setFill(Color.BLACK);
        subjectUnit.setFont(new Font("Book Antiqua", 20));
        subject.getChildren().add(subjectUnit);
        
        /*Grade*/
        Text subjectGrade = new Text("Grade: " + Double.toString(displayedSubject.getGrade()));
        subjectGrade.setFill(Color.BLACK);
        subjectGrade.setFont(new Font("Book Antiqua", 20));
        subject.getChildren().add(subjectGrade);
        
        /*Button*/
        Button nextButton = new Button("Next ->");
        subject.getChildren().add(nextButton);
        
      
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) 
            { 
                displayedSubject = displayedSubject.nextSubject(displayedSubject);
                System.out.println(displayedSubject.getName());
                subjectName.setText(displayedSubject.getName());
                subjectUnit.setText("Units: " + Double.toString(displayedSubject.getUnits()));
                subjectGrade.setText("Grade: " + Double.toString(displayedSubject.getGrade()));
                Image newimg = new Image(Subject.class.getResourceAsStream(displayedSubject.getImgFileName()));
                subjectIcon.setImage(newimg);
            } 
        }; 
        
        nextButton.setOnAction(event);
        
        
        primaryStage.show();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
