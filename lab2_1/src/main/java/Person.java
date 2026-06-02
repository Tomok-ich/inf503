import java.util.Objects;

public class Person {
    private String name;
    private Gender gender;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "P[" + name + ", " + gender + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !o.getClass().equals(Person.class)) {
            return false;
        }
        Person p = (Person)o;

        return this.name.equals(p.name) && this.gender == p.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }
}