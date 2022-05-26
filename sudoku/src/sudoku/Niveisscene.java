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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    public class SceneController {

        private Stage stage;
        private Scene scene;
        private Parent root;
    }

    public void buttonFacilPressed(ActionEvent event) throws Exception {
    }

    public void buttonMedioPressed() {

    }

    public void buttonDificilPressed() {

    }

}
