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
//		sortingAlgo.bubbleSort(root); 
		sortingAlgo.shellSort(root);
//		System.out.println(controller.displayList(root));
//		System.out.println(root.getCount());

	}
}
