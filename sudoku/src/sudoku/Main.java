package sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jpc
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent login = FXMLLoader.load(getClass().getResource("Niveisscene.fxml"));
        //Scene scene = new Scene(login);
        //scene.getStylesheets().add("/css/css.css");
        stage.setTitle("login");
        stage.setScene(new Scene(login));
        stage.show();
    }
    /**
     * @param args designed without arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
