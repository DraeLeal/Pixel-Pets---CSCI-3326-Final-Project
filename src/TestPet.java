public class TestPet {

    public static void main(String[] args) {

        // Create a pet object
        Pet pet = new Pet("Sparky", "Dragon", "Takis", "Water");

        // Display initial information
        System.out.println("Pet Name: " + pet.getName());
        System.out.println("Species: " + pet.getSpecies());
        System.out.println("Likes: " + pet.getLikes());
        System.out.println("Dislikes: " + pet.getDislikes());

        System.out.println("\nInitial Stats:");
        displayStats(pet);

        // Test feeding
        pet.feed();
        displayStats(pet);

        // Test playing
        pet.play();
        displayStats(pet);

        // Test sleeping
        pet.sleep();
        displayStats(pet);
    }

    // Display current pet statistics
    public static void displayStats(Pet pet) {
        System.out.println("Hunger: " + pet.getHunger() + "%");
        System.out.println("Happiness: " + pet.getHappiness() + "%");
        System.out.println("Energy: " + pet.getEnergy() + "%");
        System.out.println("--------------------");
    }
}