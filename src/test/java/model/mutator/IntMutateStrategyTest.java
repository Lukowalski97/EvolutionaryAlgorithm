package model.mutator;

import model.problem.Chromosome;
import model.problem.FloatGene;
import model.problem.Gene;
import model.problem.FloatChromosome;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IntMutateStrategyTest {
    FloatMutateStrategy mutator = new FloatMutateStrategy();
    List<Chromosome> list;
    List<Gene> genes1;
    List<Gene> genes2;

    @Before
    public void init() {
        Gene gene1 = new FloatGene(1);
        genes1 = new ArrayList<Gene>();
        genes1.add(gene1);

        Gene gene2 = new FloatGene(5);
        genes2 = new ArrayList<Gene>();
        genes2.add(gene2);

        FloatChromosome chromosome1 = new FloatChromosome();
        chromosome1.setGenes(genes1);
        FloatChromosome chromosome2 = new FloatChromosome();
        chromosome1.setGenes(genes2);

        list = new ArrayList<Chromosome>();
        list.add(chromosome1);
        list.add(chromosome2);
    }

    @Test
    public void mutateChromosomes() {
        List<Chromosome> result = mutator.mutateChromosomes(list);

        assertNotEquals(list , result);
    }
}