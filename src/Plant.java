import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequencyOfWatering;

    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) throws PlantException {
        this.checkCondition("Počet dní na zavlažení musí být vetší jak 0", frequencyOfWatering <= 0);
        this.checkCondition("Datum zálivky nesmí být menší jak datum vysazení rostliny", planted.isAfter(watering));
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name,LocalDate planted, int frequencyOfWatering) throws PlantException {
        this(name, "", planted, LocalDate.now(), frequencyOfWatering);
    }
    private void checkCondition(String error, boolean condition) throws PlantException {
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

    public String getInfo() {
        return this.getName() + "\t" + this.getNotes() + "\t" + this.getFrequencyOfWatering()
                + "\t" + this.getPlanted() + "\t" + this.getWatering();
    }


    private String recommendedWatering() {
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
}
