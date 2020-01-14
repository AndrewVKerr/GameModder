package net.mcorp.modder.gui.console.prompts;

import net.mcorp.modder.gui.console.actions.ConsoleAction;

public class MainMenuPrompt extends ConsolePrompt {

	@Override
	public ConsoleAction mainloop() {
		
		String mainmenu = "";
		mainmenu += "-=[ Modder | Main Menu ]=-\n";
		mainmenu += "\t1)Games\n";
		mainmenu += "\t2)Options\n";
		mainmenu += "\t3)Credits\n";
		mainmenu += "\tQ)Quit\n";
		mainmenu += "Please select from the provided list.\n";
		mainmenu += "\n";
		System.out.println(mainmenu);
		
		String command = input();
		if(command.equalsIgnoreCase("1")) {
			System.out.println("-=[ Modder | Games ]=-");
		}else
		if(command.equalsIgnoreCase("2")) {
			System.out.println("-=[ Modder | Options ]=-");
		}else
		if(command.equalsIgnoreCase("3")) {
			System.out.println("-=[ Modder | Credits ]=-");
		}else 
		if(command.equalsIgnoreCase("Q")) {
			System.out.println("-=[ Exiting ]=-\nWrapping up before exiting...");
			System.exit(0);
		}else {
			System.out.println("Invalid command choice, please select a valid command.");
		}
		
		return null;
	}

}
