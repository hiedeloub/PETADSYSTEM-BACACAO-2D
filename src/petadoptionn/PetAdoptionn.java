package petadoptionn;

import java.util.Scanner;

public class PetAdoptionn {

   
    public static void main(String[] args) {
  
        
        
        try (Scanner sc = new Scanner(System.in)) {
            boolean exit = true;
            
            
            
            
            System.out.println("1. PET");
            System.out.println("2. FOSTER PARENT");
            System.out.println("3. ADOPTION RECORD");
            System.out.println("4. EXIT");   
            
            System.out.print("Enter Action: ");
            int act = sc.nextInt();
            
            switch(act){
                case 1:
                    pet pet = new pet ();
                    pet.precord();
                    break;
                    
                case 2:
                    fosterparent fosterparent = new fosterparent ();
                    fosterparent.fprecord();
                    break;
                    
                case 3:
                    adoptionrecord adoptionrecord = new adoptionrecord ();
                    adoptionrecord.arrecord();
                    break;
                    
                case 4:
                    System.out.println("Exiting... U SURE? (yes/no): ");
                    String resp = sc.next();
                    if(resp.equalsIgnoreCase("yes")){
                        exit = false;
                    }
                    break;
                    
                default:
                    System.out.println("Invalid action. Try Again!!");
                    break;
            }
            while (exit);
            System.out.println("TENKS, BYE!");
        }
        
        }

    
}
