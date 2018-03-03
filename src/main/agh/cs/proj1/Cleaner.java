package agh.cs.proj1;

import java.util.Arrays;
import java.util.List;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Cleaner {
    private static final List<Pattern> redundantFrags = Arrays.asList(
            "^©Kancelaria Sejmu$",
            "^©Kancelaria Sejmu s. \\d+/\\d+$",
            "^\\d{4}-\\d{2}-\\d{2}$",
            "^[a-zA-Z]{1}"
    ).stream().map(Pattern::compile).collect(Collectors.toList());

    private static final List<Pattern> articleAndParagraph = Arrays.asList(
            "^Art\\. \\d+[a-z]*\\. \\d+\\. .*"
    ).stream().map(Pattern::compile).collect(Collectors.toList());


    public static boolean cleanLine(String line){
        for(Pattern pattern : redundantFrags){
            if(line.matches(pattern.toString())) return true;
        }
        return false;
    }

    public static boolean paragraphToNewLine(String line) {
        return line.matches(articleAndParagraph.get(0).toString());
    }
}
