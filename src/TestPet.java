public class TestPet {

    public static void main(String[] args) {

        Pet pet = new Dragon("Sparky", "Takis", "Water");

        System.out.println("Name: " + pet.getName());
        System.out.println("Type: " + pet.getType());

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