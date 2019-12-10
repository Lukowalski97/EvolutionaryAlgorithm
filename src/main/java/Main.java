import framework.Algorithm;
import framework.GenerationsCountStopStrategy;
import framework.IStopStrategy;
import model.crossbreeder.FloatCrossStrategy;
import model.evaluator.PolynomialEvalStrategy;
import model.initializer.FloatInitStrategy;
import model.mutator.FloatMutateStrategy;
import model.problem.Chromosome;
import model.problem.IProblem;
import model.problem.PolynomialProblem;
import model.selector.SelectTopNStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IStopStrategy stopStrategy = new GenerationsCountStopStrategy(1000000);

        float[] polynomial = new float[]{1,2,3};
        PolynomialProblem problem = new PolynomialProblem(polynomial);

       Algorithm algorithm = new Algorithm.AlgorithmBuilder(stopStrategy,problem).
                initStrategy(new FloatInitStrategy())
                .crossStrategy(new FloatCrossStrategy(2))
                .mutateStrategy(new FloatMutateStrategy(1, 1))
                .evalStrategy(new PolynomialEvalStrategy(problem))
                .selectStrategy(new SelectTopNStrategy(10))
                .name("Polynomial").build();

        algorithm.run();

        System.out.println(algorithm.getProblemChromosomes());
    }
}
