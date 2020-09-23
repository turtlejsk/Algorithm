package test;

import java.util.*;

public class FindPrime {

	public static void main(String[] args) {
		String numbers = "17";
		
		System.out.println(solution(numbers));

	}

	public static int solution(String numbers) {
        int answer = 0;
        
        char[] numbersChar = numbers.toCharArray();
        
        //numbers 각 자리의 int형 배열
		int[] elements = new int[numbersChar.length];
        Arrays.sort(elements);
        for (int i = 0; i < numbers.length(); i++) {
			elements[i] = (int) numbersChar[i] - '0';
		}
        
        LinkedList<Integer> primeArr = new LinkedList<>();
        
		int maxDigit = (int) Math.pow(10.0, numbers.length());
        
        // 7자리 이하 수들이 소수인지 알려주는 배열
		// 소수일 시 1 아닐시 0
		int[] num = new int[maxDigit];

		for (int i : num) {
			i = 0;
		}
        

		primeArr.add(2);
		primeArr.add(3);
		primeArr.add(5);
		primeArr.add(7);
		primeArr.add(11);
		primeArr.add(13);

		num[2] = 1;
		num[3] = 1;
		num[5] = 1;
		num[7] = 1;
		num[11] = 1;
		num[13] = 1;

		for (int i = 5; i < num.length; i++) {
			boolean isPrime = true;
			for (int j = 0; j < primeArr.size(); j++) {
				if (i % primeArr.get(j) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primeArr.add(i);
				num[i] = 1;
			}
		}
        
        for(int primeNum : primeArr){
            String primeString = String.valueOf(primeNum);
            char[] primeChar = primeString.toCharArray();
            LinkedList<Character> primeList = new LinkedList<Character>();
            
            for(char c : primeChar) {
            	primeList.add(c);
            }

            for(int e : elements){
            	char eChar = (char) (e+'0');
            	int eIdx = primeList.indexOf(eChar);
                if(eIdx!= -1){
                	primeList.remove(eIdx);
                }
                
            }if(primeList.size()==0){
                answer++;
            }
        }
        
        return answer;
    }
	
}
