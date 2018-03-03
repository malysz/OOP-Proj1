package agh.cs.proj1;

import java.util.ArrayList;
import java.util.List;

public class Chapter extends StatueElement{

    public final static ElementType typ = ElementType.Chapter;

    public Chapter(){ super(typ); }

    @Override
    public boolean larger(StatueElement other) {
        if((!other.type.isEqual(ElementType.Section)) && (!other.type.isEqual(ElementType.Chapter)))
            return true;
        else return false;
    }

    @Override
    public boolean smaller(StatueElement other) {
        if(other.type.isEqual(ElementType.Section)) return true;
        return false;
    }

    @Override
    public boolean equal(StatueElement other) {
        if(other.type.isEqual(ElementType.Chapter)) return true;
        return false;
    }
}
