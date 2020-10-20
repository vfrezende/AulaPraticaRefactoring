import java.util.Enumeration;

abstract public class Statement {
    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = makeHeaderMessage(aCustomer);

        while (rentals.hasMoreElements()) {
           Rental each = (Rental) rentals.nextElement();
           //show figures for each rental
           result += makeRentalMessage(each);
        }

        //add footer lines
        result += makeOweMessage(aCustomer);
        result += makePointsMessage(aCustomer);
        return result;
     }

    abstract public String makeHeaderMessage(Customer aCustomer);
    abstract public String makeRentalMessage(Rental rental);
    abstract public String makeOweMessage(Customer aCustomer);
    abstract public String makePointsMessage(Customer aCustomer);
}