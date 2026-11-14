
public abstract class Pet {

    private String name;
    private String likes;
    private String dislikes;
    private int hunger;
    private int happiness;
    private int energy;
    private static final int MAX_STATS = 100;
    public abstract String getType();

    public Pet(String name, String likes, String dislikes) {
        this.name = name;
        this.likes = likes;
        this.dislikes = dislikes;
        this.hunger = 80;
        this.happiness = 50;
        this.energy = MAX_STATS;
    }

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

}

