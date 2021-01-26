package test;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import controller.Sorting;
import controller.controller;
import model.LinkedList;
import model.LinkedList.LinkedNode;;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sorting sortingAlgo = new Sorting();
		String filepath = System.getProperty("user.dir") + "/src/test/data10.txt";
		controller controller = new controller();
		LinkedList root = controller.readValue(filepath);
		sortingAlgo.bubleSort(root);
		
		System.out.println(controller.displayList(root));
		System.out.println(root.getMiddle().getElement());
		
//		createDataFile("data10", 10);
//		int arr[] = {64, 34, 25, 12, 22, 11, 90}; 
//		bubbleSort(arr);
//		int n = arr.length; 
//        for (int i=0; i<n; ++i) 
//            System.out.print(arr[i] + " "); 
//        System.out.println(); 
    
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
		      
//		      FileWriter myWriter = new FileWriter(filepath);
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
	
	private static void bubbleSort(int[] arr) {
		boolean sorted = false;
		int n = arr.length; 
		while (sorted == false) {
			sorted = true;
			int count = 0;
			while (count < arr.length - 2 ) {
			
                if (arr[count] > arr[count+1]) 
                { 
                    // swap arr[j+1] and arr[j] 
                    int temp = arr[count]; 
                    arr[count] = arr[count+1]; 
                    arr[count+1] = temp; 
                    sorted = false;
                    
                }
                count++;
			}
		}
	}

}
