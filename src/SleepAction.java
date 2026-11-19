public class SleepAction {

    public static void sleep(Pet pet) {
        // Restore energy
        pet.changeEnergy(30);

        // Sleeping makes the pet hungrier
        pet.changeHunger(10);

        System.out.println(pet.getName() + " is sleeping!");
    }
}
