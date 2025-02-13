package test;

import java.util.Random;

public class TestPasswordGenerator {

	private static Random rand = new Random(System.currentTimeMillis());
	public static void main(String[] ars) {
		rand = new Random(System.currentTimeMillis());
		for(int i = 0; i < 1000; i++) {
			System.out.println(rand.nextInt(26));
		}
		
	}
	
}
