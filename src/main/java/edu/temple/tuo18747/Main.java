package edu.temple.tuo18747;

import java.io.File;

public class Main {
    // only one of these strings and files will be populated per run. we could use an enum to help with telling which mode we're in
    // but we can also just be careful with null checks
    public static String out_file_str = null;
    public static String in_file_str = null;
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

    public static String argChecks(String[] args) {
        // check arguments. if -output is specified, next arg should be file path and mode is set to record
        // if -input is specified, next arg should be a file

        if (args.length == 0) {
            return "ERROR: No arguments given!";
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-output")) {
                if (out_file_str != null || in_file_str != null) {
                    return "ERROR: Output or input file already specified!";
                } else if (i+1 < args.length) {
                    out_file_str = args[i+1];
                    i++;
                } else {
                    return "ERROR: Argument -output requires an argument!";
                }
            } else if (args[i].equals("-input")) {
                if (out_file_str != null || in_file_str != null) {
                    return "ERROR: Output or input file already specified!";
                } else if (i+1 < args.length ) {
                    in_file_str = args[i+1];
                    i++;
                } else  {
                    return "ERROR: Argument -input requires an argument!";
                }
            } else {
                return "ERROR: Unknown argument: " + args[i];
            }
        }

        if (out_file_str == null && in_file_str == null) {
            return "ERROR: Either -input or -output must be specified!";
        }

        // TODO: verify file paths
        return null;
    }
}
