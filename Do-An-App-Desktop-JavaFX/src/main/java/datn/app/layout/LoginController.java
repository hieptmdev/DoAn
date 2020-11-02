package datn.app.layout;

import datn.app.App;
import datn.app.constant.AppConstant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class LoginController implements Initializable {
    private Preferences preferences;

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private CheckBox cbRemember;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        preferences = Preferences.userNodeForPackage(LoginController.class);
        if (preferences != null){
            if (preferences.get(AppConstant.RB_USERNAME, null) != null){
                cbRemember.setSelected(true);
                txtUsername.setText(preferences.get(AppConstant.RB_USERNAME, null));
                txtPassword.setText(preferences.get(AppConstant.RB_PASSWORD, null));
            }
        }
    }

    @FXML
    private void login() throws IOException{
        URL url = new URL("http://localhost:8903/v1/vicinity-position-plan/search");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.ZXlKNmFYQWlPaUpFUlVZaUxDSmhiR2NpT2lKa2FYSWlMQ0psYm1NaU9pSkJNVEk0UTBKRExVaFRNalUySW4wLi5iMl9LelNfNzZhRnVrV1B6TlY4d2F3Lkc0d2JxaldCSEt5bjZqTW9RN3RpVlRUa2E5UW0zengtNzFtQlZPUjNsUG42eVJ1YmEtekR0MlhfUFEzaDRVQmhvaHVOaGh6eHNBV0h3QnVFUjRGZ2lNQUhsc2dMUjdrTGhIQ3RHRGpWQ1pOdkVoVFVsNmlZY25rWWpvc3g5emJQbW83a0dLSnJQUS0tSnVIWDhmRDhvS0ZZSVJaVklnWXJ0elpMbXVQQkozVkEtZ3R3TDMxSDlUX295d0taNkRxQVZKRG1qRDJFNWZLSHNJQVdqbU1ZNEdfVlU2WTgtWnRDY0RoSk92YXUwOFdwUDhHN3ZkNjRHRDV5b3BsZ0xMMWhIb0hxR3ZUVjZKaEFmSWtxYkNuQm9vY2ZyV3RNNU02WWdvSlp0MTJ1TDZKZERkdzBFRmJWdm5zaU93TEZiQVl5cXUzWVdLNl9LZWo3U1A3MkRvOEhsOGpKZnlibGNpNWlRQnJCcmRfYUlSTW1lQVlzLXp0WGNKRkgzcmVBbmI4Rld0UkdWRl92akZISjR6UU84b3I3Zml5b2xldlViQ240OTVyYmxYUnNqa2ZGN0Jqa2t6czN6cUJBN1FEdGZacGV2Y0VCRzc0VTJwNENxNm5aRWpBWXR4NjdJOWFrQnJEVXRoOTZjTC03U0sxUXBzcklBX0tvaXF3Yk9rMTRGMW1XOXFQbnZpMU9fVFZNRm9reXhLZnBoN2Qzd2stdmQyMVNsY0VHTDIyZWtBN3BwYkJ5VFB2NXhsUlF2NU1US3ZnOS5fY0g3VFhETkswR2ktckdqSTQ4YjdR.ZK82gJk9D0WZCWX3H-s2W_gPeeBDeVoeCi7el6v1MjnM2jDTYktIIeaXEuez23A2epk_HuwGEKqDtP2w_D9xLg");
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Content-Type", "application/json; utf-8");
        http.connect();
        /*try(BufferedReader br = new BufferedReader(
                new InputStreamReader(http.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }*/
        http.disconnect();
        if (cbRemember.isSelected()){
            preferences.put(AppConstant.RB_USERNAME, txtUsername.getText());
            preferences.put(AppConstant.RB_PASSWORD, txtPassword.getText());
        }
        App.loadStage("layout/main");
    }

    @FXML
    private void reset(){
        txtUsername.setText(null);
        txtPassword.setText(null);
    }
}
