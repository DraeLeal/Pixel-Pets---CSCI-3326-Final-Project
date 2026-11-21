public class FeedingAction {

    public static final FeedingAction TAKIS = new FeedingAction("Takis", 20);
    public static final FeedingAction PIZZA = new FeedingAction("Pizza", 30);
    public static final FeedingAction WATER = new FeedingAction("Water", 10);
    public static final FeedingAction[] ALL = {TAKIS, PIZZA, WATER};
    private String name;
    private int hungerRestored;

    public FeedingAction(String name, int hungerRestored) {
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
                pet.changeHappiness(10);
            } else if (name.equals(pet.getDislikes())) {
                amount -= 10;
                pet.changeHappiness(-10);
            }
        pet.changeHunger(amount);
        System.out.println("Fed: " + name);
    }
}