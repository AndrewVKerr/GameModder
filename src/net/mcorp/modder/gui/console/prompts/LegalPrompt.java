package net.mcorp.modder.gui.console.prompts;

import net.mcorp.modder.gui.console.actions.ChangePromptAction;
import net.mcorp.modder.gui.console.actions.ConsoleAction;
import net.mcorp.modder.gui.console.actions.ExitAction;

public class LegalPrompt extends ConsolePrompt {

	@Override
	public ConsoleAction mainloop() {
		String legalDisclaimer = "";
		legalDisclaimer += "-=[ Modder | Legal Disclaimer ]=-\n";
		legalDisclaimer += "\tPlease note that this tool is meant only for modding purposes.\n";
		
		legalDisclaimer += "\n-- What can this application do and what it cant do. --\n";
		legalDisclaimer += "\t- This application shall not contain any assets belonging to any games.\n";
		legalDisclaimer += "\t- This application only contains the software necessary to get and load\n";
		legalDisclaimer += "\t    other java classes (using dynamic loading) to pass on information.\n";
		legalDisclaimer += "\t- The mod manager's retrieved by this software will be responsible\n";
		legalDisclaimer += "\t    for making changes to a game and can contain tools used to retrieve\n";
		legalDisclaimer += "\t    assets from games.\n";
		legalDisclaimer += "\t- The mod manager's retrieved by this software **SHALL NEVER** contain any\n";
		legalDisclaimer += "\t    assets from the games unless they are retrieved from the local storage medium(s).\n";
		legalDisclaimer += "\t- The mod manager's will be responsible for maintaining a snapshot of the game files.\n";
		legalDisclaimer += "\t    this snapshot will be restored upon the deletion of the mod manager or the deletion\n";
		legalDisclaimer += "\t    of this program. If this program or the mod manager is deleted manually then\n";
		legalDisclaimer += "\t    this will be voided.\n";
		legalDisclaimer += "\t- The mod manager's will be responsible for always following these rules. Any\n";
		legalDisclaimer += "\t    manager not following these rules will be responsible for any legal action's\n";
		legalDisclaimer += "\t    that may occur.\n";
		
		legalDisclaimer += "\n-- What legal responsibilty do I (you) have? --\n";
		legalDisclaimer += "\t- I (you) understand that these tools may copy assets out of games and store them\n";
		legalDisclaimer += "\t    elsewhere on my device. These assets are used by these tools and will not be\n";
		legalDisclaimer += "\t    used for any other purpose. The copying and/or distributing of these assets off of\n";
		legalDisclaimer += "\t    this device may incurred legal action, and I (you) accept all responsibilty for any\n";
		legalDisclaimer += "\t    legal actions if I (you) misuse these assets.\n";
		legalDisclaimer += "\t- I (you) understand that these tool's are meant as tools and are not meant for\n";
		legalDisclaimer += "\t    any other purpose other than to mod the games they were designed for.\n";
		legalDisclaimer += "\t- I (you) understand that these tool's may be experimental, and that I (you) understand\n";
		legalDisclaimer += "\t    that if any damage to either physical or virtual property occur's then I (you) hold\n";
		legalDisclaimer += "\t    complete responsibilty for said damages.\n";
		legalDisclaimer += "\t- I (you) understand that by using this tool I am responsible for anything that could happen.\n";
		legalDisclaimer += "\n";
		
		legalDisclaimer += "\n-- Summary of legal stuff --\n";
		legalDisclaimer += "\t- I (you) are responsible for anything and everything.\n";
		legalDisclaimer += "\t- This tool is meant to retrieve and execute other software from github that is\n";
		legalDisclaimer += "\t    responsible for modding a game, the software may contain tools to help retrieve\n";
		legalDisclaimer += "\t    assets from the local instance of the game, it shall not contain any of the assets\n";
		legalDisclaimer += "\t    in the download.\n";
		legalDisclaimer += "\t- The software retrieved by this tool is responsible for holding a snapshot of any files\n";
		legalDisclaimer += "\t    it may mess with. These files will be restored upon a proper uninstall, if the removeal\n";
		legalDisclaimer += "\t    of this tool or of the software is done manually then this will be voided.\n";
		legalDisclaimer += "\t- TL;DR - Dont mess around, don't do anything Illegal.\n";
		
		legalDisclaimer += "\n\t\t-- Do you Accept? [YES/no] (Case Sensitive) --\n";
		legalDisclaimer += "\t- By typing 'YES' you agree to everything stated above.\n";
		legalDisclaimer += "\t- By typing anything else you dont agree to everything stated above and you do accept that you will not use this software.\n";
		legalDisclaimer += "\n";
		
		System.out.println(legalDisclaimer);
		
		String accepted = LegalPrompt.input("Do you Accept? [YES/no]: ");
		
		ConsoleAction ca = new ConsoleAction();
		if(accepted.contentEquals("YES")) {
			ca.actions.add(new ChangePromptAction(new MainMenuPrompt()));
			return ca;
		}else {
			ca.actions.add(new ExitAction());
			return ca;
		}
	}

}
