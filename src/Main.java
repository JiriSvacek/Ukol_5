import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Plant bla = new Plant("Zhoj", LocalDate.of(2022, 8, 10), 8);
            System.out.println(bla.getWateringInfo());
            ListOfPlants seznam = new ListOfPlants();
            seznam.addPlant(bla);
            seznam.seeList();
            seznam.addFromFile("src/kvetiny.txt");
            seznam.seeList();
            Collections.sort(seznam.getListOfPlants());
            seznam.seeList();
            Collections.sort(seznam.getListOfPlants(), new PlantWateringCompare());
            seznam.seeList();
            //seznam.getWatering();
            //seznam.toFile("src/doslozky.txt");
        } catch (PlantException e) {
            System.out.println(e.getLocalizedMessage());
        }

        //ListOfPlants seznamBad = new ListOfPlants();
        //seznamBad.addFromFile("src/kvetiny-spatne-datum.txt");
        //seznamBad.seeList();
        //ListOfPlants seznamBad2 = new ListOfPlants();
        //seznamBad2.addFromFile("src/kvetiny-spatne-frekvence.txt");
        //seznamBad2.seeList();
    }
}