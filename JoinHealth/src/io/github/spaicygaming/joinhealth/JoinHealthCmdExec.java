package io.github.spaicygaming.joinhealth;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class JoinHealthCmdExec implements CommandExecutor{
	
	private JoinHealth main = JoinHealth.getInstance();
	private String prefix = colorMsg("Messages.prefix") + ChatColor.RESET + " ";
	private String noPerms = prefix + colorMsg("Messages.noPerms");
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String alias, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("joinhealth")){
			/*
			 * ARGS 0
			 */
			if (args.length == 0){
				printMenu(s);
			}
			
			/*
			 * ARGS 1
			 */
			else if (args.length == 1){
				/*
				 * HELP
				 */
				if (args[0].equalsIgnoreCase("help")){
					printMenu(s);
				}
				/*
				 * INFO
				 */
				else if (args[0].equalsIgnoreCase("info")) {
					s.sendMessage(ChatColor.DARK_GREEN + "     --=-=-=-=-=-=-=-=-=--");
					s.sendMessage(ChatColor.AQUA + "          JoinHealth " + ChatColor.GRAY + "v" + main.ver);
					s.sendMessage(ChatColor.RED + "    Project: " + ChatColor.ITALIC + main.spigotProject);
					s.sendMessage(ChatColor.RED + "    SourceCode: " + ChatColor.ITALIC + "https://github.com/SpaicyGaming/JoinHealth");
					s.sendMessage(ChatColor.DARK_GREEN + "       --=-=-=-=-=-=-=--");
					s.sendMessage("");
				}
				/*
				 * RELOAD
				 */
				else if (args[0].equalsIgnoreCase("reload")){
					if (s.hasPermission("joinhealth.reload")){
						main.reloadConfig();
						s.sendMessage(prefix + ChatColor.RED + "Config reloaded");
					}
					else{
						s.sendMessage(noPerms);
					}
				}
				//else
				else{
					printMenu(s);
				}
			}
			/*
			 * ARGS != 0 && 1
			 */
			else {
				printMenu(s);
			}

		}
		return false;
	}

	private String colorMsg(String str){
		return ChatColor.translateAlternateColorCodes('&', main.getConfig().getString(str));
	}
	
	private void printMenu(CommandSender s){
		s.sendMessage("");
		s.sendMessage(ChatColor.RED + "   --=-=" + ChatColor.AQUA  + " JoinHealth " + ChatColor.GRAY + "v" + main.ver + ChatColor.RED + " =-=--");
		s.sendMessage(ChatColor.GOLD + "   /jh help " + ChatColor.GREEN + "->" + ChatColor.GRAY + " Shows Subcommands");
		s.sendMessage(ChatColor.GOLD + "   /jh info " + ChatColor.GREEN + "->" + ChatColor.GRAY + " Shows Info");
		s.sendMessage(ChatColor.GOLD + "   /jh reload " + ChatColor.GREEN + "->" + ChatColor.GRAY + " Reloads the Config");
		s.sendMessage(ChatColor.RED + "         --=-=-=-=-=-=--");
		s.sendMessage("");
	}
}
