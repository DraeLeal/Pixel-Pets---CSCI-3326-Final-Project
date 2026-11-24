import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(
            null,
            "What would you like to name your pet?",
            "Name Your Pet",
            JOptionPane.QUESTION_MESSAGE);

        // Default name
        if (name == null || name.trim().isEmpty()) {
            name = "Sparky";
        }
        name = name.trim();

        // Character Limit
        if (name.length() > 12) {
            name = name.substring(0, 12);
        }

        String[] types = {"Dragon", "Yeti", "Slime"};
        String type = (String) JOptionPane.showInputDialog(
            null,
            "Choose your pet:",
            "Pet Type",
            JOptionPane.QUESTION_MESSAGE,
            null,
            types,
            types[0]);

        Pet pet;
        if ("Yeti".equals(type)) {
            pet = new Yeti(name, "Pizza", "Takis");
        } else if ("Slime".equals(type)) {
            pet = new Slime(name, "Water", "Pizza");
        } else {
            pet = new Dragon(name, "Takis", "Water");
        }

        PetUI.show(pet);
    }
}