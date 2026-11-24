public class Slime extends Pet {

    public Slime(String name, String likes, String dislikes) {
        super(name, likes, dislikes);
    }

    @Override
    public String getType() {
        return "Slime";
    }
    
}
