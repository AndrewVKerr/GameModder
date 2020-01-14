package net.mcorp.modder.gui.console.actions;

import java.util.ArrayList;

import net.mcorp.modder.gui.console.Console;

/**
 * <h1>net.mcorp.modder.gui.console.actions.ConsoleAction</h1>
 * <hr>
 * <p>
 * 
 * </p>
 * @author Andrew Kerr
 */
public final class ConsoleAction {
	
	/**
	 * <h1>net.mcorp.modder.gui.console.actions.ConsoleAction.Action</h1>
	 * <hr>
	 * <p>
	 * 	This interface defines a singular method {@linkplain #perform(Console)}, upon this method being called the object will
	 * 	perform its action using the console.
	 * </p>
	 * @author Andrew Kerr
	 */
	public static interface Action {
		
		/**
		 * This method will be performed when a certain action takes place.
		 * @param console - {@linkplain Console} - The console to use for editing.
		 */
		public void perform(Console console);
		
	}
	
	/**
	 * This list contains all of the actions that will be performed when the method {@linkplain #performActions(Console)} is called.
	 */
	public final ArrayList<Action> actions = new ArrayList<Action>();
	
	/**
	 * This method will attempt to perform all actions in the {@linkplain #actions} list using the given {@linkplain Console} object.
	 * @param console - {@linkplain Console} - The console to use for editing.
	 */
	public void performActions(Console console) {
		for(Action action : actions) {
			action.perform(console);
		}
	}
	
}
