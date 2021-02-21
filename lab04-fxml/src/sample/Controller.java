package sample;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import org.apache.commons.validator.routines.EmailValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField txUserName;
    @FXML
    private TextField txFullName;
    @FXML
    private TextField txEmail;
    @FXML
    private TextField txPhoneNum;
    @FXML
    private DatePicker datePicker;
    private DateTimeFormatter dateTimeFormatter;
    @FXML
    public void initialize() {
        System.out.println("App is running...");
        final String datePattern = "M/dd/yyyy";
        dateTimeFormatter = DateTimeFormatter.ofPattern(datePattern);
        datePicker.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate date) {
                String finalDate = null;
                if (date != null){ finalDate = dateTimeFormatter.format(date);}
                return finalDate;
            }
            @Override
            public LocalDate fromString(String string) {
                LocalDate date = null;
                if (string != null){ date = LocalDate.parse(string, dateTimeFormatter);}
                return date;
            }
        });
    }
    @FXML
    private Text userErr;
    @FXML
    private Text passErr;
    @FXML
    private Text nameErr;
    @FXML
    private Text phoneErr;
    @FXML
    public Text emailErr;
    @FXML
    public Text dateErr;
    @FXML
    public void handleSubmitButtonAction(ActionEvent actionEvent) throws NumberParseException {

        if (txUserName.getText().length() > 0){
            displayInfo(txUserName.getText(), "Username", userErr);
        }else{
            userErr.setFill(Color.FIREBRICK);
            userErr.setText("No username given");
        }

        if (passwordField.getText().length() >= 8) {
            displayInfo(passwordField.getText(), "Password", passErr);
        }else{
            passErr.setFill(Color.FIREBRICK);
            passErr.setText("Password must be valid. 8 characters minimum");
        }

        if (txFullName.getText().length() > 0) {
            displayInfo(txFullName.getText(), "Full name", nameErr);
        }else{
            nameErr.setFill(Color.FIREBRICK);
            nameErr.setText("No full name given");
        }

        EmailValidator validator = EmailValidator.getInstance();
        if (validator.isValid(txEmail.getText())) {
            displayInfo(txEmail.getText(), "E-mail", emailErr);
        }else{
            emailErr.setFill(Color.FIREBRICK);
            emailErr.setText("Email must be valid");
        }

        if (handlePhoneNum(txPhoneNum.getText())) {
            displayInfo(txPhoneNum.getText(), "Phone#", phoneErr);
        }else{
            phoneErr.setFill(Color.FIREBRICK);
            phoneErr.setText("Phone number must be valid");
        }

        if (datePicker.getValue() != null){
            displayInfo(datePicker.getValue().toString(), "Birth Date", dateErr);
        }else{
            dateErr.setFill(Color.FIREBRICK);
            dateErr.setText("No date given");
        }
    }
    private void displayInfo(String info, String infoType, Text error){
        error.setText("");
        System.out.println(infoType + ": " + info);
    }

    private boolean handlePhoneNum(String phoneNum) throws NumberParseException {
        PhoneNumberUtil numberUtil = PhoneNumberUtil.getInstance();
        try{
            PhoneNumber phoneNumber = numberUtil.parse(phoneNum, "CA");
            return numberUtil.isValidNumber(phoneNumber);
        }catch (NumberParseException e){
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return false;
    }
}
