package com.wipro.big.integer.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.wipro.big.integer.BigInteger;
import com.wipro.custom.cache.LRUCache;

/*
 * Main class for testing Big Integer and cache
 */
public class MainClass 
{
	public static void main(String[] args) 
	{
		//calling a separate static method to keep it modularised
		testBigInteger();
	}

	public static void testBigInteger() 
	{
		//reading inputs from user
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] commands;

		try 
		{
			//reading number of cases
			int cases = Integer.parseInt(br.readLine());

			if (cases > 0) 
			{
				commands = new String[cases];
				for (int i = 0; i < cases; i++) 
				{
					try
					{
						//reading command
						commands[i] = br.readLine();
	
						String[] splits = commands[i].split(" ");
						BigInteger operand1 = null;
						BigInteger operand2 = null;
						
						operand1 = new BigInteger(splits[1]);
						operand2 = new BigInteger(splits[2]);
	
						BigInteger result = null;
						String operator = splits[0].toUpperCase(); 
	
						switch (operator) 
						{
						case "ADD":
							//doing the operation and adding the value to the LRU Cache
							result = operand1.add(operand2);
							addToCache(operand1, operator, operand2, result);
							//System.out.println("Command was " + commands[i] + " and the result is " + result.getValue());
							break;
	
						case "SUB":
							//doing the operation and adding the value to the LRU Cache
							result = operand1.sub(operand2);
							addToCache(operand1, operator, operand2, result);
							//System.out.println("Command was " + commands[i] + " and the result is " + result.getValue());
							break;
	
						default:
							System.out.println("Please Enter correct Command");
						}
					}
					//added separate exception handling to continue the loop even after exception in loop
					catch (NumberFormatException e) {
						System.out.println("Please Enter Correct Numbers");
					}
					catch(IOException e)
					{
						System.out.println("Error while reading input");
					}
					catch(Exception e)
					{
						System.out.println("Error while reading input");
					}
				}
				//printing the results of all the commands from cache
				System.out.println("Output from LRU Cache is : ");
				LRUCache.printCache();
			} 
			else 
			{
				System.out.println("Please Enter correct Number");
			}
		} 
		catch (NumberFormatException e) {
			System.out.println("Please Enter Correct Numbers");
		}
		catch(IOException e)
		{
			//this exception handling is for catching runtime exception and stopping the loop breaking because of them
			System.out.println("Error while reading input");
		}
	}

	private static void addToCache(BigInteger operand1, String operator, BigInteger operand2, BigInteger result) {
		StringBuffer sb = new StringBuffer();
		sb.append(operand1+" ");
		if(operator.equals("ADD"))
			sb.append("+ ");
		else
			sb.append("- ");
		sb.append(operand2+" = "+result);
		LRUCache.add(sb.toString());
		
	}
}
