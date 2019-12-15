package model.problem;

import org.junit.Test;
import static org.junit.Assert.*;


public class LabelChromosomeTest {

    @Test
    public void toStringTest(){
        Chromosome<LabelGene> chromosome =new LabelChromosome();
        LabelGene gene1 = new LabelGene(0);
        LabelGene gene2 = new LabelGene(1);
        chromosome.getGenes().add(gene1);
        chromosome.getGenes().add(gene2);

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(gene1.toString());
        sb.append("|");
        sb.append(gene2.toString());
        sb.append("]");

        String expectedString = sb.toString();

        assertEquals(expectedString,chromosome.toString());

    }

    @Test
    public void toStringEmptyChromosomeTest(){
        LabelChromosome chromosome = new LabelChromosome();
        assertEquals("[]",chromosome.toString());
    }
}
