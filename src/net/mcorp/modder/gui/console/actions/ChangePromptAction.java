package net.mcorp.modder.gui.console.actions;

import net.mcorp.modder.gui.console.Console;
import net.mcorp.modder.gui.console.prompts.ConsolePrompt;

public class ChangePromptAction implements ConsoleAction.Action{

	public final ConsolePrompt nextPrompt;
	
	public ChangePromptAction(ConsolePrompt nextPrompt) {
		this.nextPrompt = nextPrompt;
	}
	
	@Override
	public void perform(Console console) {
		console.prompt(nextPrompt);
		System.out.println("Prompting");
	}

	
	
}
