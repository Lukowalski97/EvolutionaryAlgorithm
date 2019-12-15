package model.problem;

import org.junit.Test;

import static org.junit.Assert.*;

public class LabelGenTest {


    @Test
    public void Lab0StringShouldBeA0() {
        LabelGene gene0 = new LabelGene(0);
        assertEquals("A0", gene0.toString());
    }

    @Test
    public void Lab24StringShouldBeY0() {
        LabelGene gene24 = new LabelGene(24);
        assertEquals("Y0", gene24.toString());
    }

    @Test
    public void Lab123StringShouldBeA4() {
        LabelGene gene129 = new LabelGene(129);
        assertEquals("Z4", gene129.toString());
    }

    @Test
    public void Lab25StringShouldBeZ1() {
        LabelGene gene25 = new LabelGene(25);
        assertEquals("Z0", gene25.toString());
    }

    @Test
    public void Lab26StringShouldBeA1() {
        LabelGene gene26 = new LabelGene(26);
        assertEquals("A1", gene26.toString());
    }

    @Test
    public void setterAndGetterTest() {
        LabelGene gene = new LabelGene(15);
        assertEquals(15,gene.getNumber());
        gene.setNumber(20);
        assertEquals(20,gene.getNumber());

    }

    @Test
    public void hashAndEqualsTest() {

        LabelGene gene1 = new LabelGene(1);
        LabelGene gene2 = new LabelGene(1);
        LabelGene geneDiff = new LabelGene(3);


        assertEquals(gene1, gene2);
        assertNotEquals(gene1, geneDiff);
        assertEquals(gene1.hashCode(), gene2.hashCode());
        assertNotEquals(gene1.hashCode(), geneDiff.hashCode());

    }
}
