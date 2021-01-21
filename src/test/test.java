package test;

import controller.Sorting;
import controller.controller;
import model.LinkedNode;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sorting sortingAlgo = new Sorting();
		String filepath = System.getProperty("user.dir") + "/src/test/data.txt";
		controller controller = new controller();
		LinkedNode root = controller.readValue(filepath);
		sortingAlgo.bubleSort(root);
		controller.displayList(root);
		
		
//		int arr[] = {64, 34, 25, 12, 22, 11, 90}; 
//		bubbleSort(arr);
//		int n = arr.length; 
//        for (int i=0; i<n; ++i) 
//            System.out.print(arr[i] + " "); 
//        System.out.println(); 
    
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
