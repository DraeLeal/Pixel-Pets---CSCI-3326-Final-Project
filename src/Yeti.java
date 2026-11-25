public class Yeti extends Pet {
    public Yeti(String name, String likes, String dislikes) {
        super(name, likes, dislikes);
    }

    @Override
    public String getType() {
        return "Yeti";
    }
}
