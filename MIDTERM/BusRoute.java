import java.util.Scanner;

public class BusRoute{
   public static void main(String[]args){
      Scanner scan = new Scanner(System.in);
      double CebuToCarCar = 39.1;
      double CarCarToSibonga = 13.2;
      double CarCarToBarili = 18.1;
      double BariliToMoalboal = 30.3;
      double SibongaToDumanjug = 32.7;
      double SibongaToArgao = 26.5;
      double DumanjugToMoalboal = 18.9;
      double ArgaoToMoalboal = 31.8;
      
      double td, td2, td3;
            
      System.out.println("Welcome to South Bus");
      
      System.out.println("Cebu City-Start\nRoute 1-Minglanilla\nRoute 2-San Fernando\nRoute 3-Carcar");
      
      System.out.println("Is Barili obstructed?: [1]Yes [2]No");
      int choice = scan.nextInt();
         switch(choice){
            case 1: System.out.println("Yes Obstructed");
               System.out.println("Route 4.2-Sibonga");
               System.out.println("Is Dumanjug obstructed? [1]Yes [2]No");
               int choice2 = scan.nextInt();
                  switch(choice2){
                     case 1: System.out.println("Yes Obstrcuted");
                        System.out.println("Route 5-Argao\nRoute 5.1-Ronda\nroute 5.2-Alcantara\nMoalBoal-End");
                        System.out.println("Enter Speed km/hr: ");
                        double speed3 = scan.nextInt();
                        td3 = CebuToCarCar + CarCarToSibonga + SibongaToDumanjug+ DumanjugToMoalboal;
                        System.out.println("Total Distance: "+td3+"km");
                        double TotalTime3 = td3/speed3; 
                        System.out.println("TOA: "+TotalTime3+"hr");
                                                
                        break;
                     case 2: System.out.println("Not Obstructed");
                        System.out.println("Route 4.2.1-Dumanjug\nRoute 4.2.2-Alcantara\nMoalboal-End");
                        System.out.println("Enter Speed km/hr: ");
                        double speed2 = scan.nextInt();
                        td2 = CebuToCarCar + CarCarToSibonga + SibongaToArgao + ArgaoToMoalboal;
                        System.out.println("Total Distance: "+td2+"km");
                        double TotalTime2 = td2/speed2;
                        System.out.println("TOA: "+TotalTime2+"hr");
                        
                        break;                  
                  }
            break;
            case 2: System.out.println("Not Obstrcuted");
               System.out.println("Route 4.1-Barili\nRoute 4.1.1-Dumanjug\nRoute 4.1.2-Alcantara\nMoalBoal-End");
               System.out.println("Enter Speed km/hr: ");
               double speed = scan.nextInt(); 
               td = CebuToCarCar + CarCarToBarili + BariliToMoalboal;
               System.out.println("Total Distance: "+td+"km");
               double TotalTime = td/speed;
               System.out.println("TOA: "+TotalTime+"hr"); 
               break;
         }       
   }
}