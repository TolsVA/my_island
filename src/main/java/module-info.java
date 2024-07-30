module ru.javarush.tolstikhin.my_island {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires static lombok;

    exports ru.javarush.tolstikhin.my_island;
    opens ru.javarush.tolstikhin.my_island to javafx.fxml;
    exports ru.javarush.tolstikhin.my_island.view.windows;
    opens ru.javarush.tolstikhin.my_island.view.windows to javafx.fxml;
}