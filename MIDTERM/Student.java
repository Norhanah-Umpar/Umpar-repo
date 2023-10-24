import java.util.Scanner;
public class Student{
   private String first_name;
   private String middle_name;
   private String last_name;
   private String suffix;
   
   void setFirstName(String firstName){this.first_name = firstName;}
   void setMiddleName(String middleName){this.middle_name = middleName;}
   void setLastName(String lastName){this.last_name = lastName;}
   void suffix(String suffix){this.suffix = suffix;}

   
   String getFirstName(){return this.first_name;}
   String getMiddleName(){return this.middle_name;}
   String getLastName(){return this.last_name;}
   String suffix(){return this.suffix;}
   String getFullName(){return first_name + " " + middle_name+" "+ last_name +" "+ this.suffix;}
   
   
   public static void main (String args[]){
      Scanner scan = new Scanner(System.in);
      Student obj = new Student();
      
      System.out.println("First Name: ");
      obj.setFirstName(scan.nextLine());
      System.out.println("Middle Name: ");
      obj.setMiddleName(scan.nextLine());
      System.out.println("Last Name: ");
      obj.setLastName(scan.nextLine());
      System.out.println("suffix Name: ");
      obj.suffix(scan.nextLine());
      
      System.out.println("First Name: "+obj.getFirstName());
      
      System.out.println("Middle Name: "+obj.getMiddleName());
      
      System.out.println("Last Name: "+obj.getLastName());
      
      System.out.println("suffix Name: "+obj.suffix());
      

      System.out.println(obj.getFullName());
      
      
   }
}