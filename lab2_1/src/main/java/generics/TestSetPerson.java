package generics;

public class TestSetPerson {
    public static void main(String[] args) {
        Set503GenImpl<Person> set = new Set503GenImpl<Person>();

        set.add(new Person("I", Gender.MALE));
        set.add(new Person("II", Gender.FEMALE));
        set.add(new Person("III", Gender.MALE));
        //set.add("VI");
        set.add(new Person("IV", Gender.FEMALE));
        set.add(new Person("V", Gender.MALE));

        System.out.println(set);

        System.out.println(set.contains(new Person("III", Gender.MALE)));

        Object[] persons = set.toArray();
        for (Object p : persons) {
            System.out.println(((Person) p).getGender());
        }

        Person[] persons2 = set.toArray(new Person());
        for (Person p : persons2) {
            System.out.println(p.getGender());
        }

    }
}