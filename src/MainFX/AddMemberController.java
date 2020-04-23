
package MainFX;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lazar NIkolovski
 */
public class AddMemberController implements Initializable {

    
    Connection conn;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Otrov";
    private static final String CONN_STRIGN = "jdbc:mysql://127.0.0.1:3306/MainFX";   
    
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    @FXML
    public void addMemberScreenButtonPushed (ActionEvent event) throws IOException {
        
        Parent addMemberScreenParent = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        Scene addMemberScreenScene = new Scene(addMemberScreenParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(addMemberScreenScene);
        window.show();
    }    
    @FXML
    public void AddMemberButtonListener (ActionEvent event) throws IOException {
        
        String mem_fname = firstNameField.getText();
        String mem_lname = lastNameField.getText();
        int mem_id = 0;
        double mem_balance = 0.0; 
        
        //Trying to connect to the databaase or catch the error if doens't connect
        try {
            conn = DriverManager.getConnection(CONN_STRIGN, USERNAME, PASSWORD);
            System.out.println("Connected!"); 
            
            Statement stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM mainfx.member ORDER BY mem_id desc limit 1;");
            
            int memberIdentification = 0;
            
            while (rs.next()){
                memberIdentification = rs.getInt("mem_id");
            }
            mem_id = autoIncrementMemID(memberIdentification);
            
            String dbop = "INSERT INTO MEMBER VALUES('"+mem_id+"', '"+mem_fname+"', '"+mem_lname+"', '"+mem_balance+"')";
            
            stmt.execute(dbop);
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"The Member Has been added to the Library database!\n The member id is " + mem_id);
            
            
        } catch (SQLException e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error! Please Try again!");
        }
        
        //I'm using this just to make sure that I have the programm reading properly from the User Interface
        System.out.println("name " + mem_fname);
        System.out.println("Surname " + mem_lname);
        System.out.println("Member number " + mem_id);
        System.out.println("Balance: " + mem_balance);
    }
    public int autoIncrementMemID (int memberIdentification) {
        
        int x = memberIdentification + 1;
        return x;
        
    }//end of autoIncrementMemID method
}//end of AddMember controller class 
