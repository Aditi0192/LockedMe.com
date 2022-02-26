package LockedMePackage;

import java.util.Scanner;

public class LockedMeMain {

	public static void main(String[] args) {
		
		// Welcome Message
		System.out.println("Welcome to Company Lockers Private Limited");
		System.out.println("You can use Locked Me Application to perform multiple file operations");
		System.out.println("This Application is developed by Aditi Patankar...");
		System.out.println("*************************************************************************");
		//char choice , subchoice;
		int choice = 0;
		int subchoice=0;
		String path = "F:\\LockedMe";
		//FileUserOperations FUO1 = new FileUserOperations(path);
		
		
		try  {
			Scanner sc = new Scanner(System.in);
			//System.out.println("Please enter a rootpath in a format Drivename_name\\Directory name ");
			//String path = sc.next();
			//System.out.println(path);
			FileUserOperations FUO = new FileUserOperations(path);
			while (true) {
				
				//Navigation options
				System.out.println("Please select appropriate options");
				System.out.println("*************************************************************************");
				System.out.println("Press 1 to Retrieve File names in Ascending Order");
				System.out.println("Press 2 to perform different File Operations");
				System.out.println("Press 3 to close the Application");
				
				
				//choice = (char) sc.next().charAt(0);
				try {
					choice = sc.nextInt();
				}catch(Exception e){
					System.out.println("Re run the application with valid choice");
					break;
				}
				
				
				//System.out.println(choice);
				
				switch (choice) {

				//main choices

				case 1:

					System.out.println("List of all files");
					System.out.println("***********************");
					
					FUO.getUserFileNames();
					break;

				case 2:
					//selection of sub choice
					System.out.println("*************************************************************************");
					System.out.println("Press 1 to add File in Directory");
					System.out.println("Press 2 to Delete a Specific File");
					System.out.println("Press 3 to Seach a specific file");
					System.out.println("Press 4 Go back to main context");
					
					
				    //subchoice = sc.next().charAt(0);
					try {
						subchoice = sc.nextInt();
					}catch(Exception e){
						System.out.println("Re run the application with valid choice");
						break;
					}
					
				
					switch (subchoice) {

					//sub choice
					case 1:
						System.out.println("You have selected an option to add a file");
						FUO.addUserFile();
						break;

					case 2:
						System.out.println("You have selected an option to add a file");
						FUO.deleteUserFile();
						break;

					case 3:
						System.out.println("You have selected an option to search a file");
						FUO.searchUserFile();
						break;

					case 4:
						System.out.println(" go to main content");
						break;

					default:
						System.out.println("enter a valid option 1,2,3 or 4");
						break;
					} // switch case for sub choice ends
					break;

				case 3:
					System.out.println("Cosing the application......");
					System.out.println("Application closed");
					sc.close();
					System.exit(0);

				default:
					System.out.println("Enter a valid option 1, 2 or 3");
					break;
				}//switch case for choice ends
				
			} //while loop ends
			
			//sc.close();
		} //try ends
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
	} //main method ends

} // class ends
