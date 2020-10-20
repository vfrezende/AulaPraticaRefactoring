import java.util.Enumeration;

public class HtmlStatement extends Statement {
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
      return "<H1>Rentals for <EM>" + aCustomer.getName() +
      "</EM></H1><P>\n";
   }

   public String makeRentalMessage(Rental rental) {
      return rental.getMovie().getTitle()+ ": " +
             String.valueOf(rental.getCharge()) + "<BR>\n";
   }

   public String makeOweMessage(Customer aCustomer) {
      return "<P>You owe <EM>" +
             String.valueOf(aCustomer.getTotalCharge()) + 
             "</EM><P>\n";
   }

   public String makePointsMessage(Customer aCustomer) {
      return "On this rental you earned <EM>" + 
             String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
             "</EM> frequent renter points<P>";
   }
}