package net.mcorp.modder.gui;

import java.awt.GraphicsEnvironment;

import net.mcorp.modder.Modder;

public class GUIManager {
	
	public static final boolean isHeadless() { return GraphicsEnvironment.isHeadless(); };

	private Thread consoleThread = null;
	public Thread consoleThread() { return this.consoleThread; };
	
	private Console console;
	public Console console() { return this.console; };
	
	public final Modder modder;
	
	/**
	 * Attempts to start up the graphical interface for this application. If the result of {@linkplain #isHeadless()} is true or 
	 * if consoleOverride is true then the console will start instead.
	 * @param consoleOverride - {@linkplain Boolean} - Overrides the graphical interface and forces a console only interface.
	 * @param ideMode - {@linkplain Boolean} - Forces the console to ignore any clear calls, and to ignore any text animations.
	 */
	public GUIManager(Modder modder, boolean consoleOverride, boolean ideMode) {
		this.modder = modder;
		if(consoleOverride || isHeadless()) {
			System.out.println("Starting Console...\n");
			this.startConsole(ideMode);
		}else {
			System.out.println("Starting GUI...");
			this.startGUI();
		}
	}
	
	private void startConsole(boolean ideMode) {
		consoleThread = new Thread(console = new Console(this,ideMode));
		consoleThread.setName("Console - Thread");
		consoleThread.start();
	}
	
	private void startGUI() {
		
	}
	
}
