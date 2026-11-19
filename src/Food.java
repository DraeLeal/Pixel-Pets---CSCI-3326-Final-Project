public class Food {

    public static final Food TAKIS = new Food("Takis", 20);
    public static final Food PIZZA = new Food("Pizza", 30);
    public static final Food WATER = new Food("Water", 10);
    public static final Food[] ALL = {TAKIS, PIZZA, WATER};
    private String name;
    private int hungerRestored;

    public Food(String name, int hungerRestored) {
        this.name = name;
        this.hungerRestored = hungerRestored;
    }

    public String getName() {
        return name;
    }

    public int getHungerRestored() {
        return hungerRestored;
    }

    // runs when feed buttin is pressed: now changes hunger based on likes and dislikes
    public void onFed(Pet pet) {
        int amount = hungerRestored;
            if (name.equals(pet.getLikes())) {
                amount += 10;
            } else if (name.equals(pet.getDislikes())) {
                amount -= 10;
            }
        pet.changeHunger(amount);
        System.out.println("Fed: " + name);
    }
}