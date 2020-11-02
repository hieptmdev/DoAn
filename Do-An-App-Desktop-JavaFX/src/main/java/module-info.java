module datn.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;

    opens datn.app to javafx.fxml;
    exports datn.app;
    opens datn.app.layout to javafx.fxml;
    exports datn.app.layout;
    opens datn.app.layout.share to javafx.fxml;
    exports datn.app.layout.share;
}