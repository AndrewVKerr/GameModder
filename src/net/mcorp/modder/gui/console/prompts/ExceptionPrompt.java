package net.mcorp.modder.gui.console.prompts;

import net.mcorp.modder.gui.console.actions.ConsoleAction;

public class ExceptionPrompt extends ConsolePrompt{

	public final Exception e;
	
	public ExceptionPrompt(Exception e) {
		this.e = e;
	}
	
	@Override
	public ConsoleAction mainloop() {
		String screen = "";
		
		screen += "-=[ Modder | Error ]=-\n";
		screen += "\tAn error has occured:\n";
		screen += "\tError Type: "+e.getClass().getSimpleName()+"\n";
		screen += "\tError Description:\n\t"+e.getLocalizedMessage()+"\n\n";
		
		System.out.println(screen);
		
		ExceptionPrompt.input("Press enter to continue:");
		return null;
	}

}
