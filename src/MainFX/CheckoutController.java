/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainFX;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lazar NIkolovski
 */
public class CheckoutController implements Initializable {

    Connection conn;
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Otrov";
    private static final String CONN_STRIGN = "jdbc:mysql://127.0.0.1:3306/MainFX";   
    
    @FXML
    private Button search_book_button;
    @FXML
    private TextField search_titleField;
    @FXML
    private TextField search_authorField;
    @FXML
    private TextField search_isbnField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void checkoutScreenButtonPushed (ActionEvent event) throws IOException {
        
        Parent checkoutScreenParent = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        Scene checkoutScreenScene = new Scene(checkoutScreenParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(checkoutScreenScene);
        window.show();
    }
     public void CheckoutMemberButtonListener (ActionEvent event) throws IOException {
        
        String searchTitle = null; 
        String searchAuthor = null;
        String searchISBN = null;
        
        try {
            conn = DriverManager.getConnection(CONN_STRIGN, USERNAME, PASSWORD);
            System.out.println("Connected!"); 
            
            Statement stmt = conn.createStatement();
            
            searchTitle = search_titleField.getText();
            searchAuthor = search_authorField.getText();
            searchISBN = search_isbnField.getText();
            
            java.sql.ResultSet rs = null;
 
               rs = stmt.executeQuery("SELECT * FROM mainfx.book WHERE bookTitle = '"+searchTitle+"'"); 
               
                while (rs.next()){
                    System.out.println("Author Name " + rs.getString("authorFname"));
                    System.out.println("Author LastNAme " + rs.getString("authorLname"));
                    System.out.println("Book Title " + rs.getString("BookTitle"));
                    System.out.println("Avalibility " + rs.getString("book_aveliable"));
                }
  
        } catch (Exception e) {
        
            System.out.println("Error: " + e.getMessage());
        }
               
//         System.out.println("S Title " + searchTitle);
//         System.out.println("Authro " + searchAuthor);
//         System.out.println("ISBN " + searchISBN);
    }
}
