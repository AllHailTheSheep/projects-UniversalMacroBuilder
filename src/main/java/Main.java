import java.io.File;

public class Main {
    // only one of these strings and files will be populated per run. we could use an enum to help with telling which mode we're in
    // but we can also just be careful with null checks
    static String out_file_str = null;
    static String in_file_str = null;
    File out_file = null;
    File in_file = null;
    public static void main(String[] args) {
        String argsRes = argChecks(args);
        if (argsRes != null) {
            help();
            throw new IllegalArgumentException(argsRes);
        }

    }

    private static void help() {
        System.out.println("Usage: UniversalMacroBuilder.jar (-output <out_path> | -input <in_path>)");
    }

    private static String argChecks(String[] args) {
        // check arguments. if -output is specified, next arg should be file path and mode is set to record
        // if -input is specified, next arg should be a file and mode is set to replay

        if (args.length == 0) {
            return "ERROR: No arguments given!";
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-output")) {
                System.out.println("in out mode");

                if (i+1 < args.length ) {
                    out_file_str = args[i+1];
                } else {
                    return "ERROR: Argument -output requires an argument!";
                }
            } else if (args[i].equals("-input")) {
                System.out.println("in input mode");
                if (i+1 < args.length ) {
                    in_file_str = args[i+1];
                } else  {
                    return "ERROR: Argument -input requires an argument!";
                }
            } else {
                return "ERROR: Unknown argument: " + args[i];
            }
        }

        // TODO: verify file paths
        return null;
    }
}
