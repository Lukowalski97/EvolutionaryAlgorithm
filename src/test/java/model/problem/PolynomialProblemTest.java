package model.problem;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PolynomialProblemTest {
    PolynomialProblem problem;
    int[] polynomial = new int[]{1,2,3};


    @Before
    public void init(){
        problem = new PolynomialProblem(polynomial);
    }

    @Test
    public void setChromosomes() {
    }

    @Test
    public void setAndGetChromosomes() {
        List<Chromosome> list = new ArrayList<Chromosome>();
        List<Gene> genes1;
        Gene gene1 = new FloatGene(1);
        genes1 = new ArrayList<Gene>();
        genes1.add(gene1);

        FloatChromosome chromosome1 = new FloatChromosome();
        chromosome1.setGenes(genes1);
        list.add(chromosome1);

        problem.setChromosomes(list);
        //System.out.println(problem.getChromosomes().get(0).getGenes().get(0));
        FloatGene gene = (FloatGene) problem.getChromosomes().get(0).getGenes().get(0);
        assertEquals(1, gene.getValue());
    }

    @Test
    public void setPolynomial() {
        problem.setPolynomial(new int[]{2,2,2});

        assertEquals(2, problem.getPolynomial()[0]);
        assertEquals(2, problem.getPolynomial()[1]);
        assertEquals(2, problem.getPolynomial()[2]);
    }

    @Test
    public void getPolynomial() {
        assertEquals(new int[]{1,2,3}.length, problem.getPolynomial().length);
        assertEquals(1, problem.getPolynomial()[0]);
        assertEquals(2, problem.getPolynomial()[1]);
        assertEquals(3, problem.getPolynomial()[2]);
    }
}