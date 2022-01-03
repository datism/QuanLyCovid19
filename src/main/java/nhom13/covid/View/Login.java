package nhom13.covid.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import nhom13.covid.Dao.AccountDao;
import nhom13.covid.Model.Account;
import nhom13.covid.Model.UserHolder;
import org.controlsfx.control.Notifications;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    TextField userName;
    @FXML
    TextField passWord;
    @FXML
    public void loginPressed(ActionEvent actionEvent) {

        if (validate.isInvalid()) {
            Notifications.create()
                    .title("Lỗi input")
                    .text("Mời nhập lại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }

        String name = userName.getText();
        String pass = passWord.getText();

        Account account = accountDao.getByUserName(Integer.valueOf(name));

        if (account == null) {
            Notifications.create()
                    .title("Lỗi input")
                    .text("Tài khoản không tồn tại")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }

        if (!account.getPassword().equals(pass)) {
            Notifications.create()
                    .title("Lỗi input")
                    .text("Sai mật khẩu")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
            return;
        }

        //Singleton
        UserHolder holder = UserHolder.getInstance();
        holder.setUser(account);

        try {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader loader = new  FXMLLoader(getClass().getResource("MainScene.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Notifications.create()
                    .title("Lỗi!")
                    .text("Lỗi hệ thống")
                    .position(Pos.TOP_RIGHT)
                    .hideAfter(Duration.seconds(5))
                    .showError();
        }
    }

    AccountDao accountDao;
    ValidationSupport validate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountDao = new AccountDao();
        validate = new ValidationSupport();

        validate.registerValidator(userName, Validator.createRegexValidator("Tài khoản là số nguyên dương", "\\d+", Severity.ERROR));
        validate.registerValidator(passWord, Validator.createEmptyValidator("Mật khẩu không được để trống"));
    }
}