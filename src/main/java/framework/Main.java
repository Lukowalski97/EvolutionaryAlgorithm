package framework;

import framework.stopstrategy.GenerationsCountStopStrategy;
import framework.stopstrategy.IStopStrategy;
import model.crossbreeder.FloatCrossStrategy;
import model.crossbreeder.ICrossStrategy;
import model.evaluator.IEvalStrategy;
import model.evaluator.PolynomialEvalStrategy;
import model.initializer.FloatInitStrategy;
import model.initializer.IInitStrategy;
import model.mutator.FloatMutateStrategy;
import model.mutator.IMutateStrategy;
import model.problem.FloatGene;
import model.problem.PolynomialProblem;
import model.selector.SelectTopNStrategy;

public class Main {
    public static void main(String[] args) {

        float[] polynomial = new float[]{1,2,3};

        IStopStrategy stopStrategy = new GenerationsCountStopStrategy(50);

        IInitStrategy<FloatGene> initStrategy = new FloatInitStrategy();
        PolynomialProblem problem = new PolynomialProblem(polynomial,-5,5,false);
        IEvalStrategy<FloatGene> evalStrategy = new PolynomialEvalStrategy(problem);
        ICrossStrategy<FloatGene> crossStrategy = new FloatCrossStrategy(5);
        IMutateStrategy<FloatGene> mutateStrategy = new FloatMutateStrategy(0.5f,0.1f);


       Algorithm  algorithm = new Algorithm.AlgorithmBuilder<FloatGene>(stopStrategy,problem).
                initStrategy(initStrategy)
                .crossStrategy(crossStrategy)
                .mutateStrategy(mutateStrategy)
                .evalStrategy(evalStrategy)
                .selectStrategy(new SelectTopNStrategy(10))
                .name("Polynomial").build();

        algorithm.run();

        System.out.println(algorithm.getProblemChromosomes());
    }
}
