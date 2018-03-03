package agh.cs.proj1;

import javax.print.Doc;
import java.io.FileNotFoundException;

public class Parser {
    public static void start(String[] args) throws FileNotFoundException {
        int x=0;
            if(args[0].equals("-st")){      //wyswietlenie spisu tresci
                Document doc = new Document(args[1]);
                doc.splitFile();
                doc.printListOfElements();
            }
            else if(args[0].equals("-a")){  //wyswietlenie artykulu
                int i1 = Integer.parseInt(args[1]);
                Document doc = new Document(args[2]);
                doc.splitFile();
                doc.getElement(0).printArticle(i1,0);
                //printArticle(i1,i2);
                System.out.println("TO DO");
            }
            else if(args[0].equals("-A")){  //wyswietlenie zakresu artykulow
                System.out.println("TO DO");
            }
            else if(args[0].equals("-r")){  //wyswietlenie rozdzialu
                System.out.println("TO DO");
            }
            else throw new IllegalArgumentException(args[x] +" Niewlasciwy argument");

    }
}
