package com.wipro.custom.cache;

import java.util.LinkedHashSet;
import java.util.Set;

import com.wipro.big.integer.BigInteger;


/*
 * This is a LRU Cache with default size 10,
 * This LRU Cache has 10 as default size
 */
public class LRUCache {
	
	//public static LRUCache cacheObject;
	
	public static Integer cacheSize = 10;
	public static Set<String> cache = new LinkedHashSet<>(cacheSize);
	
	public synchronized static void add(String result)
	{
		if(null!=result)
		{
			if(cache.contains(result)) {
				cache.remove(result);
			}
			if(cache.size()==10)
			{
				if(!cache.contains(result))
				{
					cache.remove(cache.iterator().next());
				}
			}
			cache.add(result);
		}
	}
	
	public static void printCache()
	{
		for(String obj : cache)
		{
			System.out.println(obj);
		}
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer("");
		for(Object obj : cache)
		{
			sb.append(obj);
		}
		return sb.toString();
	}
}
