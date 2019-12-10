package model.problem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FloatGeneTest {
    FloatGene gene;

    @Before
    public void init(){
        gene = new FloatGene(5.0f);
    }

    @Test
    public void getValue() {
        assertEquals(gene.getValue(), 5.0, 0.1);
    }

    @Test
    public void setValue() {
        gene.setValue(1.0f);
        assertEquals(gene.getValue(), 1.0, 0.1);
    }

    @Test
    public void testToString() {
        assertEquals(gene.toString(), "FloatGene{value=5.0}");
    }
}