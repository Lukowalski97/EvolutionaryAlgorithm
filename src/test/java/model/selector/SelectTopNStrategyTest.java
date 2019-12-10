package model.selector;

import model.evaluator.PolynomialEvalStrategy;
import model.problem.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SelectTopNStrategyTest {
    SelectTopNStrategy topNStrategy;
    PolynomialProblem problem;
    PolynomialEvalStrategy strategy;
    float[] polynomial = new float[]{1,2,3};
    List<Chromosome> list;
    List<Gene> genes1;
    List<Gene> genes2;
    List<Gene> genes3;

    @Before
    public void init(){
        problem = new PolynomialProblem(polynomial, -10.0f, 10.0f, true);
        strategy = new PolynomialEvalStrategy(problem);
        topNStrategy = new SelectTopNStrategy(2);

        Gene gene1 = new FloatGene(-5);
        genes1 = new ArrayList<Gene>();
        genes1.add(gene1);

        Gene gene2 = new FloatGene(5);
        genes2 = new ArrayList<Gene>();
        genes2.add(gene2);

        Gene gene3 = new FloatGene(0);
        genes3 = new ArrayList<Gene>();
        genes3.add(gene2);

        FloatChromosome chromosome1 = new FloatChromosome(genes1);
        FloatChromosome chromosome2 = new FloatChromosome(genes2);
        FloatChromosome chromosome3 = new FloatChromosome(genes3);

        list = new ArrayList<Chromosome>();
        list.add(chromosome1);
        list.add(chromosome2);
        list.add(chromosome3);
    }

    @Test
    public void selectPersistentChromosomes() {
        List evaluated = strategy.evaluateChromosomes(list);
        List topN = topNStrategy.selectPersistentChromosomes(evaluated);
        assertEquals(topN.size(), 2);
    }
}