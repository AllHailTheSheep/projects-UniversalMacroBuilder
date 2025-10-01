package main.java;


import java.io.File;

public class Main {
    public static void main(String[] args) {
        // check arguments. if -output is specified, next arg should be file path and mode is set to record
        // if -input is specified, next arg should be a file and mode is set to replay
        File out_file = null;
        File in_file = null;

        if (args.length == 0) {
            help();
            throw new IllegalArgumentException("ERROR: No arguments given!");
        }
        for (String arg : args) {
            if (arg.equals("-output")) {
                System.out.println("in out mode");
            }
        }

        // TODO: verify file paths
    }

    private static void help() {
        System.out.println("Usage: UniversalMacroBuilder.jar (-output <out_path> | -input <in_path>");
    }
}
