package br.com.emersonmendes.jcommand.command;

import java.util.Arrays;
import java.util.Optional;

public enum CommandType {

    SHOW_MESSAGE("sm", new ShowMessage()),
    EXIT("exit", new Exit());
    
    private String key;

    private Command command;

    CommandType( String key, Command command ) {
        this.key = key;
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public static CommandType forValue(String key) {
        
        Optional<CommandType> result = Arrays.asList(CommandType.values())
            .stream()
            .filter( cmd -> key.equals(cmd.key))
            .findFirst();
        
        if(result.isPresent()){
            return result.get();
        }

        throw new IllegalArgumentException("command not found ¯\\_(ツ)_/¯");

    }

}