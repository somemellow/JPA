package hellojpa;

public class ValueMain {

    public static void main(String[] args) {
        Address address1 = new Address("city", "street", "zipcode");
        Address address2 = new Address("city", "street", "zipcode");

        System.out.println("address1.equals(address2) = " + address1.equals(address2));

    }
}
