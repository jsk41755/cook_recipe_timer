package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by fatminmin on 2015/12/7.
 */
public class CountDownTimer {

    static private CountDownTimer mCountDownTimer;

    private Timer mTimer;
    private Label mLabel;
    private int timeLeft;
  
    public void start() {
        if (mTimer == null) {
            mTimer = new Timer();
            mTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    timeLeft--;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            mLabel.setText(formatTime());
                        }
                    });
                }
            }, 1000, 1000);
        }
    }
    
    public void pause() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    public void reset() {
    	timeLeft = MainController.a;
    	 mLabel.setText(settime());
    }
    public void stop() {
        pause();
    }
    public void setLabel(Label label) {
        mLabel = label;
    }
    public CountDownTimer() {
        timeLeft = MainController.a;
    }
    
    public String settime() {
    	int minutes = timeLeft / 60;
        int seconds = timeLeft % 60;
    	return String.format("%02d:%02d", minutes, seconds);
    }
    private String formatTime() {
        int minutes = timeLeft / 60;
        int seconds = timeLeft % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
    static public CountDownTimer getTimer() {
        if(mCountDownTimer == null) {
            mCountDownTimer = new CountDownTimer();
        }
        return mCountDownTimer;
    }
}
