package petadoptionn;

import java.util.Scanner;


public class fosterparent {
    
public static void fprecord() {
        
        
           Scanner sc = new Scanner(System.in);
           String response;
           do{
        
         System.out.println("\nFoster Parent");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
       
     System.out.print("Enter action: ");
            int action = sc.nextInt();
            fosterparent fparent = new fosterparent ();
            switch(action){
               case 1:
                    fparent.addfparent();
                break;
                
                case 2:
                    fparent. viewfparent();
                    break;
                    
                case 3:
                    fparent. viewfparent();
                    fparent. updatefparent();
                    fparent. viewfparent();
                    break;
                
                case 4:
                    fparent. viewfparent();
                    fparent. deletefparent();
                    fparent. viewfparent();
                    break;
                    
                case 5:
                    System.out.println("exiting");
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
                   
           
            }
             System.out.println("Do you want to continue? (yes/no): ");
             response = sc.next();
                    
           }while(response.equalsIgnoreCase("yes"));
           System.out.println("Thank You! ");
    }

    public void addfparent(){
        Scanner sc = new Scanner(System.in);
   
        System.out.print("first name: ");
        String fname = sc.next();
        System.out.print("last name: ");
        String lname = sc.next();
        System.out.print("address: ");
        String address = sc.next();
        System.out.print("contact: ");
        String contact = sc.next();

        String sql = "INSERT INTO tbl_fosterparent (fname,lname, address,contact) VALUES (?, ?, ?, ?)";
        config conf = new config();
        conf.addRecord(sql, fname, lname, address, contact);
              
     }
          
      public void viewfparent() {
       
        String qry = "SELECT * FROM tbl_fosterparent";
        String[] hrds = {"ID" ,"first name", "last name", "address", "contact"};
        String[] clm = {"fp_id", "fname", "lname", "address", "contact"};
        
        config conf = new config();
        
        conf.viewRecords(qry, hrds, clm);
    }
   
    
    private void updatefparent(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the id to update: ");
        int id = sc.nextInt();
       
        System.out.print("first name: ");
        String fname = sc.next();
        System.out.print("last name: ");
        String lname = sc.next();
        System.out.print("address: ");
        String address = sc.next();
        System.out.print("contact: ");
        String contact = sc.next();

        String qry = "UPDATE tbl_fosterparent SET fname = ?,lname = ?, address = ?,contact = ? WHERE fp_id = ?";
        
        config conf = new config();
        conf.updateRecord(qry, fname,lname, address, contact, id);
        
    }
    
      private void deletefparent() {
          Scanner sc = new Scanner(System.in);
          config conf = new config();
          System.out.println("Enter the id to delete");
          int id = sc.nextInt();
          
          while(conf.getSingleValue("SELECT fp_id FROM tbl_fosterparent WHERE fp_id = ?", id) == 0){
             System.out. print("Selected ID doesn't exist!");
             System.out. print("Select FP ID Again: ");
             id = sc.nextInt();
}
          
          String qry = "DELETE FROM tbl_fosterparent WHERE fp_id = ?";
          conf.deleteRecord(qry,id);
          
    }


      }