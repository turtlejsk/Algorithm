package test;

import java.util.*;

class asdf {

	public static void main(String[] args) {
		   
		    String a = "";
		    String b ="aaa";
		    a+=b;
		    System.out.println(a);
	}
	
	  public String solution(int[] numbers) {
	        String answer = "";
	        
	        PriorityQueue<Num> pq = new PriorityQueue<Num>();
	        
	        for(int i = 0; i < numbers.length; i++){    
	            double log = Math.log10(numbers[i]);
	            double order;
	            Num n;
	            if(log == 3){
	                order = 1.0;
	                n = new Num(order, numbers[i]);
	                pq.offer(n);
	            }
	            else if(2 <= log && log < 3){
	                order = (double)numbers[i] / 100.0;
	                n = new Num(order, numbers[i]);
	                pq.offer(n);
	               
	            }else if(1 <= log && log < 2){
	                order = (double)numbers[i] / 10.0;
	                n = new Num(order, numbers[i]);
	                pq.offer(n);
	            }else{
	                order = (double)numbers[i];
	                n = new Num(order, numbers[i]);
	                pq.offer(n);
	            }
	        }
	        
	        while(!pq.isEmpty()){
	            Num number = pq.poll();
	            int token = number.original;
	            String tokenStr = String.valueOf(token);
	            answer+=tokenStr;
	        }
	        
	        
	        return answer;
	    }
	    
	    class Num implements Comparable<Num>{
	        double order;
	        int original;
	        
	        public Num(double order, int original){
	            this.order = order;
	            if(order == 9){
	                order = 10;
	            }
	            this.original = original;
	        }
	    
	        @Override
	        public int compareTo(Num num){
	            if(this.order > num.order){
	                return -1;
	            }else if(this.order < num.order){
	                return 1;
	            }else{
	                return 0;
	            }
	        }
	    }
}
