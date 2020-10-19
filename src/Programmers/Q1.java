package Programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1 {
	 public static String solution(String[] participant, String[] completion) {
	        String answer = "";
	        
	        Set<String> VALUES = new HashSet<String>(Arrays.asList(completion));
	        int[] duplicate = hasDuplicate(participant);
	        System.out.println(duplicate[3]);
	        int count = 0;
	        for(int i = 0 ; i<participant.length; i++){
	            if((!VALUES.contains(participant[i]))){
	            	if(duplicate[i]==1) {
	            		count ++;
	            		System.out.println("count up");
	            		if(count ==1) {
	            			System.out.println("duplicated");
	            			answer = participant[i];
	            		}     		
	            	}else {
	                answer=participant[i];
	            	}
	            }
	        }
	      
	        return answer;
	    }
	 public static int[] hasDuplicate(String[] participant) {
		 int[] location = new int[participant.length];
		 
		 Set<String> VALUES = new HashSet<String>(Arrays.asList(participant));
		 for(int i = 0 ; i<participant.length; i++){
			 
	            if(!VALUES.contains(participant[i])){
	            	location[i]=1;
	            }else {
	            	location[i]=0;
	            }
	     }      
		 return location;
	 }
	 
	 public static void main(String[] args) {
		 String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
		 String[] completion =new String[] {"stanko", "ana", "mislav"};
		 
		 String[] participant2 = new String[]{"leo", "kiki", "eden"};
		 String[] completion2 =new String[] {"eden", "kiki"};
		 
		 String answer = solution(participant, completion);
		 System.out.println(answer);
	 }
}

