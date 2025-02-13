package test;

public class CodeGenerator {

	private static char numStart= 0x30;
	private static char numEnd = 0x39;
	private static char upperLetterStart = 0x41;
	private static char upperLetterEnd = 0x5A;
	private static int N = 14;
	private static char[] code = new char[N];
	
	public static void main(String[] args) {
		code = resetCode(code);
		for(int i = 0; i < 10000; i++) {
			updateCode();
			System.out.println(code);
		}
	}
	public static void updateCode() {
		code[N-1] = next(code[N-1]);
		if(code[N-1] == numStart) {
			updateCode(N-2);
		}
	}
	public static void updateCode(int n) {
		code[n] = next(code[n]);
		if(n == 0 && code[n] == numStart) {
			code = resetCode(code);
			return;
		}
		if(code[n] == numStart) {
			updateCode(n-1);
			return;
		}
	}
	private static char[] resetCode(char[] code) {
		char[] newCode = new char[code.length];
		for(int i = 0; i < code.length; i++) {
			newCode[i] = numStart;
		}
		return newCode;
	}
	public static char next(char current) {
		if(isNumbersRangeEnd(current, numEnd)) {
			return upperLetterStart;
		}
		if(isLettersRangeEnd(current, upperLetterEnd)) {
			return numStart;
		}
		char next = (char) (current + 1);
		return next;
	}
	private static boolean isLettersRangeEnd(char current, char lettersEnd) {
		return current == lettersEnd;
	}
	private static boolean isNumbersRangeEnd(char current, char numEnd) {
		return current == numEnd;
	}
}
