package model.evaluator;

import model.problem.Chromosome;
import model.problem.LabelChromosome;
import model.problem.LabelGene;
import model.problem.TravellingSalesmanProblem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TspEvalStrategyTest {

    int n;
    float[][] distances;
    List<Chromosome<LabelGene>> list;
    List<Chromosome<LabelGene>> evaluatedList;
    TravellingSalesmanProblem problem;
    TspEvalStrategy strategy ;

    @Before
    public void init() {
        n = 5;
        distances = new float[n][n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = 2;
            }
        }
        problem = new TravellingSalesmanProblem(distances);
        strategy = new TspEvalStrategy(problem);

    }

    @Test
    public void evaluateChromosomes() {

        Chromosome<LabelGene> chromosome = new LabelChromosome();
        for (int i = 0; i < n; i++) {
            chromosome.getGenes().add(new LabelGene(i));
        }
        list.add(chromosome);

        evaluatedList = strategy.evaluateChromosomes(list);

        assertEquals(-10,list.get(0).getChromosomeFitnessValue(),0.001);

    }
}