package CompanyLockers;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class MainMenuLockers {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		infoMenu();
		mainMenu();
	}
	
	public static void infoMenu() { 
		
		System.out.println("_________________________________________________________________________");
		 System.out.println("*************************************************************************");
		 System.out.println("*********************  The Company Lockers Pvt. Ltd. ********************");
		 System.out.println("*********************       LockedMe.com.  app       ********************");
		 System.out.println("*************************************************************************");
		 System.out.println("************************************    Developed by: Nur Shambaeva   ***");
		 System.out.println("*************************************************************************");
	}
		 
	public static void mainMenu() {
		 
		System.out.println("_________________________________________________________________________");
		System.out.println();
		 System.out.println("          ***   MAIN MENU   ***");
		 System.out.println();
		 System.out.println("          1. Retrieving the file names in an ascending order");
		 System.out.println("          2. Business-level operations");
		 System.out.println("          3. Close the application");
		 System.out.println("_________________________________________________________________________");
		 System.out.println();
		 System.out.print("          Enter Your Choice Number: __ ");
		 
		 String choice = scanner.nextLine();
		 switch (choice) {
		 case "1":
			 System.out.println("_________________________________________________________________________");
			 ListOfFileInDirectory();
			 break;
		 case "2":
			 BusinessLevelOperationsMain();
			 break;
		 case "3":
			 System.out.println("_________________________________________________________________________");
			 System.out.println("      Thanks for using LockedMe.com  app.");
			 System.out.println("          Closing application.");
			 System.out.println("_________________________________________________________________________");
			 infoMenu();
             System.exit(0);	 
			 break;
		default:
			System.out.println("_________________________________________________________________________");
			System.out.println("          Invalid input provided");		
			System.out.println("        Please choose again  1  2  3");		
			mainMenu();
		 }
	}
		
	 private static void ListOfFileInDirectory() {
		 
		 try {
			  File file1 = new File("");
			  String filePath= file1.getAbsolutePath();
			 // System.out.println(filePath);
			  File dir=new File(filePath);
			 File listFiles[]=dir.listFiles();
			 Arrays.sort(listFiles);	
			 for(File file:listFiles){              
			        System.out.println("      "+file.getName());
			 	}
			 }
			 catch(Exception e){
				 e.printStackTrace();  
			 }
		 mainMenu();
	 }

	 public static void BusinessLevelOperationsMain(){
		 System.out.println("_________________________________________________________________________");
		 System.out.println("        Business-level operations: ");
		 System.out.println();
		 System.out.println("          1.  Option to add a File");
		 System.out.println("          2.  Option to delete a File");
		 System.out.println("          3.  Option to search a File");
		 System.out.println("          4.  Back to main menu");
		 System.out.println("_________________________________________________________________________");
		 System.out.println();
		 System.out.print("          Enter Your Choice Number: __ ");
		
		 String choice = scanner.nextLine();
		 switch (choice) {
		 case "1":
			 optionAdd();
			 break;
		 case "2":
			 optionDelete();
			 break;
		 case "3":
			 optionSearch();
			 break;
		 case "4":
			 mainMenu();
			 break;
		default:
			System.out.println("_________________________________________________________________________");
			System.out.println("          Invalid input provided");		
			System.out.println("        Please choose again  1  2  3  4");	
			BusinessLevelOperationsMain();
		 }
	}

	 public static void optionAdd(){ 
		 System.out.print("        Please enter a file name to add : __");
		 String fileName = scanner.nextLine();
		 File newFile = new File(fileName);
		 try {
			 if (newFile.createNewFile()) {  
				 System.out.println("        New File is created!");
				 System.out.println("     File path : "+newFile.getAbsolutePath());
			 } else {
				 System.out.println("        File already exists.");	
			 	}
		 } catch (IOException e) {
			 System.out.print("        Please enter a correct file name !");
			// e.printStackTrace();
		 }
	
		 BusinessLevelOperationsMain();
	 }

	 public static void optionDelete(){
		 System.out.print("        Please enter a file name to delete : __");
		 String fileName = scanner.nextLine();
		 File delFile = new File(fileName);
		 boolean b = delFile.delete();
		if (b == true)
		{
        	System.out.println("        File deleted !");
        } else {
        	System.out.println("        File not found !");
        	}
	
		BusinessLevelOperationsMain();
	 }

	 public static void optionSearch(){ 
		 System.out.print("        Please enter a searching file name : __");
		 String fileName = scanner.nextLine();
		 File searchlFile = new File(fileName);
		 if(searchlFile.exists())
		 { 
			 System.out.println("        "+searchlFile.getName()+" - File found ");	
			 System.out.println("        File path:" + searchlFile.getAbsolutePath());
		 } else {
    	 System.out.println("        File not Found !");
		 }
	
		 BusinessLevelOperationsMain();
	 }

}  