//NORHANAH M. UMPAR BSCS 2
//Assignment in canvas
import java.util.Scanner;

public class Restaurant{
   Scanner scan = new Scanner(System.in);
   double totalprice = 0;
   int quanti = 0; 
   //Stringbuilder is used in order for the item to also add on the current order
   //Stringbuilder acts as a reciept
   StringBuilder orderedItems = new StringBuilder();
   
   public void totalPrice(){      
      System.out.format("Total Price: Php %.2f ",totalprice);
      //1 peso = 0.017592 dollar - latest value of peso
      double dollar = 0.017592*totalprice;
      System.out.format("\nTotal Price(Dollar): $%.2f ",dollar);
   }
   
   public void item(){
   //prints the contents of the StringBuilder ordered items which is added in the quantity() method
      System.out.println("\nOrdered Items: ");
      System.out.println(orderedItems.toString());  
   }
   
   public void quantity(double itemPrice, String item){
      System.out.println("Enter Quantity: ");
      quanti = scan.nextInt();
      
      double subtotal = quanti*itemPrice;
      totalprice+=subtotal;
      //appending the items and its quantity in the contents on stringbuilder orderitems
      orderedItems.append("Item ").append(item).append("\nQuantity: ").append(quanti).append("\n").append("Total amount on selected item: ").append(subtotal).append("\n");
      //total amount is the running total of the user while ordering
      System.out.format("\nTotal Amount (running total): Php%.2f",totalprice);
   }
   
   public static void main(String[]args){
      boolean exitMenu = false;
      Restaurant obj = new Restaurant();
   
      while(!exitMenu){
         System.out.println("------[MENU]------");
         System.out.println("[1]C1 = Php 100.00 \n[2]C2 = Php 150.00 \n[3]C3 = Php 200");
         System.out.println("\n(Add - ons) \n[4]R1 = Php 35.00 \n[5]R2 = Php 50.00 \n[6]Finish Order");
         
         System.out.println("Order: ");
         int order = obj.scan.nextInt();
      
         switch(order){
            case 1:
               obj.quantity(100, "C1");
               obj.item();
               break;
            case 2:
               obj.quantity(150, "C2");  
               obj.item();            
               break;
            case 3:
               obj.quantity(200, "C3");
               obj.item();
               break;
            case 4:
               obj.quantity(35, "R1");
               obj.item();
               break;
            case 5:
               obj.quantity(50, "R2");
               obj.item();
               break;
            case 6:
               System.out.println("Done Ordering");
               exitMenu = true;
               break;
            default:
               System.out.println("Invalid Option");
         }
      }
      obj.item();
      obj.totalPrice();
      
   }
      
}