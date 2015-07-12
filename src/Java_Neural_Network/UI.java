/*
 *   Enables messages to sent the UI.
 *   
 *   Currently just prints to the console.
 */

package Java_Neural_Network;

public class UI {

	public static void write(String message){
		System.out.print(message);
	}
	
	public static void writeLine(String message){
		System.out.println(message);
	}

	public static void writeLine(String message, Object[] args){
		System.out.println(String.format(message, args));
	}

}
