package pressf.ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pressf.domain.Finder;

public class PressFUI extends Application {

    private Finder finder;

    public PressFUI() {
        this.finder = new Finder();
    }

    @Override
    public void start(Stage ikkuna) throws IOException {
        TextField link = new TextField();
        Button button = new Button("Press F!");
        TextField searchWord = new TextField();
        Text result = new Text();
        Button quit = new Button("Close");

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
            ikkuna.close();
        });
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().addAll(link, searchWord, button,
                quit, result);

        Scene nakyma = new Scene(componentGroup);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
}
