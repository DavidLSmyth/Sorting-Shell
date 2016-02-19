
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//make sure that a string isn't renamed to another sorting algorithm name
public class sort {
	public static void main(String[]args) throws InstantiationException, IllegalAccessException, IOException{
		//create a variable algo that must implement the SortingAlgorithms interface
		SortingAlgorithms algo=null;
		//Create an arraylist which will hold the objects that implement the SortingAlgorithms interface
		ArrayList<SortingAlgorithms> loadedSortingAlgorithms=new ArrayList<SortingAlgorithms>();
		//begin the program by taking user input
		System.out.println("sort:>");
		Scanner scanner=new Scanner(System.in);
		String input= scanner.nextLine();
		//split the user input according to space
		String[] in=input.split("\\s+");
		//if the user enter quit then exit the program
		if(in[0].equals("quit")){
			System.exit(0);
		}
		//else check if the user types in a keyword
		else{
		//use a do while loop to take in user input
		do{
			if(in[0].equals("load")){
				//check for a valid length of input
				if(in.length==3||in.length==2){
					//check if the class has already been initialised or if the sorting ID is already in use using booleans
					boolean alreadyInitialised=false;
					boolean idAlreadyInUse=false;
					for(int x=0;x<loadedSortingAlgorithms.size();x++){
						if(loadedSortingAlgorithms.get(x).getClass().getName().equals(in[1])){
							alreadyInitialised=true;
							break;
							
						}
					}
					//check if the algorithm is trying to use an id that has already been assigned
					if(in.length==3){
						for(int x=0;x<loadedSortingAlgorithms.size();x++){
							if(loadedSortingAlgorithms.get(x).name().equals(in[2])){
									idAlreadyInUse=true;
							}
						}
					}
					//try and load the class if requirements are met
					try{
						//don't load the class if it has already been initialised
						if(alreadyInitialised==true){
							System.out.println(in[1]+" has already been initialised, please try again");
						}
						//don't load the class if the id it's trying to use is already in use
						else{
							if(idAlreadyInUse==true){
								System.out.println("A sorting algorithm has already been given that ID,please try again");
							}
						//or else load the class using .newInstance()
						else{
							Class<?>cl=Class.forName(in[1]);
						    algo=(SortingAlgorithms)cl.newInstance();
						    //add the algorithm to the list of loaded algorithms
						    loadedSortingAlgorithms.add(algo);
						    //tag the algorithm with an ID if possible
						    if(idAlreadyInUse==false&&in.length==3){
								for(int x=0;x<loadedSortingAlgorithms.size();x++){
									if(loadedSortingAlgorithms.get(x).getClass().getName().equals(in[1])){
										loadedSortingAlgorithms.get(x).name(in[2]);
									}
								}
						    }
						}
						}
					}
					//catch errors in loading the class
					catch(ClassNotFoundException e){
						System.out.println("The class "+in[1]+"doesn't exist in this package");
					}
					catch(NoClassDefFoundError e){
						System.out.println("Class cannot be loaded");
					}
					catch(ClassCastException e){
						System.out.println("Class cannot be loaded");
					}
				}
			}
			else{
			if(in[0].equals("tag")){
				//use a boolean to ensure the Id hasn't already been assigned
				boolean idAlreadyInUse=false;
				boolean classLoaded=false;
				//check if the class has been loaded
				//check if the Id has already been assigned
				if(in.length==3){
					for(int x=0;x<loadedSortingAlgorithms.size();x++){
						if(loadedSortingAlgorithms.get(x).name().equals(in[2])){
								idAlreadyInUse=true;
						}
						if(loadedSortingAlgorithms.get(x).getClass().getName().equals(in[1])){
							classLoaded=true;
						}	
					}
					if(idAlreadyInUse==true){
						System.out.println(in[2]+" is already being used as an ID, please try again");
					}
					if(classLoaded==false){
						System.out.println(in[1]+" hasn't been loaded yet, please load the class first before tagging it");
					}
					//if Id hasn't already been assigned to another sorting algorithm, allow algorithm to be tagged
					if(idAlreadyInUse==false&&classLoaded==true){
					//check to see if the class name provided has been loaded already
						for(int x=0;x<loadedSortingAlgorithms.size();x++){
							if(loadedSortingAlgorithms.get(x).getClass().getName().equals(in[1])){
								loadedSortingAlgorithms.get(x).name(in[2]);
							}
						}
					}
				}
				//print out a message informing the user of the necessary input 
				else{
					System.out.println("Please provide the name of a sorting algorithm and an identifier as parameters with the keyword tag");
				}
			}
			else{
				
			if(in[0].equals("sort")){
				if(in.length==4){
					//ensure that the ID provided has been assigned to a sorting algorithm
					boolean validID=false;
					for(int i=0;i < loadedSortingAlgorithms.size();i++){
						if(loadedSortingAlgorithms.get(i).name().equals(in[1])){
							validID=true;
							//create a new file object with the name provided by the user
							File f=new File(in[2]+".txt");
							//check that the file provided exists
							if(f.exists()){
								//Get the data from the file using a FileInputStream
								FileInputStream fis=new FileInputStream(f);
								byte[] bytes = new byte[(int) f.length()];
								fis.read(bytes);
								fis.close();
								//separate out the individual numbers into an array of strings
								String[] valueStr = new String(bytes).trim().split("\\s+");
								int[] data = new int[valueStr.length];
								//transfer the string values into an integer array
								for (int a = 0; a < valueStr.length-1; a++) {
									   data[a] = Integer.parseInt(valueStr[a]);
								}
								//write the sorted data to a file given by the user
								int[] toWrite=algo.sort(data);
								try {
									//create a new file object
								      File file = new File(in[3]+".txt");
								      //create a new file if a file of the name specified by the user doesn't exist
								      if (file.createNewFile()){
								        System.out.println("File is created with sorted data and can be found at: "+file.getAbsolutePath());
								      }
								      else{
								    	//Otherwise overwrite the file given by the user
								        System.out.println("File already exists and was overwritten with sorted data. It can be found at: "+file.getAbsolutePath());
								      } 
							    } 
								//catch exceptions in creating the new file
								catch (IOException e) {
								      	System.out.println("An error occured in creating the new file");
								}
								//User a BufferedWriter to write the sorted data to a file
								BufferedWriter writefile = new BufferedWriter(new FileWriter(in[3]+".txt")); 
								for(int x=0;x<algo.sort(data).length;x++){
									writefile.write(String.valueOf(toWrite[x])+" ");
								}
								//Close the file
								writefile.close();
					
							}
							//Provide message in case of file not existing
							else{
								System.out.println("The file of the name provided doesn't exist. No data could be sorted.");
							}
						}
					}
					//print helpful message if the ID isn't valid
					if(validID==false){
						System.out.println("You haven't provided a valid ID for a sorting algorithm");
						}
					}
					//print helpful message if the user provides the wrong number of parameters
					else{
						System.out.println("Please provide an ID, an input file and an output file with the keyword sort");
					}
			}
			else{
			if(in[0].equals("unload")){
				boolean loaded=false;
				//check that a parameter was provided with the unload keyword
				if (in.length==2){
					for(int x=0;x<loadedSortingAlgorithms.size();x++){
						//check that a loaded algorithm has the same name as the algorithm that the user is trying to unload
						if(loadedSortingAlgorithms.get(x).getClass().getName().equals(in[1])){
							System.out.println(loadedSortingAlgorithms.get(x).getClass().getName()+" has been unloaded from the sorting shell.");
							//Sorting Algorithm object should be removed from memory by the garbage collector as it is only referenced in the arraylist
							loadedSortingAlgorithms.remove(loadedSortingAlgorithms.get(x));
							loaded=true;
							break;
						}
					}
					if(loaded==false){
						System.out.println("This algorithm hasn't been loaded, please give a loaded algorithm to unload");
					}
				}
				//print a helpful error message if the user provides and invalid sorting algorithm name
				else{
					//System.out.println("Please provide the name of a sorting algorithm that has been loaded with the keyword unload");
				}
			}
			//print a helpful message if the user provides a non keyword command
			else{
				System.out.println(in[0]+" is not a valid command, please enter a valid command");
			}
			}
			}
			}
			//wait for further user input
			System.out.println("sort:>");
			input= scanner.nextLine();
			in=input.split("\\s+");
		}while(in[0].equals("quit")!=true);	
	}
		scanner.close();
	}
}
