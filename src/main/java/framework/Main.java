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
        /*
        City city = new City(60, 200);
        destinationCities.add(city);
        City city2 = new City(180, 200);
        destinationCities.add(city2);
        City city3 = new City(80, 180);
        destinationCities.add(city3);
        City city4 = new City(140, 180);
        destinationCities.add(city4);
        City city5 = new City(20, 160);
        destinationCities.add(city5);
        City city6 = new City(100, 160);
        destinationCities.add(city6);
        City city7 = new City(200, 160);
        destinationCities.add(city7);
        City city8 = new City(140, 140);
        destinationCities.add(city8);
        City city9 = new City(40, 120);
        destinationCities.add(city9);
        City city10 = new City(100, 120);
        destinationCities.add(city10);
        City city11 = new City(180, 100);
        destinationCities.add(city11);
        City city12 = new City(60, 80);
        destinationCities.add(city12);
        City city13 = new City(120, 80);
        destinationCities.add(city13);
        City city14 = new City(180, 60);
        destinationCities.add(city14);
        City city15 = new City(20, 40);
        destinationCities.add(city15);
        City city16 = new City(100, 40);
        destinationCities.add(city16);
        City city17 = new City(200, 40);
        destinationCities.add(city17);
        City city18 = new City(20, 20);
        destinationCities.add(city18);
        City city19 = new City(60, 20);
        destinationCities.add(city19);
        City city20 = new City(160, 20);
        destinationCities.add(city20);
         */
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
