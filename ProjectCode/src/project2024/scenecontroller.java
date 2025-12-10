/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2024;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javax.management.Query.value;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class scenecontroller {
 private Stage stage;
 private Scene scene;
 private Parent root;

    
    
     @FXML
    private TextField hoursField;

    @FXML
    private TextField minutfield;

    @FXML
    private Button reetbutton;

    @FXML
    private TextField secondsField;

    @FXML
    private Button startbutton;

    @FXML
    private Button stopbutton;

    @FXML
    private javafx.scene.control.Label timerlabel;

    @FXML
    private javafx.scene.control.Label title;
    
private int totalSeconds;
  
    @FXML
    void resetButtonAction(ActionEvent event) {

    }

    @FXML
    void startButtonAction(ActionEvent event) {

    }

    @FXML
    void stopButtonAction(ActionEvent event) {

    }

    
 public void switchToMap(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("map (1).fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }

 
 public void switchTocafe(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("cafe.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 public void switchTologin(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 public void switchTosignup(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 public void switchTolib(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("library.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
   
public void switchToTimer(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("timer.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }

}  