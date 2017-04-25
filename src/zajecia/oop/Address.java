package zajecia.oop;

/**
 * Created by RENT on 2017-04-24.
 */
public class Address {

    public String city;
    public String street;
    public int homeNumber;
    public String flatNumber;
    public String postalCode;
    public String land;

    public void display() {
        System.out.println("City: " + city + ", street: " + street + ", home number: " + homeNumber + " flat number: " + flatNumber);
        System.out.println("Postal code: " + postalCode + ", land: " + land);
    }

}
