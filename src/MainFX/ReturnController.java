/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFX;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lazar NIkolovski
 */
public class ReturnController implements Initializable {

    @FXML
    private TextField user_id_inputField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void returnScreenButtonPushed (ActionEvent event) throws IOException {
        
        Parent returnScreenParent = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        Scene returnScreenScene = new Scene(returnScreenParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(returnScreenScene);
        window.show();
    }
    @FXML
    public void returnScreenButtonListener(ActionEvent event) throws IOException {
        
        String userID = user_id_inputField.getText();
        
        System.out.println("USER ID; " + userID);
    }
}
