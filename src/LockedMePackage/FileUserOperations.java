package LockedMePackage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileUserOperations {

	// private String rootPath = "F:\\LockedMe";
	private String rootPath;

	/**
	 * @param rootPath
	 */
	public FileUserOperations(String rootPath) {
		// super();
		this.rootPath = rootPath;
	}

	// function to add a file
	public void addUserFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select a directory name to add a file");
		String dirName = sc.next();
		// System.out.println(rootPath);
		// System.out.println(dirName);
		File f = new File(rootPath + "\\" + dirName);

		try {
			char answer = 0;
			if (f.exists()) {
				System.out.println("Directory Present");
				getUserFile(dirName);
				return;
			}

			else {
				System.out.println("Mentioned Directory is not present.Please try with existing directory name");
				System.out.println("Do yo want to continue? Y/N");
				while(true) {
				answer= sc.next().charAt(0);
				if(answer=='y'||answer=='Y') {
					addUserFile();
				}
				else if(answer=='n'||answer=='N') {
					System.out.println("returning to main menu");
					System.out.println("**********************************************************************");
					return;
				}
				else {
					System.out.println("Please enter a valid option Y/N");
				}
				}
			}
				
			
			
		} catch (Exception e) {
			System.out.println("Some error occured..plese contact administrator");
		}

	}
	
	
	//method to input user specified file 
	public void getUserFile(String dirN) {
		
		Scanner sc = new Scanner(System.in);
		char answer = 0;
		System.out.println("Enter a filename to add in a mentioned directory");
		String userFileName = sc.next();
		try {
		File myFile = new File(rootPath + "\\" + dirN + "\\" + userFileName); //creation of new file
		if (myFile.exists()) {
			System.out.println("File name already exist..Do you want to replace it? Press Y/N");
			while(true){
			answer = sc.next().charAt(0);
			if (answer == 'y' || answer == 'Y') {
				myFile.delete();
				myFile.createNewFile();
				System.out.println("your file has been added in the location :" + rootPath + "\\" + dirN);
				System.out.println("**********************************************************************");
				return;
			}
			else if (answer == 'n' || answer == 'n') {
				System.out.println("directing back to main options");
				return;
			}
			else {
				System.out.println("Please enter a valid option Y/N");
			}
			}
			
		}//if (myFile.exists()) ends
		else {
			myFile.createNewFile();
			System.out.println("your file has been added in the location :" + rootPath + "\\" + dirN);
			System.out.println("**********************************************************************");
			return;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		
	
	// function to delete a user specific file
	public void deleteUserFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select a directory name to delete a file");
		String dirName = sc.next();
		File f = new File(rootPath + "\\" + dirName);
		try {
			if (f.exists()) {
				System.out.println("Directory Present");
				System.out.println("Enter a filename to delete present in a mentioned directory");
				String userFileName = sc.next();
				File myFile = new File(rootPath + "\\" + dirName + "\\" + userFileName);
				if (myFile.exists()) {
					if (myFile.delete())
						System.out.println("File " + userFileName + " is deleted");
				} else {
					System.out.println("File is not present in the directory, please enter a valid file name");
					userFileName = sc.next();
					myFile = new File(rootPath + "\\" + dirName + "\\" + userFileName);
					myFile.delete();

				}
			}
			else {
				System.out.println("Directory not present");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// function to search a specific file
	public void searchUserFile() {
		Scanner sc = new Scanner(System.in);
		int counter = 0;
		File f = new File(rootPath);
		try {
			String dirList[] = f.list();
		
			System.out.println("Enter a file name to search");
			String userFileName = sc.next();

			for (int i = 0; i < dirList.length; i++) {
				File myFile = new File(rootPath + "\\" + dirList[i] + "\\" + userFileName);
				if (myFile.exists()) {
					System.out.println(userFileName + " is present at " + rootPath + "\\" + dirList[i] + " path");
					counter = 1;
					// break;
				}
			}
			if (counter == 1) {

				System.out.println("Search operation done successfully");
				System.out.println("*****************************************");
				return;
			} else {
				System.out.println("File Not present...");
				System.out.println("Do you want to continue? Y/N");
				while (true) {
					
					char answer = sc.next().charAt(0);
					if (answer == 'y' || answer == 'Y') {
						searchUserFile();
					} else if (answer == 'n' || answer == 'N') {
						return;
					} else {
						System.out.println("Enter a valid option Y/N");
						//answer = sc.next().charAt(0);
					}

				}
				
			}

			
		} // try ends
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	// List file names in ascending order
	public void getUserFileNames() {
		List<String> listOfFiles = new ArrayList<String>();
		// <String>listOfDir = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		File f = new File(rootPath);
		
		if (f.length()==0) {
			System.out.println("Root Directory is empty");
		}//if ends
			
		else {
			try {
				String dirList[] = f.list();
				System.out.println("List of all directories");
				for (String element : dirList) {
					System.out.println(element);
				}//for ends
				for (int i = 0; i < dirList.length; i++) {
					File myFile = new File(rootPath + "\\" + dirList[i]);
					String allFiles[] = myFile.list();
					for (String fs : allFiles) {
						listOfFiles.add(fs);
					}//inner for ends
	
				}//for ends
				Collections.sort(listOfFiles);
				System.out.println("List of files" + listOfFiles);
	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}//function ends
	
	
	
}//class ends
