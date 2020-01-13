package framework;

import framework.stopstrategy.GenerationsCountStopStrategy;
import framework.stopstrategy.IStopStrategy;
import model.crossbreeder.AntCrossStrategy;
import model.crossbreeder.ICrossStrategy;
<<<<<<< HEAD
import model.evaluator.AntEvalStrategy;
import model.evaluator.IEvalStrategy;
import model.AntLogic.AntBoard;
import model.initializer.AntInitStrategy;
import model.initializer.IInitStrategy;
import model.mutator.AntMutateStrategy;
import model.mutator.IMutateStrategy;
import model.problem.AntGene;
import model.problem.AntProblem;
import model.problem.Chromosome;
import model.selector.SelectTopNStrategy;

import java.util.Collections;
import java.util.List;
=======
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
>>>>>>> 72bb8200065d60553dc0443894004404ecc4af6d

public class Main {
    public static void main(String[] args) {
        ArrayList<City> destinationCities = new ArrayList<>();

<<<<<<< HEAD
/*      float[] polynomial = new float[]{1,2,3};
=======
        for (int i = 0; i < 20; i++) destinationCities.add(new City());
        System.out.println(destinationCities);
        IStopStrategy stopStrategy = new GenerationsCountStopStrategy(1000);
>>>>>>> 72bb8200065d60553dc0443894004404ecc4af6d


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

<<<<<<< HEAD
        System.out.println(algorithm.getProblemChromosomes());*/

        AntBoard board = new AntBoard(10, 10);
        System.out.println(board.toString());

        IStopStrategy stopStrategy = new GenerationsCountStopStrategy(2000);
        IInitStrategy<AntGene> initStrategy = new AntInitStrategy(board);
        AntProblem problem = new AntProblem();
        IEvalStrategy<AntGene> evalStrategy = new AntEvalStrategy(problem);
        ICrossStrategy<AntGene> crossStrategy = new AntCrossStrategy(board);
        IMutateStrategy<AntGene> mutateStrategy = new AntMutateStrategy(board);

        Algorithm algorithm = new Algorithm.AlgorithmBuilder<AntGene>(stopStrategy, problem).
                initStrategy(initStrategy)
                .crossStrategy(crossStrategy)
                .mutateStrategy(mutateStrategy)
                .evalStrategy(evalStrategy)
                .selectStrategy(new SelectTopNStrategy(10))
                .name("Ant Helper").build();
        algorithm.run();


        List<Chromosome<AntGene>> chrom = problem.getChromosomes();
        Collections.sort(chrom);
        Collections.reverse(chrom);
        System.out.println(board.ChromosomePathAndResultToString(chrom.get(0)));







/*        problem.setChromosomes(initStrategy.initChromosomes(10, 1));
        List<Chromosome<AntGene>> chromosomeList = problem.getChromosomes();
        for(int i = 0; i<chromosomeList.size(); i++){
            Chromosome<AntGene> antChromosome = chromosomeList.get(i);
            for(int j = 0; j < antChromosome.getGenes().size(); j++)
                System.out.println(antChromosome.getGenes().get(j).getAntMove());

        }*/


=======
        Chromosome<City> best = Collections.min(algorithm.getProblemChromosomes());
        System.out.println(best.getChromosomeFitnessValue());
        System.out.println(best);
>>>>>>> 72bb8200065d60553dc0443894004404ecc4af6d
    }
}
