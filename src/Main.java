import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws PlantException, IOException {
        Plant bla = new Plant("Ahoj", LocalDate.of(2022,8, 10), 8);
        System.out.println(bla.getWateringInfo());
        ListOfPlants seznam = new ListOfPlants();
        seznam.addPlant(bla);
        seznam.seeList();
        seznam.addFromList("src/kvetiny.txt");
        seznam.seeList();
        seznam.getWatering();
        seznam.toFile("src/doslozky.txt");

        //ListOfPlants seznamBad = new ListOfPlants();
        //seznamBad.addFromList("src/kvetiny-spatne-datum.txt");
        //seznamBad.seeList();
        //ListOfPlants seznamBad2 = new ListOfPlants();
        //seznamBad2.addFromList("src/kvetiny-spatne-frekvence.txt");
        //seznamBad2.seeList();
    }
}