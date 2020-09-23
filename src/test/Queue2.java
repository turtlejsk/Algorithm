package test;

import java.util.LinkedList;

public class Queue2 {
	
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		
		 class Truck{
			int weight;
			int location;
			public Truck(int weight, int location) {
				this.weight = weight;
				this.location = location;
			}
		}
		
		int answer = 0;

		int total = 0;

		if(truck_weights.length == 1) {
			return bridge_length+1;
		}
		
		LinkedList<Truck> trucks = new LinkedList<>();
		LinkedList<Truck> running = new LinkedList<>();
		LinkedList<Truck> done = new LinkedList<>();
		
		for (int i : truck_weights) {
			Truck truck = new Truck(i, 0);
			trucks.add(truck);
		}

		while (!trucks.isEmpty()) {
			while(total < weight) {
				total += trucks.getFirst().weight;
				running.add(trucks.getFirst());
			}
		
		}

		return answer;
	}

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };

		int bridge_length2 = 100;
		int weight2 = 100;
		int[] truck_weights2 = { 10 };

		int bridge_length3 = 100;
		int weight3 = 100;
		int[] truck_weights3 = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

		
		
		System.out.println("ANSWERS");
		System.out.println();
		int answer = solution(bridge_length, weight, truck_weights);
		System.out.println(answer);
		int answer2 = solution(bridge_length2, weight2, truck_weights2);
		System.out.println(answer2);
		int answer3 = solution(bridge_length3, weight3, truck_weights3);
		System.out.println(answer3);
	}
}
