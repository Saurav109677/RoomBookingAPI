package training;

import java.io.File;
import java.util.Scanner;

public class Training {
	public static void main(String[] args) {
		
	  try {
		Scanner read = new Scanner(new File("C:/Users/MadanMohan/Desktop/training.txt"));
		//read.useDelimiter();
		read.useDelimiter(",");
		String title, category, runningTime, year, price;

		//while (read.hasNext())
		{	
			String empId=read.next();
		   System.out.println(empId);
		   System.out.println(read.next());
		   System.out.println(read.next());
		}
		read.close();
	  }
	  catch(Exception e) {
		  System.out.println("Something error!");
	  }
		
	}
}
