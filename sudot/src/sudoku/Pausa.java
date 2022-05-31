package sudoku;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.stage.Modality;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author jpc
 */
public class Pausa implements Initializable {
    
    @FXML
    public Label Pausa;
    @FXML
    public Label Timer;
    @FXML
    public Button Menu;
    @FXML
    public Button Retomar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    } 
    
    public void buttonMenuPressed() throws Exception {
        try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Niveiscene.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.NONE);
                stage.setTitle("Dificuldade");
                stage.setScene(new Scene(root));
                stage.show();
                
                Stage thisStage = (Stage) Pausa.getScene().getWindow();
                thisStage.close();
                thisStage = null; //libertar memória
            } 
            catch (IOException e) {}
    }
    
    public void buttonRetomarPressed() throws Exception {
        try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Niveiscene.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.NONE);
                stage.setTitle("Dificuldade");
                stage.setScene(new Scene(root));
                stage.show();
                
                Stage thisStage = (Stage) Pausa.getScene().getWindow();
                thisStage.close();
                thisStage = null; //libertar memória
            } 
            catch (IOException e) {}
    }
}
