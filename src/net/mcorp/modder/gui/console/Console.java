package net.mcorp.modder.gui.console;

import java.io.IOException;

import net.mcorp.modder.gui.GUIManager;
import net.mcorp.modder.gui.console.actions.ConsoleAction;
import net.mcorp.modder.gui.console.prompts.ConsolePrompt;
import net.mcorp.modder.gui.console.prompts.ExceptionPrompt;
import net.mcorp.modder.gui.console.prompts.LegalPrompt;

public class Console implements Runnable {

	public final GUIManager guiManager;
	
	private static boolean ideMode;
	public static boolean ideMode() { return ideMode; };
	
	private boolean running = false;
	public void exit() { this.running = false; };
	
	private ConsolePrompt prompt;
	public void prompt(ConsolePrompt prompt) { this.prompt = prompt; };
	
	private boolean signedLegal = false;
	public final boolean signedLegal() { return this.signedLegal; };
	
	public Console(GUIManager guiManager, boolean ideMode) {
		this.guiManager = guiManager;
		Console.ideMode = ideMode;
	}
	
	public synchronized String readLine() {
		String str = "";
		char c;
		try {
			while((c = (char) System.in.read()) != '\n') {
				str += c;
			}
		} catch (IOException e) {}
		return str;
	}

	@Override
	public void run() {
		
		if(this.prompt == null)
			this.prompt = new LegalPrompt();
		
		running = true;
		while(running) {
			
			if(this.prompt == null) {
				NullPointerException npe;
				new ExceptionPrompt(npe = new NullPointerException("No prompt selected, nothing to display. No way to recover from this state, exiting...")).mainloop();
				throw npe;
			}
			
			ConsoleAction action = this.prompt.mainloop();
			if(action != null)
				action.performActions(this);
			
		}
		
	}

}
