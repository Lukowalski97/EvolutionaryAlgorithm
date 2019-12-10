package model.evaluator;

import model.problem.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PolynomialEvalStrategyTest {
    PolynomialProblem problem;
    PolynomialEvalStrategy strategy;
    float[] polynomial = new float[]{1,2,3};
    List<Chromosome> list;
    List<Gene> genes1;
    List<Gene> genes2;

    @Before
    public void init(){
        problem = new PolynomialProblem(polynomial, -10.0f, 10.0f, true);
        strategy = new PolynomialEvalStrategy(problem);


        Gene gene1 = new FloatGene(-5);
        genes1 = new ArrayList<Gene>();
        genes1.add(gene1);

        Gene gene2 = new FloatGene(5);
        genes2 = new ArrayList<Gene>();
        genes2.add(gene2);

        FloatChromosome chromosome1 = new FloatChromosome(genes1);
        FloatChromosome chromosome2 = new FloatChromosome(genes2);

        list = new ArrayList<Chromosome>();
        list.add(chromosome1);
        list.add(chromosome2);
    }

    @Test
    public void evaluateChromosomes() {
        List evaluated = strategy.evaluateChromosomes(list);
        Chromosome c1 = (Chromosome) evaluated.get(0);
        Chromosome c2 = (Chromosome) evaluated.get(1);

        assertEquals(c1.getChromosomeFitnessValue(), 66.0, 0.1);
        assertEquals(c2.getChromosomeFitnessValue(), 86.0, 0.1);
    }
}