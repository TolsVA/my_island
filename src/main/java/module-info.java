module ru.javarush.tolstikhin.my_island {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.javarush.tolstikhin.my_island to javafx.fxml;
    exports ru.javarush.tolstikhin.my_island;
    exports ru.javarush.tolstikhin.my_island.controllers;
    opens ru.javarush.tolstikhin.my_island.controllers to javafx.fxml;
    exports ru.javarush.tolstikhin.my_island.view;
    opens ru.javarush.tolstikhin.my_island.view to javafx.fxml;
}