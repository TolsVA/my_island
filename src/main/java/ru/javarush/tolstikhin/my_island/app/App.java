package ru.javarush.tolstikhin.my_island.app;

import ru.javarush.tolstikhin.my_island.Model;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.Organism;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.herbivores.*;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.animals.predators.*;
import ru.javarush.tolstikhin.my_island.islands.squares.residents.plants.Plant;
import ru.javarush.tolstikhin.my_island.view.windows.InitWindow;
import ru.javarush.tolstikhin.my_island.view.windows.MainWindow;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class App {
    private static App instance;

    private App() {
        Viewable mainApplication = new MainWindow();
        whoEatsWhom();
        InitWindow.model = new Model(/*FillListOrganism(),*/ FillMapOrganismCount());
        mainApplication.run();
    }

    private void whoEatsWhom() {
        Horse.food.put(Plant.class, 100);       // Лошадь - траву
        Deer.food.put(Plant.class, 100);        // Олень - траву
        Rabbit.food.put(Plant.class, 100);      // Кролик - траву

        Mouse.food.put(Plant.class, 100);       // Мышь - траву
        Mouse.food.put(Caterpillar.class, 90);  // Мышь - гусеницу

        Goat.food.put(Plant.class, 100);        // Коза - траву
        Sheep.food.put(Plant.class, 100);       // Овца - траву

        Boar.food.put(Plant.class, 100);        // Кабан - траву
        Boar.food.put(Caterpillar.class, 90);   // Кабан - гусеницу
        Boar.food.put(Mouse.class, 50);         // Кабан - мыш

        Buffalo.food.put(Plant.class, 100);     // Буйвол - траву
        Caterpillar.food.put(Plant.class, 100); // Гусеница - траву

        Duck.food.put(Plant.class, 100);        // Утка - траву
        Duck.food.put(Caterpillar.class, 90);   // Утка - гусеницу

        Wolf.food.put(Horse.class, 10);         // Волк - лошадь
        Wolf.food.put(Deer.class, 15);          // Волк - оленя
        Wolf.food.put(Rabbit.class, 60);        // Волк - кролика
        Wolf.food.put(Mouse.class, 80);         // Волк - мыш
        Wolf.food.put(Goat.class, 60);          // Волк - козу
        Wolf.food.put(Sheep.class, 70);         // Волк - овцу
        Wolf.food.put(Boar.class, 15);          // Волк - кабана
        Wolf.food.put(Buffalo.class, 10);       // Волк - буйвола
        Wolf.food.put(Duck.class, 40);          // Волк - утку

        Boa.food.put(Fox.class, 15);            // Удав - лису
        Boa.food.put(Rabbit.class, 20);         // Удав - кролика
        Boa.food.put(Mouse.class, 40);          // Удав - мыш
        Boa.food.put(Duck.class, 10);           // Удав - утку

        Fox.food.put(Rabbit.class, 70);         // Лиса - кролика
        Fox.food.put(Mouse.class, 90);          // Лиса - мыш
        Fox.food.put(Duck.class, 60);           // Лиса - утку
        Fox.food.put(Caterpillar.class, 40);    // Лиса - гусеницу

        Boar.food.put(Boa.class, 80);           // Медведь - удава
        Boar.food.put(Horse.class, 40);         // Медведь - лошадь
        Boar.food.put(Deer.class, 80);          // Медведь - оленя
        Boar.food.put(Rabbit.class, 80);        // Медведь - кролика
        Boar.food.put(Mouse.class, 90);         // Медведь - мыш
        Boar.food.put(Goat.class, 70);          // Медведь - козу
        Boar.food.put(Sheep.class, 70);         // Медведь - овцу
        Boar.food.put(Boar.class, 50);          // Медведь - кабана
        Boar.food.put(Buffalo.class, 20);       // Медведь - буйвола
        Boar.food.put(Duck.class, 10);          // Медведь - утку

        Eagle.food.put(Fox.class, 10);          // Орел - лису
        Eagle.food.put(Rabbit.class, 90);       // Орел - кролика
        Eagle.food.put(Mouse.class, 90);        // Орел - мыш
        Eagle.food.put(Duck.class, 80);         // Орел - утку
    }

    private List<Class<? extends Organism>> FillListOrganism() {
        return new ArrayList<>(
                List.of(
                        Buffalo.class, Bear.class, Horse.class, Deer.class,
                        Boar.class, Sheep.class, Goat.class, Wolf.class,
                        Boa.class, Fox.class, Eagle.class, Rabbit.class,
                        Duck.class, Mouse.class, Caterpillar.class, Plant.class
                )
        );
    }

    private Map<Class<? extends Organism>, Integer> FillMapOrganismCount() {
        Map<Class<? extends Organism>, Integer> mapOrganismClassCount = new LinkedHashMap<>();
        mapOrganismClassCount.put(Buffalo.class, 10);
        mapOrganismClassCount.put(Bear.class, 5);
        mapOrganismClassCount.put(Horse.class, 20);
        mapOrganismClassCount.put(Deer.class, 20);
        mapOrganismClassCount.put(Boar.class, 50);
        mapOrganismClassCount.put(Sheep.class, 140);
        mapOrganismClassCount.put(Goat.class, 140);
        mapOrganismClassCount.put(Wolf.class, 30);
        mapOrganismClassCount.put(Boa.class, 30);
        mapOrganismClassCount.put(Fox.class, 30);
        mapOrganismClassCount.put(Eagle.class, 20);
        mapOrganismClassCount.put(Rabbit.class, 150);
        mapOrganismClassCount.put(Duck.class, 200);
        mapOrganismClassCount.put(Mouse.class, 500);
        mapOrganismClassCount.put(Caterpillar.class, 1000);
        mapOrganismClassCount.put(Plant.class, 200);
        return mapOrganismClassCount;
    }

    public static void run() {
        if (instance == null) {
            instance = new App();
        }
    }
}

