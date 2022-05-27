package sudoku;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;



/**
 * FXML Controller class
 *
 * @author claudior
 */
public class login implements Initializable {

    @FXML
    public TextField usernameTextField;
    @FXML
    public TextField passwordTextField;
    @FXML
    public TextField errorField;
    @FXML
    private PasswordField hiddenPasswordTextField;
    @FXML
    private CheckBox showPassword;
    
    File file = new File("loginData.csv");
    
    //contem <username, password>
    HashMap<String, String> loginInfo = new HashMap<>();
    
    Encryptor encryptor = new Encryptor();
    
    @FXML
    void changeVisibility(ActionEvent event) {
        if(showPassword.isSelected()){
            passwordTextField.setText(hiddenPasswordTextField.getText());
            passwordTextField.setVisible(true);
            hiddenPasswordTextField.setVisible(true);
            return;
        } 
        hiddenPasswordTextField.setText(passwordTextField.getText());
        hiddenPasswordTextField.setVisible(true);
        passwordTextField.setVisible(false);
    }
    
    @FXML
    private String getPassword() {
        if(passwordTextField.isVisible()){
            return passwordTextField.getText();
        } else {
            return hiddenPasswordTextField.getText();
        }
    }
    
    @FXML
    void loginHandler(ActionEvent event) throws IOException, NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        String username = usernameTextField.getText();
        String password = getPassword();
        updateUserAndPass();
        
        String encryptedPass = loginInfo.get(username);
        if (encryptor.encryptString(password).equals(encryptedPass)){
            System.out.println("sucss login");
            //mudar de scene
        } else {
            errorField.setVisible(true);
        }
        
    }
    
    @FXML
    private void updateUserAndPass() throws IOException {
        Scanner scanner = new Scanner(file);
        loginInfo.clear();
        loginInfo = new HashMap<>();
        while (scanner.hasNext()){
            String[] userAndPass = scanner.nextLine().split(",");
            loginInfo.put(userAndPass[0], userAndPass[1]);
        }
    }
    
    @FXML
    private void writeToFile() 
        
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
            
    }
}