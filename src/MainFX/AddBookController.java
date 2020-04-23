package MainFX;

import java.sql.*;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lazar NIkolovski
 */
public class AddBookController implements Initializable, IdentifierGenerator {

    
    Connection conn;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Otrov";
    private static final String CONN_STRIGN = "jdbc:mysql://127.0.0.1:3306/MainFX";    
    
    
    @FXML
    private TextField autorFnameField;
    @FXML
    private TextField autorLnameField;
    @FXML
    private TextField bookTitleField;
    @FXML
    private TextField isbnField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    @FXML
    public void addBookScreenButtonPushed (ActionEvent event) throws IOException {
        
        Parent addBookScreenParent = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        Scene addBookScreenScene = new Scene(addBookScreenParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(addBookScreenScene);
        window.show();
    }    
    @FXML
    public void addBookButtonListener (ActionEvent event) throws IOException {
        //Pulling the infomration fro the User interface - Add Book ccreen
        
        int book_id = 0;
        String autorFname = autorFnameField.getText();
        String autorLname = autorLnameField.getText();
        String bookTitle = bookTitleField.getText();
        String isbn = isbnField.getText();
        String book_aveliable = "1";
        
        //Trying to connect to the databaase or catch the error if doens't connect
        try {
            conn = DriverManager.getConnection(CONN_STRIGN, USERNAME, PASSWORD);
            System.out.println("Connected!"); 
            
            Statement stmt = conn.createStatement();
            
            java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM mainfx.member ORDER BY mem_id desc limit 1;");
            
            int bookIcrementID = 0;
            
            while (rs.next()){
                bookIcrementID = rs.getInt("book_id");
            }
            book_id = autoIncrement(bookIcrementID);
            
            String dbop = "INSERT INTO BOOK VALUES('"+book_id+"', '"+autorFname+"', '"+autorLname+"', '"+bookTitle+"', '"+isbn+"', '"+book_aveliable+"')";
            
            stmt.execute(dbop);
            stmt.close();
            JOptionPane.showMessageDialog(null,"The book Has been added to the Library database!");
            
        } catch (SQLException e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error! Please Try again!");
        }
        
        //I'm using this just to make sure that I have the programm reading properly from the User Interface
        System.out.println("name " + autorFname);
        System.out.println("Surname " + autorLname);
        System.out.println("Title " + bookTitle);
        System.out.println("ISBN: " + isbn);
        
        
    }
    public int autoIncrement (int ai) {
        
        int x = ai + 1;
        return x;
        
    }//end of autoIncrementID menthod
    
}//end of AddBookController class

