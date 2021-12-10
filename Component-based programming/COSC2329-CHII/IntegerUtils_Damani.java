package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public interface IntegerUtils_Damani {
	public static boolean isEven(int k) 
	{
		if(k%2==0)
			return true;
		return false;
	}
	public static boolean isOdd(int k) {
		if (k % 2 != 0)
			return true;
		return false;
	}
	public static boolean isPrime(int k) {
		if(k==0)
			return false;
		else if(k==1)
			return false;
		else if(k==2)
			return true;
		else {
			if(k>2) {
				for(int i=2;i<k;i++) {
					if (k%i==0)
						return false;
				}
			}
			return true;
		}
	}
	public static int greatestCommonFactor(int m, int n) {
		//int gcd=1;
		//while(n>m) {
		//	gcd = m%n;
		//	return n%m;
		//}
	//	return (n % m);
		int gcd;
		while(n!=0) {
			gcd = m%n;
			m=n;
			n=gcd;
			
		}
		return m;
	}
	public static int getGreatestConstrainedMultiple(int k, int maximum) {
		int r;
		int multiple;
		int res=0;
		int max=0;
		if(k>maximum)
			return 0;
			
		else if(k<maximum) {
			r=k%maximum;
			multiple=r*k;
			res=multiple;
		}
		return res;
		
	}
	public static int getIntegerH(int h_q_3, int h_r_5) {
		//int num = h_q_3 * 3;
		//int quotient = num/5;
		//int remainder = num % 5;
		//if(((quotient*5) + remainder)== num)
		//	return num+1;
		//return num+1;
		int remainder = h_r_5;
		int num= h_q_3 * 3;
		int quotient= num/5;
		int res = ((quotient*5) + remainder);
		if(num== res)
				return num;
		return res;
	}
	
	public static int getMaximum(List<Integer> integerSet) {
		//int max = Integer.MIN_VALUE;
		//for(int i=0; i < integerSet.size(); i++) {
		//	if(max<i)
		//		max=i;
		//}
		//return max;
		if(integerSet==null || integerSet.size()==0)
			return Integer.MIN_VALUE;
		List<Integer> max = new ArrayList<Integer>(integerSet);
		Collections.sort(max);
		return max.get(max.size()-1);
		
	}
	public static int getMinimum(int[] intArray) {
		//int min = Integer.MAX_VALUE;
		//for(int i=0; i<intArray.length; i++) {
		//	if(min > i)
		//		min=i;
		//}
		//return min;
		int min=intArray[0];
		for(int i=0; i<intArray.length; i++) {
			if(intArray[i] < min)
				min=intArray[i];
		}
		return min;
	}
	public static boolean isSorted(int[] intArray) //check
	{
		for(int i=0; i<intArray.length-1;i++) {
			if(intArray[i] > intArray[i+1])
				return false;
		}
		return true;
		
	}
	
	public static int getSmallestIndexOfMatch(int[] intArray, int target) //check
	{
		
		//int min=intArray[target];
		int smallestIndex=-1;
		if(intArray==null)
			return smallestIndex;
		int len= intArray.length;
		int i=0;
		while(i<len) {
			if(intArray[i] == target)
				return i;
			i++;
		}
		return smallestIndex;
		//for(int i=0; i<len; i++) {
		//	if(intArray[i] ==target) {
		//		smallestIndex=i;
		//	}
		//}
		//return smallestIndex;
	}
	public static int reverse(int k) {
		int reverse = 0;
		while(k!=0) {
			reverse = reverse*10;
			reverse=reverse+ k%10;
			k=k/10;
		}
		return reverse;
	}
		
	public static int sumthing(long k) {
		
		if(k<10)
			return (int)k;
		int sum=0;
		while(k>0) {
			sum = sum + (int)k % 10;
			k = k/10;
		}
		if(sum > 9) {
			sum=sumthing(sum);
		}
		return sum;
		
		//int sum=0;
		//while(k>0) {
		//	sum+=k%10;
		//	k=k/10;	
		//}
		//if(sum >9) {
		//	sum=sumthing(sum);
		//}
		//return sum;
	}
}
