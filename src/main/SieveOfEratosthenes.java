/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * This class provides the implementation of Sieve Of Eratosthenes algorithm for finding all prime numbers up to any given limit..
 */
public class SieveOfEratosthenes {
	
	public static void main(String args[]) {
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Sieve Of Eratosthenes algorithm for finding all prime numbers up to any given limit.");
			System.out.println("Please enter the limit:");
			
			int n = Integer.parseInt(br.readLine());
			
			System.out.println("Following are the prime numbers smaller than or equal to "+n);
			int[] primes = sieveOfEratosthenes(n);
			System.out.println(Arrays.toString(primes));
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Sieve of Eratosthenes algorithm for finding all prime numbers up to any given limit.
	 * @param n Given Limit. n has to be a natural number smaller than or equal to 2.
	 * @return An array with all prime numbers smaller than or equal to n.
	 */
	public static int[] sieveOfEratosthenes(int n) {
		
		int[] numbers = new int[n-1];
		boolean[] prime = new boolean[n-1];
		boolean[] cross_out = new boolean[n-1];
	
		for (int i = 0; i < numbers.length; i++) {
			
			numbers[i] = i+2;
			prime[i] = true;
			cross_out[i] = false;
			
		}
		
		int current = numbers[0];
		int currentp = 0;
		cross_out[0] = true;
		while(current*current < n) {
			
			for (int i = currentp +1 ; i < cross_out.length; i++) {
				
				if(numbers[i]%current==0) {
					
					cross_out[i] = true;
					prime[i] = false;
				
				}
			}
			
			boolean flag = true;
			for (int i = 0; i < cross_out.length && flag; i++) {
				
				if(prime[i] && !cross_out[i]) {
					
					current = numbers[i];
					currentp = i;
					cross_out[i] = true;
					flag = false;
					
				}
				
			}
			
		}
		
		int primeCounter = 0;
		for (int i = 0; i < prime.length; i++) {
			
			if(prime[i])
				primeCounter++;
		}
		
		int[] primeNumbers = new int[primeCounter];
		int j = 0;
		for (int i = 0; i < prime.length; i++) {
			
			if(prime[i]) {
				
				primeNumbers[j] = numbers[i];
				j++;
				
			}
			
		}
		
		return primeNumbers;

	}
    
}
