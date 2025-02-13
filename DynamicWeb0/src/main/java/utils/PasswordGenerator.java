package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;

public class PasswordGenerator {

	private String digits = "0123456789";
	private String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String lowerLetters = "qwertyuioplkjhgfdsazxcvbnm";
	private String special = "!$£%&()=?><,;.:-_#@[]{}";
	private List<String> types = new ArrayList<>();
	private Random random = new Random(DateTime.now().getMillis());
	
	public String generatePassword(int length, boolean useDigits, boolean useUpperLetters,
			boolean useLowerLetters, boolean useSpecial) {
		initTypes(useDigits, useUpperLetters, useLowerLetters, useSpecial);
		String password = "";
		for(int i = 0; i < length; i++) {
			password = password+ randomSymbol(getSymbols(generateType()));
		}
		return password;
	}
	private void initTypes(boolean useDigits, boolean useUpperLetters,
			boolean useLowerLetters, boolean useSpecial) {
		if(useDigits)
			types.add("digits");
		if(useUpperLetters)
			types.add("upperLetters");
		if(useLowerLetters)
			types.add("lowerLetters");
		if(useSpecial)
			types.add("special");
	}
	private int randomInt(int max) {
		return random.nextInt(max);	
	}
	
	//symbols factory
	private String getSymbols(String type) {
		String symbols = "digits";
		if(type.equals("digits"))
			symbols = digits;
		else if(type.equals("upperLetters"))
			symbols = upperLetters;
		else if(type.equals("lowerLetters"))
			symbols = lowerLetters;
		else if(type.equals("special"))
			symbols = special;
		return symbols;
	}
	private String randomSymbol(String symbols) {
		int next = randomInt(symbols.length());
		return ""+symbols.charAt(next);
	}
	private String generateDigit() {
		return randomSymbol(getSymbols("digits"));
	}
	private String generateUpperLetters() {
		return randomSymbol(getSymbols("upperLetters"));
	}
	private String generateType() {
		int next = randomInt(types.size());
		return types.get(next);
	}
	
	private class Symbol {
		
		private String symbols;
		private RandomIntGenerator random;
		
		public Symbol(String symbols) {
			this.symbols = symbols;
			random = new RandomIntGenerator();
		}
		
		public String next() {
			return ""+symbols.charAt(random.next(symbols.length()));
		}
	}
	private class RandomIntGenerator {

		private Random random;
		
		
		public RandomIntGenerator() {
			random = new Random(System.currentTimeMillis());
		}
		public int next(int bound) {
			return random.nextInt(bound);
		}
		
	}
	
	//for rapid testing
	public static void main(String[] args) {
		PasswordGenerator pg = new PasswordGenerator();
//		for(int i = 0; i < 100; i++) {
//			System.out.println(pg.generatePassword(10, true, true, true, true));
//		}
		for(int i = 0; i < 100; i++) {
			System.out.println(pg.generatePassword(10, true, true, false, false));
		}
	}
	
}
