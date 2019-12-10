package model.problem;

import model.evaluator.PolynomialEvalStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ChromosomeTest {
    PolynomialProblem problem;
    PolynomialEvalStrategy eval;
    float[] polynomial = new float[]{1,2,3};
    List<Chromosome> list;
    List<Gene> genes1;
    List<Gene> genes2;
    Chromosome chromosome1;
    Chromosome chromosome2;
    @Before
    public void init(){
        problem = new PolynomialProblem(polynomial, -10.0f, 10.0f, true);
        eval = new PolynomialEvalStrategy(problem);


        Gene gene1 = new FloatGene(-5);
        genes1 = new ArrayList<Gene>();
        genes1.add(gene1);

        Gene gene2 = new FloatGene(5);
        genes2 = new ArrayList<Gene>();
        genes2.add(gene2);

        chromosome1 = new FloatChromosome(genes1);
        chromosome2 = new FloatChromosome(genes2);

        list = new ArrayList<Chromosome>();
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
        assertEquals(chromosome1.toString(), "Chromosome{genes=[FloatGene{value=-5.0}]}");
    }
}