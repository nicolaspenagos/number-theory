/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * This class provides the implementation of Euclidean algorithm to calculate the Greatest Common Factor between two whole numbers.
 */
public class EuclidesAlgorithm {

	public static void main(String args[]) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			System.out.println("Enter the first positive whole number:");
			int x = Integer.parseInt(br.readLine());
			System.out.println("Enter the second positive whole number:");
			int y = Integer.parseInt(br.readLine());
			System.out.println("GCD:");
			System.out.println(""+ gcf(x,y));
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Euclidean algorithm
	 */
	public static int gcf(int x, int y) {
		
		if(y>x) {
			
			int temp = x;
			x=y;
			y=temp;
			
		}
		
		while(y!=0) {
			
			int r = x%y;
			x=y;
			y=r;
			
		}
		
		return x;
		
	}
	
}
