package Programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class Queue1 {
	
	public static int solution2(int[] priorities, int location) {
		
		class Node{
			int value;
			boolean target;
			
			public Node(int value, boolean target){
				this.value = value;
				this.target = target;
			}
		}
		
		 int answer = 0;
	        int target = priorities[location];
	
	        LinkedList<Node> list = new LinkedList<>();
	 
	        //list 생성
	        for(int i = 0; i<priorities.length; i++) {
	        	boolean t = false;
	        	
	        	if(i == location) {
	        		t = true;
	        	}
	        	
	        	Node node = new Node(priorities[i], t);
	        	
	        	list.add(node);

	        	
	        }
	        
	        Arrays.sort(priorities);
	        
	        for(int i = 0; i<priorities.length; i++) {
	        	
	        	if(list.get(0).value==priorities[priorities.length-answer]) {
	        		//print
	        		answer++;
	        		if(list.get(0).target == true) {
	        			break;
	        		}
	        		list.removeFirst();
	        		
	        	}else {
	        	
	        		list.addLast(list.get(0));
	        		i--;
     			list.removeFirst();

	        	}
	        }
	        
	        return answer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 public static int solution(int[] priorities, int location) {
		 
		 class Node{
				int value;
				boolean target;
				
				public Node(int value, boolean target){
					this.value = value;
					this.target = target;
				}
			}
		 
	        int answer = 0;
	        int target = priorities[location];
	
	        System.out.println("Target : " + target);
	        LinkedList<Node> list = new LinkedList<>();
	        int max_value = -1;
	        int second_max_value = -1;
	        //list 생성
	        for(int i = 0; i<priorities.length; i++) {
	        	boolean t = false;
	        	
	        	if(i == location) {
	        		t = true;
	        	}
	        	
	        	Node node = new Node(priorities[i], t);
	        	
	        	list.add(node);

	        	
	        }
	        
	        System.out.println("max_value : "+max_value);
	        Arrays.sort(priorities);
	        
	        for(int i = 0; i<priorities.length; i++) {
	        	
	        	if(list.get(0).value==priorities[priorities.length-answer]) {
	        		//print
	        		System.out.println("Print");
	        		answer++;
	        		if(list.get(0).target == true) {
	        			break;
	        		}
	        		list.removeFirst();
	        		max_value = second_max_value;
	        	}else {
	        		System.out.println("Pass");
	        		
	        		list.addLast(list.get(0));
	        		i--;
        			list.removeFirst();

	        	}
	        }
	        
	        return answer;
	    }
	 
	 public static void main(String[] args) {
		 int[] priorities = {2,1,3,2};
		 int location = 2;
		 int[] priorities2 = {1,1,9,1,1,1,2,3,1,2,4,3,3,5,3,2,2,3,2,4,5,7,8,6,4,6,6,5,4,6,7,5,7,6,7};
		 int location2 = 22;
		 int answer = solution2(priorities, location);
		 System.out.println("//////////////////////");
		 //int answer2 = solution2(priorities2, location2);
		 System.out.println("Answers");
		 System.out.println(answer);
		 //System.out.println(answer2);
		 Arrays.sort(priorities);
		 for(int i = 0 ; i<priorities.length ; i++) {
			 System.out.println(priorities[i]);
		 }
	}
}
