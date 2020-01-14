package net.mcorp.modder.gui.console.actions;

import net.mcorp.modder.gui.console.Console;

public class ExitAction implements ConsoleAction.Action{

	@Override
	public void perform(Console console) {
		console.exit();
	}

}
