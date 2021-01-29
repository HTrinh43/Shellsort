package controller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.LinkedList;
import model.LinkedList.LinkedNode;

public class controller {
	
	public LinkedList readValue(final String fileName) {
		/**
		 * Get the value from a file and put them in a linked list
		 * @param filename: the input filename
		 * @return: a linked list with nodes contain value from the file
		 */
		LinkedList list = new LinkedList();
		try {
			  
		      File myObj = new File(fileName);
		      Scanner myReader = new Scanner(myObj);
		      int value;
		      while (myReader.hasNext()) {
		    	  //read data from file

		        if(myReader.hasNextInt()) {
		        	value = myReader.nextInt();
		        		list.add(value);
		        	}
		        }	  
		      myReader.close();
		      //should return the root
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return list;
	}
	
	public String displayList(final LinkedList list) {
		/**
		 *Display the list
		 *@param list: the linked list	
		 *@return: a string contains all nodes' value
		 */
		LinkedNode current = list.getRoot();
		StringBuilder result = new StringBuilder();
		while (current != null) {
			result.append(current.getElement());
			result.append(" ");
			current = current.getNext();
		}
		return result.toString();
	}
	
	public String displayIndex(final LinkedList list) {
		LinkedNode current = list.getRoot();
		StringBuilder result = new StringBuilder();
		while (current != null) {
			result.append(current.getIndex());
			result.append(" ");
			current = current.getNext();
			
		}
		return result.toString();
	}
	
	//https://stackoverflow.com/questions/8491687/write-newline-into-a-file
	public void writeResult(final String filename, final ArrayList<String> list) {
		/**
		 * Write the result to a file
		 * @param filename: name of the file that will be written
		 * @param list: an arraylist contains content 
		 */
		final String filepath = System.getProperty("user.dir") + "/src/test/" + filename + ".txt";
		try {
		      File myFile = new File(filepath);
		      if (myFile.createNewFile()) {
		        System.out.println("File created: " + myFile.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		      
//		      FileWriter myWriter = new FileWriter(filepath);
		      BufferedWriter myWriter = new BufferedWriter(new FileWriter(filepath, true));
		      for (int i = 0; i < list.size(); i++) {
		    	  myWriter.write((String)list.get(i));
		    	  myWriter.newLine();
		      }
		      myWriter.close();
		      
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
