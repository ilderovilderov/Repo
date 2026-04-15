public class Person {

    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    void introduce() {
        System.out.println("Привет, меня зовут " + firstName + " " + lastName + "." + " Мне " + age + " лет.");
    }

//    void introduce() {
//        System.out.println("Привет, меня зовут " + firstName + " " + lastName + "." + " Мне " + age + " лет.");
//    }
//
//    public static void main(String[] args) {
//        Person person = new Person();
//        person.firstName = "Николай";
//        person.lastName = "Басков";
//        person.age = 25;
//        person.introduce();
//    }
}