//Buffalo  Буйвол
//Bear  Медведь
//Horse  Лошадь
//Deer  Олень

//Boar  Кабан
//Sheep  Овца
//Goat  Коза
//Wolf  Волк

//Boa  Удав
//Fox  Лиса
//Eagle  Орел
//Rabbit  Кролик

//Duck  Утка
//Mouse  Мышь
//Caterpillar  Гусеница
//Plant Растение

//entity factory   сущность фабрика
// animal factory фабрика животных

          //    Волк	Удав	Лиса	Медведь	Орел	Лошадь	Олень	Кролик	Мышь	Коза	Овца	Кабан	Буйвол	Утка	Гусеница	Растения
//        Волк	  -	     0	     0	       0	 0	      10	  15	  60	 80	     60	     70	      15	  10	 40	       0	       0
//        Удав	  0      -	    15	       0	 0	       0	   0	  20	 40	      0	0	0	0	10	0	0
//        Лиса	0	0	-	0	0	0	0	70	90	0	0	0	0	60	40	0
//        Медведь	0	80	0	-	0	40	80	80	90	70	70	50	20	10	0	0
//        Орел	0	0	10	0	-	0	0	90	90	0	0	0	0	80	0	0
//        Лошадь  0	0	0	0	0	-	0	0	0	0	0	0	0	0	0	100
//        Олень	0	0	0	0	0	0	-	0	0	0	0	0	0	0	0	100
//        Кролик	0	0	0	0	0	0	0	-	0	0	0	0	0	0	0	100
//        Мышь	0	0	0	0	0	0	0	0	-	0	0	0	0	0	90	100
//        Коза	0	0	0	0	0	0	0	0	0	-	0	0	0	0	0	100
//        Овца	0	0	0	0	0	0	0	0	0	0	-	0	0	0	0	100
//        Кабан	0	0	0	0	0	0	0	0	50	0	0	-	0	0	90	100
//        Буйвол	0	0	0	0	0	0	0	0	0	0	0	0	-	0	0	100
//        Утка	0	0	0	0	0	0	0	0	0	0	0	0	0	-	90	100
//        Гусеница	0	0	0	0	0	0	0	0	0	0	0	0	0	0	-	100