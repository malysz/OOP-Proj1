package agh.cs.proj1;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends StatueElement{
    public final static ElementType typ = ElementType.Paragraph;
    public Paragraph(){ super(typ); }

    @Override
    public boolean larger(StatueElement other) {
        if(other.type.isEqual(ElementType.Point) || other.type.isEqual(ElementType.Letter))
            return true;
        else return false;
    }

    @Override
    public boolean smaller(StatueElement other) {
        if(other.type.isEqual(ElementType.Section) || other.type.isEqual(ElementType.Chapter) || other.type.isEqual(ElementType.Article))
            return true;
        else return false;
    }

    @Override
    public boolean equal(StatueElement other) {
        if(other.type.isEqual(ElementType.Paragraph)) return true;
        else return false;
    }

    @Override
    public void printList(){
        return;
    }
}
