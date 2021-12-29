//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-substrings-having-at-most-k-unique-characters-official/ojquestion
//Count Of Substrings Having At Most K Unique Characters

import java.util.*;

public class Main {

	public static int solution(String s, int k) {
		int ans = 0, distinctCount = 0, release=0;
		Map<Character,Integer> map = new HashMap<>();
		
		for(int accquire =0; accquire< s.length();accquire++){
		    char curr = s.charAt(accquire);
		    if(map.containsKey(curr)){
		        map.put(curr,map.get(curr)+1);
		    }else{
		        distinctCount +=1;
		        map.put(curr,1);
		    }
		    while(release<=accquire && distinctCount >k){
		        char disChar = s.charAt(release);
		        map.put(disChar,map.get(disChar)-1);
		        release +=1;
		        
		        if(map.get(disChar)==0){
		            map.remove(disChar);
		            distinctCount -= 1;
		        }    
		    }
		    ans +=accquire-release+1;  
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
