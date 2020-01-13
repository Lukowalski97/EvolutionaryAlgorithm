package framework;

import framework.stopstrategy.GenerationsCountStopStrategy;
import framework.stopstrategy.IStopStrategy;
import model.IOperationStrategy;
import model.crossbreeder.AntCrossStrategy;
import model.crossbreeder.FloatCrossStrategy;
import model.crossbreeder.ICrossStrategy;
import model.crossbreeder.TspCrossStrategy;
import model.evaluator.AntEvalStrategy;
import model.evaluator.IEvalStrategy;
import model.AntLogic.AntBoard;
import model.evaluator.PolynomialEvalStrategy;
import model.evaluator.TspEvalStrategy;
import model.initializer.AntInitStrategy;
import model.initializer.IInitStrategy;
import model.initializer.TspInitStrategy;
import model.mutator.AntMutateStrategy;
import model.mutator.IMutateStrategy;
import model.mutator.TspMutateStrategy;
import model.problem.*;
import model.selector.ISelectStrategy;
import model.selector.SelectTopNStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        final boolean AREWETESTINGTSP = true;
        if(AREWETESTINGTSP){
            ArrayList<City> destinationCities = new ArrayList<>();

            for (int i = 0; i < 20; i++) destinationCities.add(new City());
            System.out.println(destinationCities);
            IStopStrategy stopStrategy = new GenerationsCountStopStrategy(1000);


            TspProblem problem = new TspProblem(destinationCities);
            IInitStrategy<City> initStrategy = new TspInitStrategy(problem);
            IEvalStrategy<City> evalStrategy = new TspEvalStrategy();
            ICrossStrategy<City> crossStrategy = new TspCrossStrategy();
            IMutateStrategy<City> mutateStrategy = new TspMutateStrategy(0.015f);

            List<IOperationStrategy<City>> operationsList = new ArrayList<>();
            operationsList.add(evalStrategy);
            operationsList.add(crossStrategy);
            operationsList.add(mutateStrategy);


            Algorithm<City>  algorithm = new Algorithm.AlgorithmBuilder<City>(stopStrategy,problem).
                    initStrategy(initStrategy)
                    .operationsList(operationsList)
                    .selectStrategy(new SelectTopNStrategy(10))
                    .name("Polynomial").build();


            algorithm.run();

            Chromosome<City> best = Collections.min(algorithm.getProblemChromosomes());
            System.out.println(best.getChromosomeFitnessValue());
            System.out.println(best);
        }else{
            AntBoard board = new AntBoard(10, 10);
            System.out.println(board.toString());

            IStopStrategy stopStrategy = new GenerationsCountStopStrategy(2000);
            IInitStrategy<AntGene> initStrategy = new AntInitStrategy(board);
            AntProblem problem = new AntProblem();
            IEvalStrategy<AntGene> evalStrategy = new AntEvalStrategy(problem);
            ICrossStrategy<AntGene> crossStrategy = new AntCrossStrategy(board);
            IMutateStrategy<AntGene> mutateStrategy = new AntMutateStrategy(board);

            List<IOperationStrategy<AntGene>> operationsList = new ArrayList<>();
            operationsList.add(evalStrategy);
            operationsList.add(crossStrategy);
            operationsList.add(mutateStrategy);

            Algorithm algorithm = new Algorithm.AlgorithmBuilder<AntGene>(stopStrategy, problem).
                    initStrategy(initStrategy)
                    .operationsList(operationsList)
                    .selectStrategy(new SelectTopNStrategy(10))
                    .name("Ant Helper").build();
            algorithm.run();


            List<Chromosome<AntGene>> chrom = problem.getChromosomes();
            Collections.sort(chrom);
            Collections.reverse(chrom);
            System.out.println(board.ChromosomePathAndResultToString(chrom.get(0)));


        }





    }
}
