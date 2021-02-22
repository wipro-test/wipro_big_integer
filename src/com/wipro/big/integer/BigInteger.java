package com.wipro.big.integer;


/*
 * This is a custom Big Integer class,
 * internally supported by int primitive data type
 */
public class BigInteger implements Comparable<BigInteger>
{
	private int num;
	
	public BigInteger() {
		num = 0;
	}
	
	public BigInteger(int num)
	{
		this.num = num;
	}
	
	public BigInteger(String num) throws NumberFormatException 
	{
		this.num = Integer.parseInt(num);
	}
	
	/*
	 * returns the actual value of Big Integer
	 */
	public int getValue()
	{
		return num;
	}
	
	/*
	 * add operation which takes 2 inputs and returns the addition of those 2
	 */
	public BigInteger add(BigInteger operand)
	{
		return new BigInteger(this.getValue() + operand.getValue());
	}
	
	/*
	 * sub operation which takes 2 inputs and returns the subtraction of those 2
	 */
	public BigInteger sub(BigInteger operand)
	{
		return new BigInteger(this.getValue() - operand.getValue());
	}
	
	public int hashCode()
	{
		return num;
	}
	
	public boolean equals(Object object) {
		if (this == object) {
            return true;
        }
		if (object instanceof BigInteger) {
			BigInteger integer = (BigInteger)object;
			return this.num == integer.num;
		}
		return false;
	}
	
	public String toString()
	{
		return Integer.toString(num);
	}

	@Override
	public int compareTo(BigInteger o) {
		if(this.num>o.num)
			return 1;
		else if(this.num<o.num)
			return -1;
		return 0;
	}
}
