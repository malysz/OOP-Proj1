package agh.cs.proj1;

import java.util.ArrayList;
import java.util.List;

public class Letter extends StatueElement{
    public final static ElementType typ = ElementType.Letter;
    public Letter(){
        super(typ);
        this.elements = null;
    }

    @Override
    public boolean larger(StatueElement other) {
        return false;
    }

    @Override
    public boolean smaller(StatueElement other) {
        if(!other.type.isEqual(ElementType.Letter))
            return true;
        else return false;
    }

    @Override
    public boolean equal(StatueElement other) {
        if(other.type.isEqual(ElementType.Letter)) return true;
        else return false;
    }

    @Override
    public void printList(){
        return;
    }
}
