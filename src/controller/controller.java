package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.LinkedNode;

public class controller {
	
	public LinkedNode readValue(final String fileName) {
		LinkedNode list = new LinkedNode();
		LinkedNode.Node currentNode = list.getRoot();
		try {
			  
		      File myObj = new File(fileName);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  //read data from file
		        String data = myReader.nextLine();
		        int value = 0;
		        if(isInt(data)) {
		        	value = Integer.parseInt(data);
		        }
		        else
		        	continue;

		        //set value of the current node
		        currentNode.setElement(value);
		        //create a next node
		        LinkedNode.Node nextNode = list.newNode();
		        //link current node to next node
		        currentNode.setNext(nextNode);
		        //point current node to next node
		        currentNode = nextNode;

		        
		      }
		      myReader.close();
		      //should return the root
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return list;
	}
	
	public void displayList(final LinkedNode list) {
		LinkedNode.Node current = list.getRoot();
		while (current.getNext() != null) {
			System.out.print(current.getElement());
			System.out.print(" ");
			current = current.getNext();
		}
		System.out.println();
	}
	//https://stackoverflow.com/questions/12558206/how-can-i-check-if-a-value-is-of-type-integer
	private static boolean isInt(String s)
	{
	    try
	    {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}
}
