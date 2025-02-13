package test;

public class TestDecimal {

	public static void main(String[] args) {
		float f = 1F / 3F;
		float f1 =f - 0.0056F;
		long rounded = Math.round(f * 100);
		float f2d = rounded / 100F;
		System.out.println(""+f2d);
		
	}
	
}
