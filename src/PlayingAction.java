public class PlayingAction {

    public static final PlayingAction FETCH = new PlayingAction("Fetch", 10, 5, 10);
    public static final PlayingAction HIDE_AND_SEEK = new PlayingAction("Hide and Seek", 15, 10, 15);
    public static final PlayingAction TUG_OF_WAR = new PlayingAction("Tug of War", 20, 15, 20);
    public static final PlayingAction[] ALL = {FETCH, HIDE_AND_SEEK, TUG_OF_WAR};

    private final String name;
    private final int energyCost;
    private final int hungerCost;
    private final int happinessGain;

    public PlayingAction(String name, int energyCost, int hungerCost, int happinessGain) {
        this.name = name;
        this.energyCost = energyCost;
        this.hungerCost = hungerCost;
        this.happinessGain = happinessGain;
    }

    public String getName() {
        return name;
    }

    public void play(Pet pet) {
        pet.changeEnergy(-energyCost);
        pet.changeHunger(-hungerCost);
        pet.changeHappiness(happinessGain);

        System.out.println(pet.getName() + " played " + name + "!");
    }
}
