package br.com.emersonmendes.jcommand.command;

public class ShowMessage implements Command {

    @Override
    public void exec(String... args) {
        String msg = String.join(" ", args);
        msg = msg.substring(0, msg.length());
		System.out.println(msg);
    }

}