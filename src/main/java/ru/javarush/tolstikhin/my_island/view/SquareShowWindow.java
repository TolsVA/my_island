package ru.javarush.tolstikhin.my_island.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.javarush.tolstikhin.my_island.controllers.SquareShowController;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SquareShowWindow {

    public void start(String nameSquare, Map<Class<? extends Organism>, List<Organism>> listMap){
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(SquareShowWindow.class.getResource("square_show.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 500, 334);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.setTitle(nameSquare);

        SquareShowController controller = fxmlLoader.getController();
        controller.setStage(stage);

        for (var classListEntry : listMap.entrySet()) {
            Label label = (Label) scene.lookup("#" + classListEntry.getKey().getSimpleName().toLowerCase());
            String[] split = label.getText().split(" {2}");
            label.setText(split[0] + "  " + classListEntry.getValue().size());
        }

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
