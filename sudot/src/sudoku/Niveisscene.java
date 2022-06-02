package sudoku;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author claudior
 */
public class Niveisscene implements Initializable {

    @FXML
    Button button_Facil;
    @FXML
    Button button_Dificil;
    @FXML
    Button button_Medio;
    @FXML
    Label label1;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    public void buttonFacilPressed(ActionEvent event) throws Exception {
        try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("primarypage.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.NONE);
                stage.setTitle("sudoku");
                stage.setScene(new Scene(root));
                stage.show();
                
                primarypage primarypage = fxmlLoader.getController();
                primarypage.receiveDif(1);
                
                Stage thisStage = (Stage) label1.getScene().getWindow();
                thisStage.close();
                thisStage = null; //libertar memória
            } 
            catch (IOException e) {}
    }

    public void buttonMedioPressed(ActionEvent event) throws IOException{
        try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("primarypage.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.NONE);
                stage.setTitle("sudoku");
                stage.setScene(new Scene(root));
                stage.show();
                
                primarypage primarypage = fxmlLoader.getController();
                primarypage.receiveDif(2);
                
                Stage thisStage = (Stage) label1.getScene().getWindow();
                thisStage.close();
                thisStage = null; //libertar memória
            } 
            catch (IOException e) {}
    }
    
    public void buttonDificilPressed(ActionEvent event) throws IOException {
        try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("primarypage.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.NONE);
                stage.setTitle("sudoku");
                stage.setScene(new Scene(root));
                stage.show();
                
                primarypage primarypage = fxmlLoader.getController();
                primarypage.receiveDif(3);
                
                Stage thisStage = (Stage) label1.getScene().getWindow();
                thisStage.close();
                thisStage = null; //libertar memória
            } 
            catch (IOException e) {}
    }

}
