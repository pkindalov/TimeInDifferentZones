package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    public ComboBox choiceTimeZone;
    public TextArea result;
    public TextArea userTime;
    public Button btnCheck;


    public void choiceTimeZone(ActionEvent actionEvent) {

        String selValue = (String) choiceTimeZone.getValue();
        selValue = processValue(selValue);

        showTime(selValue);

    }

    private void showTime(String selValue) {
        java.util.TimeZone timeZone = java.util.TimeZone.getTimeZone(selValue);
        java.util.Calendar calendar = java.util.Calendar.getInstance(timeZone);

        result.setText(calendar.get(java.util.Calendar.HOUR_OF_DAY)+":"+calendar.get(java.util.Calendar.MINUTE)+":"+calendar.get(java.util.Calendar.SECOND));
    }

    private String processValue(String selValue) {
        Pattern pattern = Pattern.compile("([A-Z]+[\\-?+]?\\d+:\\d+)");
        Matcher matcher = pattern.matcher(selValue);

        while (matcher.find()){
            selValue = matcher.group(0);
        }

        return  selValue;

    }

    public void userTimeZone(ActionEvent actionEvent) {
        String userZone = userTime.getText();
        userZone = processValue(userZone);
        showTime(userZone);
    }


    
}


