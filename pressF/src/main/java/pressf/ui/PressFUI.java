package pressf.ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pressf.domain.Finder;

public class PressFUI extends Application {

    private Finder finder;

    public PressFUI() {
        this.finder = new Finder();
    }

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane searchBp = new BorderPane();
        searchBp.setMinSize(500, 500);
        VBox buttons = new VBox();
        buttons.setSpacing(10);
        Button button = new Button("Press F!");
        Button quit = new Button("Quit");
        buttons.getChildren().addAll(button, quit);
        TextField searchWord = new TextField();
        Text result = new Text();
        TextField link = new TextField("https://");
        Text linkText = new Text("Search from URL:(\"https://\")");
        Text searchWordText = new Text("Search for a word:");
        VBox searchWordBp = new VBox();
        searchWordBp.getChildren().addAll(searchWordText, searchWord);
        VBox linkVb = new VBox();
        linkVb.getChildren().addAll(linkText, link);
        button.setOnAction(event -> {
            try {
                if (this.finder.etsi(searchWord.getText(), link.getText())) {
                    result.setText("Word \"" + searchWord.getText() + "\" was found");
                } else {
                    result.setText("Word \"" + searchWord.getText() + "\" wasn't found");
                }
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        });
        quit.setOnAction(event -> {
            stage.close();
        });
        searchBp.setCenter(result);
        searchBp.setRight(searchWordBp);
        searchBp.setBottom(linkVb);
        searchBp.setLeft(buttons);
        Scene searchScene = new Scene(searchBp);

        BorderPane loginBp = new BorderPane();
        loginBp.setMinSize(300, 300);
        TextField userName = new TextField();
        Text userNameText = new Text("UserName");
        PasswordField passWord = new PasswordField();
        Text passWordText = new Text("Password");
        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> {
            stage.setScene(searchScene);
            //DB manipulation
        });
        Button createButton = new Button("Create an account");
        createButton.setOnAction(event -> {
            stage.setScene(searchScene);
            //DB manipulation
        });
        Button loginQuitButton = new Button("Quit");
        loginQuitButton.setOnAction(blaah -> {
            stage.close();
        });
        HBox loginButtons = new HBox();
        loginButtons.getChildren().addAll(loginButton, createButton, loginQuitButton);
        VBox vbox = new VBox();
        vbox.getChildren().addAll(userNameText, userName, passWordText, passWord);
        loginBp.setCenter(vbox);
        loginBp.setBottom(loginButtons);
        Scene loginScene = new Scene(loginBp);

        stage.setScene(loginScene);
        stage.show();
    }
}
