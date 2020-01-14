package net.mcorp.modder.gui.console.prompts;

import java.io.IOException;

import net.mcorp.modder.gui.console.Console;
import net.mcorp.modder.gui.console.actions.ConsoleAction;

/**
 * <h1>net.mcorp.modder.gui.console.ConsolePrompt</h1>
 * <hr>
 * <p>
 * 	
 * </p>
 * @author Andrew Kerr
 */
public abstract class ConsolePrompt {
	
	/**
	 * Displays the message parameter to the output buffer before waiting for the user to enter a string, terminated by a newline character.
	 * @param message - {@linkplain String} - The message to display before waiting for input.
	 * @return {@linkplain String} - The input given by the user.
	 */
	public static final synchronized String input(String message) {
		System.out.print(message);
		String str = "";
		char c;
		try {
			while((c = (char) System.in.read()) != '\n') {
				str += c;
			}
		} catch (IOException e) {}
		System.out.println();
		return str;
	}
	
	/**
	 * Calls the {@link #input(String)} method using "" for the message and returning the result.
	 * @return {@linkplain String} - The input given by the user, returned from the {@linkplain #input(String)} method.
	 */
	public static final synchronized String input() {
		return ConsolePrompt.input("");
	}
	
	/**
	 * Attempts to clear the screen buffer object, this action will do nothing if {@linkplain Console#ideMode()} returns true.
	 * @return {@linkplain Boolean} - True if the method attempted to clear the screen otherwise False.
	 */
	public static final synchronized boolean clear() {
		if(Console.ideMode())
			return false;
		
		try {
			if (System.getProperty("os.name").contains("Windows"))

	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

	        else

	        	System.out.print("[CLEAR SCREEN]\033[H\033[2J\n");
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * This method is called when this object is being displayed. Inside this method the displaying of the screen will be done, along with the logic behind the screen
	 * such as selection logic will be done. When this method is returned you will either return a {@linkplain ConsoleAction} object or null. If null is returned then
	 * no action has occurred otherwise if a ConsoleAction object is returned then that action will be performed upon returning.
	 * @return {@linkplain ConsoleAction} - The action to perform after returning, or null for no action(s).
	 */
	public abstract ConsoleAction mainloop();
	
}
