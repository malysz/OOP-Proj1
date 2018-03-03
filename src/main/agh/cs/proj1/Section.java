package agh.cs.proj1;

import java.util.ArrayList;
import java.util.List;

public class Section extends StatueElement{
    public final static ElementType typ = ElementType.Section;

    public Section(){
        super(typ);
    }


    @Override
    public boolean larger(StatueElement other){
        return false;
    }

    @Override
    public boolean smaller(StatueElement other){
        if(!other.type.isEqual(ElementType.Section)) return true;
        else return false;
    }

    @Override
    public boolean equal(StatueElement other){
        if(other.type.isEqual(ElementType.Section)) return true;
        else return false;
    }
}
