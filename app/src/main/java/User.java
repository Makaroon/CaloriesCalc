public class User {
    private String name;
    private String surname;
    private String username;
    String password;
    private String gender;
    private double weight;
    private double height;
    int age;

    public User(String name, String surname, String username, String gender, double weight, double height) {
        this.name=name;
        this.surname=surname;
        this.username=username;
        this.gender=gender;
        this.weight=weight;
        this.height=height;
    }

    double countProperWeight(double weight, double height, String gender) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
