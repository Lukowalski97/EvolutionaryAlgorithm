package model.problem;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TravellingSalesmanProblemTest {

    float [][]distancesMatrix ;
    TravellingSalesmanProblem problem;
    List<Chromosome<LabelGene>> chromosomes;
    Chromosome<LabelGene> chromosome;
    @Before
    public void init(){
        distancesMatrix= new float[][] {{1,1},{1,1} };
        problem = new TravellingSalesmanProblem(distancesMatrix);
        chromosomes = new ArrayList<>();
        chromosome = new LabelChromosome();

        chromosome.getGenes().add(new LabelGene(1));

        chromosomes.add(chromosome);

    }



    @Test
    public void gettersAndSettersTest() {

        assertArrayEquals(new float[][] {{1,1},{1,1} },problem.getDistancesMatrix());

        problem.setChromosomes(chromosomes);

        assertEquals(new LabelGene(1),
                problem.getChromosomes().get(0).getGenes().get(0));

    }

}