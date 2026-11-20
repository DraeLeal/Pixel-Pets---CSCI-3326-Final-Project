public class TestPet {

    public static void main(String[] args) {

        Pet pet = new Dragon("Sparky", "Takis", "Water");

        System.out.println("Name: " + pet.getName());
        System.out.println("Type: " + pet.getType());

        // Test disliked food
        System.out.println("\nBefore feeding disliked food (Water):");
        displayStats(pet);

        FeedingAction.WATER.onFed(pet);

        System.out.println("\nAfter feeding disliked food (Water):");
        displayStats(pet);

        // Test liked food
        System.out.println("\nBefore feeding liked food (Takis):");
        displayStats(pet);

        FeedingAction.TAKIS.onFed(pet);

        System.out.println("\nAfter feeding liked food (Takis):");
        displayStats(pet);

        // Test neutral food
        System.out.println("\nBefore feeding neutral food (Pizza):");
        displayStats(pet);

        FeedingAction.PIZZA.onFed(pet);

        System.out.println("\nAfter feeding neutral food (Pizza):");
        displayStats(pet);


        // Set energy below 100 to test recovery
        pet.setEnergy(50);

        System.out.println("\nBefore Sleeping:");
        displayStats(pet);

        SleepAction.sleep(pet);

        System.out.println("\nAfter Sleeping:");
        displayStats(pet);
    }

    public static void displayStats(Pet pet) {
        System.out.println("Hunger: " + pet.getHunger() + "%");
        System.out.println("Happiness: " + pet.getHappiness() + "%");
        System.out.println("Energy: " + pet.getEnergy() + "%");
        System.out.println("--------------------");
    }
}