public class Pet {

    // Pet attributes
    private String name;
    private String species;
    private String likes;
    private String dislikes;

    private int hunger;
    private int happiness;
    private int energy;

    // Constructor
    public Pet(String name, String species, String likes, String dislikes) {
        this.name = name;
        this.species = species;
        this.likes = likes;
        this.dislikes = dislikes;

        this.hunger = 80;
        this.happiness = 50;
        this.energy = 100;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getLikes() {
        return likes;
    }

    public String getDislikes() {
        return dislikes;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getEnergy() {
        return energy;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHunger(int hunger) {
        this.hunger = Math.max(0, Math.min(100, hunger));
    }

    public void setHappiness(int happiness) {
        this.happiness = Math.max(0, Math.min(100, happiness));
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(0, Math.min(100, energy));
    }

    // Feed the pet
    public void feed() {
        setHunger(hunger - 20);
        setHappiness(happiness + 5);

        System.out.println(name + " has been fed!");
    }

    // Play with the pet
    public void play() {
        setHappiness(happiness + 20);
        setEnergy(energy - 15);
        setHunger(hunger + 10);

        System.out.println(name + " is playing!");
    }

    // Let the pet sleep
    public void sleep() {
        setEnergy(energy + 30);
        setHunger(hunger + 10);

        System.out.println(name + " is sleeping!");
    }
}