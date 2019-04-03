package stringAssignments;


import java.awt.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Palindrome {
	public static boolean PalindromeCheck(String s){
		String[] s1=s.split("");
	   HashMap<String,Integer> hm=new HashMap<String,Integer>();
		int count=1;
		for (String str : s1) {
		if(hm.containsKey(str)){
				count=hm.get(str)+1;
				hm.replace(str,count);
		         }
			else
			hm.put(str,count);
	       count=1;
			}
		System.out.println(hm.toString());
		int j=s1.length-1;int result=0;
		String[] s2=new String[s1.length];
	      
		for(int i=0;i<=j;i++)
			s2[i]=s1[j-i];
		
		for(int i=0;i<=j;i++){
		if(s1[i].equals(s2[i]))
			result++;}
		if(result==s1.length)
			return true;
		else 
			return false;
		}
}

