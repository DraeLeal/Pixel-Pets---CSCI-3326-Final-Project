public class Dragon extends Pet {

    public Dragon(String name, String likes, String dislikes) {
        super(name, likes, dislikes);

    }

    @Override
    public String getType() {
        return "Dragon";
    }

}
