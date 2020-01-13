package net.mcorp.modder;

import java.net.URL;

import net.mcorp.modder.gui.GUIManager;
import net.mcorp.modder.urls.URLS;

/**
 * 
 * @author Andrew Kerr
 */
public class Modder {
	
	public final URLS github;
	
	public final GUIManager guiManager;
	
	public Modder(String[] args) {
		github = new URLS(); //TODO: Add file for url storage.
		
		boolean consoleOverride = false;
		boolean ideMode = false;
		
		String prefix = "--";
		try {
			for(String arg : args) {
				if(arg.startsWith(prefix)) {
					String parameter = prefix+"help";
					if(arg.startsWith(parameter)) { //Help command
						String help_screen = "";
						help_screen += "-=[ Modder ]=-\n";
						help_screen += "Parameters: (CASE SENSITIVE)\n";
						help_screen += "\t--github-url:<URL>\t\t| Adds that url to the set of urls used for github.\n";
						help_screen += "\t--console-only\t\t\t| Disables the gui and defaults to the console. (Not all game editors may support this feature.)\n";
						help_screen += "\t--help\t\t\t\t| Displays a set of commands and their uses.\n";
						help_screen += "\t--ide-mode\t\t\t| Disables the clearing of the console as well as disables any text animations.";
						help_screen += "";
						System.out.println(help_screen);
						System.exit(0);
					}else {
					
						parameter = prefix+"github-url:";
						if(arg.startsWith(parameter)) { //Github url for finding and pulling down resources.
							String url = arg.substring(parameter.length());
							github.add(new URL(url));
						}else {
							parameter = prefix+"console-only";
							if(arg.startsWith(parameter)) {
								consoleOverride = true;
							}else {
								parameter = prefix+"ide-mode";
								if(arg.startsWith(parameter)) {
									ideMode = true;
								}else {
									System.out.println("-=[ Modder ]=-\nError:\n\t Unknown parameter:\n\t"+arg.split(":")[0]);
									System.exit(1);
								}
							}
						}
					
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Unable to start modder as a parameter threw a error.",e);
		}
		try {
			if(github.length() == 0)
				github.add(new URL("https://github.com/AndrewVKerr/"));
		}catch(Exception e) {
			throw new RuntimeException("Unable to start modder as a default parameter threw a error. (The best way to fix this is to override the default.)",e);
		}
		
		guiManager = new GUIManager(this,consoleOverride,ideMode);
	}
	
	public static void main(String[] args) {
		new Modder(args);
	}

}
