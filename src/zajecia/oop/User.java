package zajecia.oop;

/**
 * Created by RENT on 2017-04-24.
 */
public class User {

    public String firstName;
    public String lastName;
    public String phoneNumber;
    public Address address; //adres bedzie obiektem osobnej klasy
    public int age;

    public void display() {
        System.out.println("first name: " + firstName + "; last name: " + lastName + "; age: " + age);
        System.out.println("phone number: " + phoneNumber);
        if (address != null){
            address.display();
        } else {
            System.out.println("Address not specified.");
        }
    }

}
