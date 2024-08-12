package ru.javarush.tolstikhin.my_island.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.models.Presentable;

import java.io.IOException;
import java.util.Map;

public class SquareShowWindow {
    public static Presentable model;

    public void start(
            Stage stage,
            String nameSquare,
            Map<Class<? extends Organism>, Integer> integerMap
    ) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(SquareShowWindow.class.getResource("square_show.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 334);
        stage.setTitle(nameSquare);

//        SquareShowController controller = fxmlLoader.getController();
//        controller.setStage(stage);

        for (var classListEntry : integerMap.entrySet()) {
            Label label = (Label) scene.lookup("#" + classListEntry.getKey().getSimpleName().toLowerCase());
            label.setText(" " + String.format(label.getText(), classListEntry.getValue()));
        }

        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
