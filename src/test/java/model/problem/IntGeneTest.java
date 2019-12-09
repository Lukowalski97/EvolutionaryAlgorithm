package model.problem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntGeneTest {
    FloatGene gene;

    @Before
    public void init(){
        gene = new FloatGene(5);
    }

    @Test
    public void getValue() {
        assertEquals(gene.getValue(), 5);
    }

    @Test
    public void setValue() {
        gene.setValue(1);
        assertEquals(gene.getValue(), 1);
    }

    @Test
    public void testToString() {
        assertEquals(gene.toString(), "FloatGene{" +
                "value=" + 5 +
                '}');
    }
}