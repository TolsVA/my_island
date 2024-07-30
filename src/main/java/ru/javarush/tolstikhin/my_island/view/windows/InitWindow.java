package ru.javarush.tolstikhin.my_island.view.windows;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.javarush.tolstikhin.my_island.InitController;
import ru.javarush.tolstikhin.my_island.Model;
import ru.javarush.tolstikhin.my_island.Presentable;
import ru.javarush.tolstikhin.my_island.app.Viewable;
import ru.javarush.tolstikhin.my_island.islands.Island;
import ru.javarush.tolstikhin.my_island.islands.squares.Square;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.Horse;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.Buffalo;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators.Bear;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators.Wolf;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators.Boa;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators.Fox;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators.Eagle;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.Deer;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.Boar;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.Sheep;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.Goat;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.Rabbit;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.Duck;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.Mouse;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.Caterpillar;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.plants.Plant;

import java.lang.reflect.Field;
import java.util.*;

public class InitWindow implements Viewable {
    public static Presentable model;
    private final List<String> listAnimals = new ArrayList<>(List.of("\uD83D\uDC03", "\uD83D\uDC3B",
            "\uD83D\uDC0E", "\uD83E\uDD8C", "\uD83D\uDC17", "\uD83D\uDC11", "\uD83D\uDC10", "\uD83D\uDC3A",
            "\uD83D\uDC0D", "\uD83E\uDD8A", "\uD83E\uDD85", "\uD83D\uDC07", "\uD83E\uDD86", "\uD83D\uDC01",
            "\uD83D\uDC1B", "\uD83C\uDF3F"));

    private static Map<Class<? extends Organism>, Integer> mapOrganismCount = new HashMap<>();

    static {
        mapOrganismCount.put(Buffalo.class, 10);
        mapOrganismCount.put(Bear.class, 5);
        mapOrganismCount.put(Horse.class, 20);
        mapOrganismCount.put(Deer.class, 20);
        mapOrganismCount.put(Boar.class, 50);
        mapOrganismCount.put(Sheep.class, 140);
        mapOrganismCount.put(Goat.class, 140);
        mapOrganismCount.put(Wolf.class, 30);
        mapOrganismCount.put(Boa.class, 30);
        mapOrganismCount.put(Fox.class, 30);
        mapOrganismCount.put(Eagle.class, 20);
        mapOrganismCount.put(Rabbit.class, 150);
        mapOrganismCount.put(Duck.class, 200);
        mapOrganismCount.put(Mouse.class, 500);
        mapOrganismCount.put(Caterpillar.class, 1000);
        mapOrganismCount.put(Plant.class, 200);
    }


    public void start(Stage stage, String name, double x, double y) throws Exception {
//        stage.initStyle(StageStyle.TRANSPARENT);
//        scrollPane.setStyle(String.format("-fx-font-size: %dpx;", (int) (0.4 * 80)));
//        label.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
//        Stage stage = new Stage();

        double width = 1200;
        double height = 600;

        InitController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(InitController.class.getResource("init-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), width, height);
        ScrollPane scrollPane = (ScrollPane) scene.lookup("#scrPane");
        stage.setOnShown(e -> scrollPane.lookup(".viewport").setStyle("-fx-background-color: #bdd0bf;"));

        Label nameIsland = (Label) scene.lookup("#nameIsland");
        nameIsland.setText(name);

//        Island island = new Island(x, y, naveIsland);
//
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < y; j++) {
//                island.add(gridPaneFill(i, j, scene, island.getSquares()), i, j);
//            }
//        }

        Island island = model.createIsland((int)x, (int)y, name, scene);

//        System.out.println("rrrrrrr");
//        Horse horse = new Horse();
//
//        Horse clone = (Horse) horse.clone();
//
//        clone.setName("Конь ретивый");
//        System.out.println(horse);
//        System.out.println(clone);
////        Class<?> clazz = Class.forName("com.company."+"Horse");
////        Constructor<?> constructor = clazz.getConstructor();
////        Object object = constructor.newInstance();
//
//        Class<?> myClassClass = Horse.class;
//        Organism instance = (Horse) myClassClass.getDeclaredConstructor().newInstance();
//        instance.setName("Пегас");
//        System.out.println(instance);
//        Organism clone1 = instance.clone();
//        clone1.setName("Педорас");
//        System.out.println(clone1);
//        System.out.println(instance);
        List<Organism> organismList = new ArrayList<>();

        for (Class<? extends Organism> aClass : mapOrganismCount.keySet()) {

            organismList.add(aClass.getDeclaredConstructor().newInstance());
        }
        for (Organism organism : organismList) {
            System.out.println(organism);
        }

        for (Map.Entry<Class<? extends Organism>, Integer> entry : mapOrganismCount.entrySet()) {
            Organism organism = entry.getKey().getDeclaredConstructor().newInstance();
            System.out.println("name = " + organism.getName() + " icon = " + organism.getIcon()
                    + " count = " + entry.getValue());
        }

//
//        Config annotation = myClassClass.getClass().getAnnotation(Config.class);
//        Horse resident = (Horse) annotation.newInstance();
//
//
//        List<Horse> horseList = new ArrayList<>();
//        horseList.add(annotation);


//        Class aClass = horse.getClass();
//        for (Field declaredField : aClass.getDeclaredFields()) {
//            System.out.println(declaredField);
//        }

        scrollPane.setContent(island);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);

        island.setGridLinesVisible(true);
        stage.setScene(scene);
        stage.showAndWait();
    }

    private VBox gridPaneFill(int ii, int jj, Scene scene, Square[][] squares) {
        GridPane pane = new GridPane(4, 4);
        VBox vBox = new VBox(pane);
//        VBox vBox = new VBox();
//        vBox.getChildren().add(pane);
        vBox.setStyle("-fx-background-color: #14b233;");


        ScrollBar scrollBar = (ScrollBar) scene.lookup("#scrColor");
        scrollBar.setMin(0);
        scrollBar.setMax(10);
        scrollBar.setValue(10);
//        scrollBar.setTranslateX(10);

        scrollBar.valueProperty().addListener(e -> vBox.setOpacity(scrollBar.getValue() / 10));

        pane.setOnMouseClicked(e -> System.out.println("Я ячейка i = " + ii + ", j = " + jj));

        pane.setPadding(new Insets(5));

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Text text = new Text(listAnimals.get(index));
                text.setStyle("-fx-font: 18 arial;");
                int finalIndex = index;
                text.setOnMouseClicked(e ->
                        System.out.println("Я " + listAnimals.get(finalIndex) + " ячейки i = " + ii + ", j = " + jj)
                );
                text.setFill(Color.WHITE);
                pane.add(text, i, j);
                index++;
            }
        }
        return vBox;
    }

    @Override
    public void run() {

    }
}
