import java.time.LocalDate;
import java.util.Collections;

public class Plant implements Comparable<Plant> {

    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;

    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) throws PlantException {
        this.checkCondition(frequencyOfWatering <= 0, "Počet dní na zavlažení musí být vetší jak 0");
        this.checkCondition(planted.isAfter(watering), "Datum zálivky nesmí být menší jak datum vysazení rostliny");
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name,LocalDate planted, int frequencyOfWatering) throws PlantException {
        this(name, "", planted, LocalDate.now(), frequencyOfWatering);
    }
    private void checkCondition(boolean condition, String error) throws PlantException {
        if (condition) {
            throw new PlantException(error);
        }
    }

    public Plant(String name) throws PlantException {
        this(name, LocalDate.now(), 7);
    }

    public String getWateringInfo() {
        return "Rostlina: " + getName() + ", byla naposled zavlažena: " + getWatering() +
                ", \ndalší závlaha je doporučena: " + this.recommendedWatering();
    }

    public String recommendedWatering() {
        return String.valueOf(this.watering.plusDays(this.frequencyOfWatering));
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public long getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }

    @Override
    public int compareTo(Plant plant) {
        return this.getName().compareTo(plant.getName());
    }

}
