package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.commons.validator.EmailValidator;



public class Controller {
    public PasswordField passwordField;
    public TextField txUserName;
    public TextField txFullName;
    public TextField txEmail;
    public TextField txPhoneNum;
    public TextField txDOB;

    @FXML
    private Text actiontarget;
    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        EmailValidator validator = EmailValidator.getInstance();

        boolean isAddressValid = validator.isValid(String.valueOf(txEmail));
        if (!validator.isValid(String.valueOf(isAddressValid))) {
            System.out.println("Email address isn't valid");
            // etc.
        }
    }
}
