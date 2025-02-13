package port.persistence;

import java.util.UUID;

public class IdGenerator {

	public static String generateId() {
		return UUID.randomUUID().toString();
	}
	
	public static void main(String[] args) {
		for(int i = 0; i<10;i++) {
			System.out.println(generateId());
		}
	}
}
