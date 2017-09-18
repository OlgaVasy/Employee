/** PayableInterfaceTest.java
 * Payable interface test program processing Invoices and Employees polymorphically */

public class PayableInterfaceTest
{
   public static void main(String[] args)
   {
      // create six-element Payable array
      Payable[] payableObjects = new Payable[6];

      // populate array with objects that implement Payable
      payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
      payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
      payableObjects[2] =
         new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
      payableObjects[3] =
         new HourlyEmployee("Lisa", "Barnes", "222-22-2222", 18.00, 168);
      payableObjects[4] =
         new CommissionEmployee("Ivan", "Green", "333-33-3333", 3400.00, 0.8);
      payableObjects[5] =
         new BasePlusCommissionEmployee("Alisa", "Grey", "4444-44-4444", 2300.00, 0.2, 1800);

      System.out.println(
         "Invoices and Employees processed polymorphically:");

      // generically process each element in array payableObjects
      for (Payable currentPayable : payableObjects) {
         // output currentPayable and its appropriate payment amount
         System.out.printf("%n%s %n%s: $%,.2f%n",
            currentPayable.toString(), // could invoke implicitly
            "payment due", currentPayable.getPaymentAmount());

         if (currentPayable instanceof BasePlusCommissionEmployee) {

            BasePlusCommissionEmployee payableObject = (BasePlusCommissionEmployee) currentPayable;
            payableObject.setBaseSalary(1.10 * payableObject.getBaseSalary());
         }
          }
      System.out.println("");
      System.out.println("The payment amounts after a 10% increase of a base-salaried commission employee's base salary:");

      for (Payable newPayable : payableObjects)
        System.out.printf("%n%s: %n payment due: $%s%n",newPayable.getClass().getName(),newPayable.getPaymentAmount());

   } // end main
} // end class PayableInterfaceTest
