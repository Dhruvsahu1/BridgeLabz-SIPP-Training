
public class pet {
    private String type;
    private int age;
    private boolean isAdopted;

    public pet(String type, int age, boolean isAdopted) {
        this.type = type;
        this.age = age;
        this.isAdopted = isAdopted;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                ", age=" + age +
                ", isAdopted=" + isAdopted +
                '}';
    }
}
