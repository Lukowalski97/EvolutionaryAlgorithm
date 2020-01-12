package framework;

import framework.stopstrategy.GenerationsCountStopStrategy;
import framework.stopstrategy.IStopStrategy;
import model.crossbreeder.FloatCrossStrategy;
import model.crossbreeder.ICrossStrategy;
import model.crossbreeder.TspCrossStrategy;
import model.evaluator.IEvalStrategy;
import model.evaluator.PolynomialEvalStrategy;
import model.evaluator.TspEvalStrategy;
import model.initializer.FloatInitStrategy;
import model.initializer.IInitStrategy;
import model.initializer.TspInitStrategy;
import model.mutator.FloatMutateStrategy;
import model.mutator.IMutateStrategy;
import model.mutator.TspMutateStrategy;
import model.problem.*;
import model.selector.SelectTopNStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<City> destinationCities = new ArrayList<>();

        for (int i = 0; i < 20; i++) destinationCities.add(new City());
        System.out.println(destinationCities);
        IStopStrategy stopStrategy = new GenerationsCountStopStrategy(1000);


        TspProblem problem = new TspProblem(destinationCities);
        IInitStrategy<City> initStrategy = new TspInitStrategy(problem);
        IEvalStrategy<City> evalStrategy = new TspEvalStrategy();
        ICrossStrategy<City> crossStrategy = new TspCrossStrategy();
        IMutateStrategy<City> mutateStrategy = new TspMutateStrategy(0.015f);


       Algorithm  algorithm = new Algorithm.AlgorithmBuilder<City>(stopStrategy,problem).
                initStrategy(initStrategy)
                .crossStrategy(crossStrategy)
                .mutateStrategy(mutateStrategy)
                .evalStrategy(evalStrategy)
                .selectStrategy(new SelectTopNStrategy(10))
                .name("TSP").build();

        algorithm.run();

        Chromosome<City> best = Collections.min(algorithm.getProblemChromosomes());
        System.out.println(best.getChromosomeFitnessValue());
        System.out.println(best);
    }
}
