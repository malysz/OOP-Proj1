package agh.cs.proj1;

import java.util.ArrayList;
import java.util.List;

public abstract class StatueElement {
    public final ElementType type;
    private List<String> content = new ArrayList<>();
    List<StatueElement> elements = new ArrayList<>();

    public StatueElement(ElementType type){
        this.type=type;
    }

    public boolean larger(StatueElement other) {
        return false;
    }

    public boolean smaller(StatueElement other) {
        return false;
    }

    public boolean equal(StatueElement other) {
        return false;
    }


    public void addLine(String line){
        content.add(line);
    }

    public void print(){
        for(String line : content){
            System.out.println(line);
        }
    }

    public void printTitle(){
        if(this.type.isEqual(ElementType.Paragraph)){
            System.out.println(content.get(0).substring(0,3));
        }
        else System.out.println(content.get(0));

    }

    public void printList(){
        for(StatueElement el:elements){
            el.printTitle();
            el.printList();
        }
    }

    public void printArticle(int i1, int i2){
        if(this.elements.get(0).type.isEqual(ElementType.Article)){
            this.getElement(i1-1).print();
        }
        else
            printArticle(i1,i2);
    }

    public StatueElement getElement(int i){
        return elements.get(i);
    }
}
