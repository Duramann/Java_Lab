package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");
            programDriver.addClass("district", District.class,
                    "A map/reduce program that lists the different district.");
            programDriver.addClass("species", Species.class,
                    "A map/reduce program that lists the different species.");
            programDriver.addClass("number_species", NumberTreesSpecies.class,
                    "A map/reduce program that counts the number of trees by species.");
            programDriver.addClass("max_height", MaximumHeight.class,
                    "A map/reduce program that displays the maximum height of each species.");
            programDriver.addClass("sort_height", HeightSort.class,
                    "A map/reduce program that sort the height of the trees.");
            programDriver.addClass("oldest", Oldest.class,
                    "A map/reduce program that displays the district with the oldest tree.");
            programDriver.addClass("trees_district", TreesbyDistrict.class,
                    "A map/reduce program that displays the number of trees by district.");
            programDriver.addClass("max_number", MaxNumber.class,
                    "A map/reduce program that displays the district with the most trees.");

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}


