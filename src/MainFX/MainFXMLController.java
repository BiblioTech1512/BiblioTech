
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lazar NIkolovski
 */
public class MainFXMLController implements Initializable {

    @FXML
    private Button button_checkout;
    @FXML
    private Button Button_return;
    @FXML
    private Button button_addBook;
    @FXML
    private Button button_addMember;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    //@FXML
    public void checkoutScreenButtonPushed (ActionEvent event) throws IOException {
        
        Parent checkoutScreenParent = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
        Scene checkoutScreenScene = new Scene(checkoutScreenParent);
        
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window1.setScene(checkoutScreenScene);
        window1.show();
    }
    
    public void returnScreenButtonPushed (ActionEvent event) throws IOException {
        
        Parent checkoutScreenParent = FXMLLoader.load(getClass().getResource("Return.fxml"));
        Scene checkoutScreenScene = new Scene(checkoutScreenParent);
        
        Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window2.setScene(checkoutScreenScene);
        window2.show();
    }
    public void addBookScreenButtonPushed (ActionEvent event) throws IOException {
        
        Parent checkoutScreenParent = FXMLLoader.load(getClass().getResource("AddBook.fxml"));
        Scene checkoutScreenScene = new Scene(checkoutScreenParent);
        
        Stage window3 = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window3.setScene(checkoutScreenScene);
        window3.show();
    }
    public void addMemberScreenButtonPushed (ActionEvent event) throws IOException {
        
        Parent checkoutScreenParent = FXMLLoader.load(getClass().getResource("AddMember.fxml"));
        Scene checkoutScreenScene = new Scene(checkoutScreenParent);
        
        Stage window4 = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window4.setScene(checkoutScreenScene);
        window4.show();
    }
    
    
    @FXML
    private void click_return(ActionEvent event) {
    }

    @FXML
    private void click_addBook(ActionEvent event) {
    }

    @FXML
    private void clieck_addMember(ActionEvent event) {
    }
  
}
