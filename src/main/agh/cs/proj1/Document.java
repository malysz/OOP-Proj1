package agh.cs.proj1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Document {
    private static final List<Pattern> elementTitles = Arrays.asList(
            "^DZIAŁ [IVX]*[a-z]?",                //dzial
            "^Rozdział \\d+[a-z]*",               //rozdzial
            "^Rozdział [IVX]*[a-z]?",
            "^Art\\. \\d+\\.",                   //artykul
            "^\\d+[a-z]*\\. .*",                 //ustep
            "^\\d+[a-z]*\\) .*",                 //punkt
            "^[a-z]\\) .*",                     //litera
            "^Art\\. \\d+[a-z]*\\. .*"          //artykul
    ).stream().map(Pattern::compile).collect(Collectors.toList());

    private Stack<StatueElement> loadingStack = new Stack<>();
    private List<String> content = new ArrayList<>();
    private List<StatueElement> elements = new ArrayList<>();

    public Document(String path) throws FileNotFoundException {
        content = FileLoader.loadFile(path);
    }

    public void splitFile() {
        int x=1;
        for (int i = 0; i < content.size(); i++ /*String line : content*/) {
            //section
            if (content.get(i).matches(elementTitles.get(0).toString())) {
                Section section = new Section();
                section.addLine(content.get(i));
                x=0;
                loadContent(section, i, x);
                i=i+x;
                addElement(section);
            }

            //chapter
            else if (content.get(i).matches(elementTitles.get(1).toString()) || content.get(i).matches(elementTitles.get(2).toString())) {
                Chapter chapter = new Chapter();
                chapter.addLine(content.get(i));
                x=0;
                loadContent(chapter, i,x);
                i=i+x;
                //loadingStack.push(chapter);
                addElement(chapter);
            }

            else if (content.get(i).matches(elementTitles.get(3).toString()) || content.get(i).matches(elementTitles.get(7).toString())) {
                Article article = new Article();
                article.addLine(content.get(i));
                x=0;
                loadContent(article, i,x);
                i=i+x;
                //loadingStack.push(article);
                addElement(article);
            }
            else if (content.get(i).matches(elementTitles.get(4).toString())) {
                Paragraph paragraph = new Paragraph();
                paragraph.addLine(content.get(i));
                x=0;
                loadContent(paragraph, i,x);
                i=i+x;
                //loadingStack.push(paragraph);
                addElement(paragraph);
            }
            else if (content.get(i).matches(elementTitles.get(5).toString())) {
                Point point = new Point();
                point.addLine(content.get(i));
                addElement(point);
            }
            else if (content.get(i).matches(elementTitles.get(6).toString())) {
                Letter letter = new Letter();
                letter.addLine(content.get(i));
                addElement(letter);
            }
            else if(content.get(i).equals("KONSTYTUCJA") && content.get(i+1).equals("RZECZYPOSPOLITEJ POLSKIEJ")){
                Preamble preamble = new Preamble();
                x=0;
                loadContent(preamble, i, x);
                i=i+x;
            }
        }
    }

    private void loadContent(StatueElement element, int indexOfLine, int x){
        boolean flag = true;
        while(flag){
            for(Pattern pattern : elementTitles)
                if(content.get(indexOfLine+x).matches(pattern.toString()))
                    flag = false;
            if(flag){
                element.addLine(content.get(indexOfLine+x));
                x++;
            }
        }
    }

    private void addElement(StatueElement element){
        if(!loadingStack.empty()){
            if(loadingStack.peek().larger(element)){
                loadingStack.peek().elements.add(element);
                loadingStack.push(element);
            }
            else if(loadingStack.peek().equal(element)){
                loadingStack.pop();
                addElement(element);
            }
            else if(loadingStack.peek().smaller(element)){
                loadingStack.pop();
                addElement(element);
            }
        }
        else{
            loadingStack.push(element);
            elements.add(element);
        }

    }

    public void printListOfElements(){
        for(StatueElement el:elements){
            el.printTitle();
            el.printList();
        }
    }

    public StatueElement getElement(int i){
        return elements.get(i);
    }

}
