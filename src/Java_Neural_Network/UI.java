package Java_Neural_Network;

public class UI {

	public static void writeLine(String message){
		System.out.println(message);
	}

	public static void writeLine(String message, Object[] args){
		System.out.println(String.format(message, args));
	}

}
