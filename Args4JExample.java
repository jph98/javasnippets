import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Args4JExample {

    @Argument(required = true, index = 0, usage = "Action to perform [list|get]")
    private String action;

    public static void main(String[] args) {
        
        Args4JExample client = new Args4JExample();
        CmdLineParser parser = new CmdLineParser(client);
        parser.setUsageWidth(80);

        try {
            parser.parseArgument(args);
            String action = client.getAction();

            if (action.equals("get")) {

                System.out.println("Get called");

            } else {
                System.out.println("No action specified");
            }

        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println(" [options...] arguments...");
            parser.printUsage(System.err);
            System.err.println();
            System.exit(1);
        }
    }

    private String getAction() {
        return action;
    }
}
