package br.com.emersonmendes.jcommand.command;

public class Exit implements Command {

    @Override
    public void exec(String... args) {
        int status = 0;
        if(args.length > 0){
            status = Integer.parseInt(args[0]);
        }
        System.exit(status);
    }

}