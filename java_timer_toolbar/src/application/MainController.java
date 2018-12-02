package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
//import tw.fatminmin.javafx.timer.CountDownTimer;
import javafx.stage.WindowEvent;

public class MainController implements Initializable{
	
	@FXML
    private Label text;

    @FXML
    protected void btnResetClick(ActionEvent event) {
        CountDownTimer.getTimer().reset();
    }

    public void btnStartClick(ActionEvent event) {
        CountDownTimer.getTimer().start();
    }

    public void btnPauseClick(ActionEvent event) {
        CountDownTimer.getTimer().pause();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void CloseApp(ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}
	
	public void Login(ActionEvent event) throws Exception{
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/application/sample.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
             public void handle(WindowEvent event) {
                 CountDownTimer.getTimer().stop();
             }
          });
  	
  		text = (Label) root.lookup("#text");
  	       text.setText("30:00");
  	      CountDownTimer.getTimer().setLabel(text);
}
	
	
}
