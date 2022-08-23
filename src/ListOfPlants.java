import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListOfPlants {
    private ArrayList<Plant> listOfPlants = new ArrayList<>();

    public void addPlant(Plant plant) {
        listOfPlants.add(plant);
    }

    public Plant getPlant(int id) {
        return listOfPlants.get(id);
    }

    public void removePlant(Plant plant) {
        listOfPlants.remove(plant);
    }

    public void addFromFile(String filename) throws PlantException {
        String line;
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] items = line.split("\\t");
                String name = items[0];
                String description = items[1];
                String frequencyAsText = items[2];
                String lastWateringAsText = items[3];
                String dateOfPlantingAsText = items[4];

                LocalDate lastWatering = LocalDate.parse(lastWateringAsText);
                LocalDate dateOfPlanting = LocalDate.parse(dateOfPlantingAsText);
                int frequency = Integer.parseInt(frequencyAsText);

                Plant plant = new Plant(name, description, dateOfPlanting, lastWatering,frequency);

                listOfPlants.add(plant);

            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Soubor " + filename + " nebyl nalezen:" + e.getLocalizedMessage());
        } catch (DateTimeParseException e) {
            throw new PlantException("Špatný formát data " + e.getLocalizedMessage());
        } catch (NumberFormatException e) {
            throw new PlantException("Špatný formát dnů " + e.getLocalizedMessage());
        }
    }

    public void seeList() {
        System.out.println("Seznam rostlin: ");
        for (Plant plant : listOfPlants) {
            System.out.println("Jmeno: " + plant.getName() + ", poznamka: " + plant.getNotes());
        }
        System.out.println("---------------");
    }

    public void getWatering() {
        System.out.println("Info o zálivce: ");
        for (Plant plant : listOfPlants) {
            System.out.println(plant.getWateringInfo());
        }
        System.out.println("---------------");
    }

    public void toFile(String filename) throws PlantException {
        try(FileWriter writer = new FileWriter(filename)) {
            for (Plant plant : listOfPlants) {
                writer.write(getInfo(plant) + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new PlantException("Soubor nemohl být vytvořen" + e.getLocalizedMessage());
        }
    }

    private String getInfo(Plant plant) {
        return plant.getName() + "\t" + plant.getNotes() + "\t" + plant.getFrequencyOfWatering()
                + "\t" + plant.getPlanted() + "\t" + plant.getWatering();
    }

    public ArrayList<Plant> getListOfPlants() {
        return listOfPlants;
    }
}

