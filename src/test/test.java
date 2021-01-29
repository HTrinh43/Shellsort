package test;
import java.util.Arrays;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import controller.Sorting;
import controller.controller;
import model.LinkedList;;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sorting sortingAlgo = new Sorting();
		String filepath = System.getProperty("user.dir") + "/src/test/data10.txt";
		controller controller = new controller();
		LinkedList root = controller.readValue(filepath);
//		sortingAlgo.bubleSort(root); 
		sortingAlgo.shellSort2(root);
		System.out.println(controller.displayList(root));
		System.out.println(root.getCount());
//		int nums[] = {9,8,7,6,5,4,3,2,1,0};
//		sortingAlgo.shellsortArray(nums);
//        System.out.println("Original Array:");
//        System.out.println(Arrays.toString(nums));

		
//		createDataFile("data10", 10);

    
	}
	
	public static void createDataFile(final String filename, int size) {
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
}
