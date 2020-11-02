package datn.app.layout.share;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseButton;

public class MenuController {
    @FXML
    private TreeView tvCategory;
    @FXML
    private TreeItem test;

    public void func(){
        test.addEventHandler(TreeItem.childrenModificationEvent(), event -> {

        });
    }
}
