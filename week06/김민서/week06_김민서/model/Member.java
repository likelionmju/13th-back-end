package hello.week06.model;

public class Member {
    private String name;
    private int age;

    public Member() {}

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // --- Getter ---
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // --- Setter ---
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // --- Logic ---
    public boolean isAdult() {
        return age >= 20;
    }
}
