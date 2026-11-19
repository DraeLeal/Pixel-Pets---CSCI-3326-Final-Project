public abstract class Pet {

    // Pet attributes
    private String name;
    private String likes;
    private String dislikes;
    private int hunger;
    private int happiness;
    private int energy;

    private static final int MAX_STATS = 100;

    // Abstraction
    public abstract String getType();

    // Constructor
    public Pet(String name, String likes, String dislikes) {
        this.name = name;
        this.likes = likes;
        this.dislikes = dislikes;

        this.hunger = 80;
        this.happiness = 50;
        this.energy = MAX_STATS;
    }

    // Getters
    public String getName() {
        return name;
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
        this.hunger = Math.max(0, Math.min(MAX_STATS, hunger));
    }

    public void setHappiness(int happiness) {
        this.happiness = Math.max(0, Math.min(MAX_STATS, happiness));
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(0, Math.min(MAX_STATS, energy));
    }

    // Modify pet statistics
    public void changeHunger(int amount) {
        setHunger(hunger + amount);
    }

    public void changeHappiness(int amount) {
        setHappiness(happiness + amount);
    }

    public void changeEnergy(int amount) {
        setEnergy(energy + amount);
    }
}
