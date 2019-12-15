package model.problem;

import java.util.Objects;

public class LabelGene extends Gene {

    private static int charsAmount = 26;
    private int number;

    public LabelGene(int number){
        this.number=number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String toString(){
       char representationChar = (char)( getNumber()% charsAmount + 'A') ;
       long representationNum = getNumber() / charsAmount;
       StringBuilder sb = new StringBuilder();
       sb.append(representationChar);
       sb.append(representationNum);
       return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabelGene labelGene = (LabelGene) o;
        return getNumber() == labelGene.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
