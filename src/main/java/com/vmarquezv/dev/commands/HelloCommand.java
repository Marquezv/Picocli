package com.vmarquezv.dev.commands;

import picocli.CommandLine;

@CommandLine.Command(name="hello", 
		version="1.0.0", 
		mixinStandardHelpOptions = true, 
		requiredOptionMarker = '*',
		description = "This is simple Hello Command", 
		header = "Sample Command", 
		optionListHeading = "%nOptions are:%n")



public class HelloCommand implements Runnable{

	@CommandLine.Option(names={"-u", "--user"}, 
			required = false, 
			description = "Provide User Name", 
			paramLabel="userName=<username>")
	String user;
	
	public static void main( String[] args )
    {
    	new CommandLine(new HelloCommand()).execute(args);
    }

	
	@Override
	public void run() {
		if (user == null || user.length()==0) {
			System.out.println("[hello] Hello World");
		}
		else {
			System.out.println("[hello] Hello " + user);
		}
	}


}