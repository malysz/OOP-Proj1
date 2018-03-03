package agh.cs.proj1;

public enum ElementType {
    Section,
    Chapter,
    Article,
    Paragraph,
    Point,
    Letter,
    Preamble;

    public boolean isEqual(ElementType other){
        if(this == other) return true;
        else return false;
    }
}
