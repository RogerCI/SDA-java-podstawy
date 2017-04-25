package zajecia.oop;

/**
 * Created by RENT on 2017-04-24.
 */
public class Zajecia12 {
    public static void main(String[] args) {

        Address adres = new Address();
        adres.city = "Poznań";
        adres.street = "Myśliborska";
        adres.homeNumber = 31;
        adres.postalCode = "60-432";
        adres.land = "wielkopolskie";

        User user = new User();
        user.firstName = "Bartek";
        user.lastName = "Mytko";
        user.phoneNumber = "12345678";
        user.address = adres; //korzystamz obiektu utworzonego wyzej
        user.age = 31;



        user.display();
        System.out.println();
        adres.display();

    }


}
