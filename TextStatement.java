import java.util.Enumeration;

public class TextStatement extends Statement {
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

   public String makeHeaderMessage(Customer aCustomer) {
      return "Rental Record for " + aCustomer.getName() +
      "\n";
   }

   public String makeRentalMessage(Rental rental) {
      return "\t" + rental.getMovie().getTitle()+ "\t" +
                String.valueOf(rental.getCharge()) + "\n";
   }

   public String makeOweMessage(Customer aCustomer) {
      return "Amount owed is " +
             String.valueOf(aCustomer.getTotalCharge()) + "\n";
   }

   public String makePointsMessage(Customer aCustomer) {
      return "You earned " +
             String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
             " frequent renter points";
   }
}