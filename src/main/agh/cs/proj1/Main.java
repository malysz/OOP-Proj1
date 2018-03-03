package agh.cs.proj1;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("konstytucja | uokik\n");
        //String path = "uokik.txt";
        //Document doc = new Document(path);
        //doc.splitFile();
        //doc.printWholeDoc();
        //doc.printListOfElements();
        //doc.printListOfElements();          //spis tresci
        String [] arg = {"-a","10", "konstytucja.txt"};
        Parser.start(arg);
    }
}
