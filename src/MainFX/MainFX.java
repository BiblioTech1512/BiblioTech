package MainFX;

import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {
    
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "Otrov";
//    private static final String CONN_STRIGN = "jdbc:mysql://127.0.0.1:3306/MainFX";    
    

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("BiblioTech");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        Connection conn;
        
//        try {
//            conn = DriverManager.getConnection(CONN_STRIGN, USERNAME, PASSWORD);
//            System.out.println("Connected!"); 
//            
//        } catch (SQLException e){
//            System.err.println(e);
//        }
        launch(args);
    }
}
