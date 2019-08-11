package stringAssignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NameKey {
	public static void NameKeyvalue(String[] s){
		
		List Intial=new ArrayList();
		HashMap <String,Integer>Second=new HashMap<String,Integer>();
		int count=0;
		for (String s1 : s) {
			if(Intial.contains(s1)){
				if(Second.containsKey(s1)){
				count=Second.get(s1)+1;
				Second.put(s1,count);
				Intial.add(s1+" "+count);
				}
				else{
				Second.put(s1,count);
				}
				}
			else
			Intial.add(s1);
			Second.put(s1,count);
			
			}
		System.out.println(Intial.toString());
		
		
}

}
