package agh.cs.proj1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class FileLoader {
    /*
    function loads the file with given path and returns its without
    redundant fragments like dates or addnotitions
     */
    public static List loadFile(String path) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        File file = new File(path);
        Scanner in = new Scanner(file);
        String a;
        while(in.hasNextLine()){
            a=in.nextLine();
            if (!Cleaner.cleanLine(a)) {
                if (a.endsWith("-")) {
                    String b = in.next();
                    a = (String) a.subSequence(0, a.length() - 1);
                    a = a.concat(b);
                }
                if(Cleaner.paragraphToNewLine(a)){                      //przeniesienie ustepu do nowej linii jezeli wystepuje
                    String b = a.substring(0,5);                   //w tej samej linii co Art.
                    a=a.substring(5,a.length());
                    do{
                        String c = a.substring(0,1);
                        b=b.concat(c);
                        a=a.substring(1,a.length());
                    } while (!a.startsWith("."));
                    String c = a.substring(0,1);
                    b=b.concat(c);
                    a=a.substring(2,a.length());
                    lines.add(b);
                    //System.out.println(b);
                }
                lines.add(a);
                //System.out.println(a);
            }
        }
       return lines;
    }

}
