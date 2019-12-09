package framework;

import model.crossbreeder.FloatCrossStrategy;
import model.initializer.FloatInitStrategy;
import model.mutator.FloatMutateStrategy;
import model.problem.Chromosome;
import model.problem.IProblem;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AlgorithmTest {
    Algorithm algorithm;
    IStopStrategy stopStrategy = new GenerationsCountStopStrategy();
    IProblem problem;

    @Before
    public void init() {
        problem = new IProblem() {
            public void setChromosomes(List<Chromosome> chromosomes) {

            }

            public List<Chromosome> getChromosomes() {
                return null;
            }
        };

        algorithm = new Algorithm.AlgorithmBuilder(stopStrategy, problem)
                .initStrategy(new FloatInitStrategy())
                .crossStrategy(new FloatCrossStrategy())
                .mutateStrategy(new FloatMutateStrategy())
                .name("Int").build();

    }

    @Test
    public void setProblemChromosomes() {
    }

    @Test
    public void getName() {
        assertEquals(algorithm.getName(), "Int");
    }

    @Test
    public void getStopStrategy() {
    }

    @Test
    public void getProblem() {
    }

    @Test
    public void getCrossStrategy() {
        assertNotNull(algorithm.getCrossStrategy());
    }

    @Test
    public void getInitStrategy() {
        assertNotNull(algorithm.getInitStrategy());
    }

    @Test
    public void getMutateStrategy() {
        assertNotNull(algorithm.getMutateStrategy());
    }

    @Test
    public void getEvalStrategy() {
    }

    @Test
    public void getSelectStrategy() {
    }
}