package model.problem;

import model.evaluator.IEvalStrategy;
import model.evaluator.PolynomialEvalStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class ChromosomeTest {
    PolynomialProblem problem;
    IEvalStrategy<FloatGene> eval;
    float[] polynomial = new float[]{1,2,3};
    List<Chromosome<FloatGene>> list;
    List<FloatGene> genes1;
    List<FloatGene> genes2;
    Chromosome<FloatGene> chromosome1;
    Chromosome<FloatGene> chromosome2;
    @Before
    public void init(){
        problem = new PolynomialProblem(polynomial, -10.0f, 10.0f, true);
        eval = new PolynomialEvalStrategy(problem);


        FloatGene gene1 = new FloatGene(-5);
        genes1 = new ArrayList<>();
        genes1.add(gene1);

        FloatGene gene2 = new FloatGene(5);
        genes2 = new ArrayList<>();
        genes2.add(gene2);

        chromosome1 = new FloatChromosome(genes1);
        chromosome2 = new FloatChromosome(genes2);

        list = new ArrayList<>();
        list.add(chromosome1);
        list.add(chromosome2);
    }

    @Test
    public void compareTo() {
        List evaluated = eval.evaluateChromosomes(list);

        assertTrue(chromosome1.compareTo(chromosome2)<0);
    }

    @Test
    public void testToString() {
        assertEquals("[(" + chromosome1.genes.get(0).getValue() + ")]",chromosome1.toString());
    }

    @Test
    public void testGettersAndSettersFitnessValue(){
        Chromosome<LabelGene> chrom = new LabelChromosome();
        chrom.setChromosomeFitnessValue(15);
        assertEquals(chrom.getChromosomeFitnessValue(),15,0.001);
    }

    public void testEqualsAndHashCode(){
        Chromosome<LabelGene> chrom1 = new LabelChromosome();
        Chromosome<LabelGene> chrom2 = new LabelChromosome();
        Chromosome<LabelGene> chromDiff = new LabelChromosome();
        chrom1.getGenes().add(new LabelGene(1));
        chrom2.getGenes().add(new LabelGene(1));
        chromDiff.getGenes().add(new LabelGene(17));

        assertEquals(chrom1,chrom2);
        assertNotEquals(chrom1,chromDiff);
        assertEquals(chrom1.hashCode(),chrom2.hashCode());
        assertNotEquals(chrom1.hashCode(),chromDiff.hashCode());
    }
}