package br.com.emersonmendes.jcommand;

import br.com.emersonmendes.jcommand.command.Command;
import br.com.emersonmendes.jcommand.command.CommandType;

public class Executor {

	public static void exec(String commandName, String... args) {
		Command command = CommandType.forValue(commandName).getCommand();
		command.exec(args);
	}
    
}