import java.io.File;

public class Main {
    public static void main(String[] args) {
        // check arguments. if -output is specified, next arg should be file path and mode is set to record
        // if -input is specified, next arg should be a file and mode is set to replay

        // only one of these strings and files will be populated per run. we could use an enum to help with telling which mode we're in
        // but we can also just be careful with null checks
        String out_file_str = null;
        String in_file_str = null;
        File out_file = null;
        File in_file = null;

        if (args.length == 0) {
            help();
            throw new IllegalArgumentException("ERROR: No arguments given!");
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-output")) {
                System.out.println("in out mode");

                if (i+1 < args.length ) {
                   out_file_str = args[i+1];
                } else {
                    help();
                    throw new IllegalArgumentException("ERROR: Argument -output requires an argument!");
                }
            } else if (args[i].equals("-input")) {
                System.out.println("in input mode");
                if (i+1 < args.length ) {
                    in_file_str = args[i+1];
                } else  {
                    help();
                    throw new IllegalArgumentException("ERROR: Argument -input requires an argument!");
                }
            } else {
                help();
                throw new IllegalArgumentException("ERROR: Unknown argument: " + args[i]);
            }
        }

        // TODO: verify file paths
    }

    private static void help() {
        System.out.println("Usage: UniversalMacroBuilder.jar (-output <out_path> | -input <in_path>)");
    }
}
