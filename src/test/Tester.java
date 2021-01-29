package test;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import controller.Sorting;
import controller.controller;
import model.LinkedList;;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sorting sortingAlgo = new Sorting();
		String filepath = System.getProperty("user.dir") + "/src/data/random100.txt";
		controller controller = new controller();
		LinkedList root = controller.readValue(filepath);
//		sortingAlgo.bubleSort(root); 
		sortingAlgo.shellSort(root);
		System.out.println(controller.displayList(root));
		System.out.println(root.getCount());


//		createRandomDataFile("random100", 100);
//		createRandomDataFile("random1000", 1000);
//		createRandomDataFile("random10000", 10000);
//		createOrderDataFile("order100", 100);
//		createOrderDataFile("order1000", 1000);
//		createOrderDataFile("order10000", 10000);
//		createReverseOrderDataFile("reverse100", 100);
//		createReverseOrderDataFile("reverse1000", 100);
//		createReverseOrderDataFile("reverse10000", 100);
    
	}
	
	public static void createRandomDataFile(final String filename, int size) {
		final String filepath = System.getProperty("user.dir") + "/src/test/" + filename + ".txt";
		try {
			  Random rand = new Random(); //instance of random class
		      int upperbound = size;
		        //generate random values from 0-24
		      int int_random = rand.nextInt(upperbound); 
		      File myFile = new File(filepath);
		      if (myFile.createNewFile()) {
		        System.out.println("File created: " + myFile.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		      
		      BufferedWriter myWriter = new BufferedWriter(new FileWriter(filepath, true));
		      for (int i = 0; i < size; i++) {
		    	  int_random = rand.nextInt(upperbound); 
		    	  myWriter.write(Integer.toString(int_random));
		    	  myWriter.newLine();
		      }
		      myWriter.close();
		      
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public static void createOrderDataFile(final String filename, int size) {
		final String filepath = System.getProperty("user.dir") + "/src/test/" + filename + ".txt";
		try {
		      File myFile = new File(filepath);
		      if (myFile.createNewFile()) {
		        System.out.println("File created: " + myFile.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		      
		      BufferedWriter myWriter = new BufferedWriter(new FileWriter(filepath, true));
		      for (int i = 0; i < size; i++) {
		    	  
		    	  myWriter.write(Integer.toString(i));
		    	  myWriter.newLine();
		      }
		      myWriter.close();
		      
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public static void createReverseOrderDataFile(final String filename, int size) {
		final String filepath = System.getProperty("user.dir") + "/src/test/" + filename + ".txt";
		try {
		      File myFile = new File(filepath);
		      if (myFile.createNewFile()) {
		        System.out.println("File created: " + myFile.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		      
		      BufferedWriter myWriter = new BufferedWriter(new FileWriter(filepath, true));
		      for (int i = size; i > 0; i--) {
		    	  
		    	  myWriter.write(Integer.toString(i));
		    	  myWriter.newLine();
		      }
		      myWriter.close();
		      
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
