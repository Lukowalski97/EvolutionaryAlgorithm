package framework;

import framework.stopstrategy.GenerationsCountStopStrategy;
import framework.stopstrategy.IStopStrategy;
import model.crossbreeder.AntCrossStrategy;
import model.crossbreeder.ICrossStrategy;
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

public class Main {
    public static void main(String[] args) {

/*      float[] polynomial = new float[]{1,2,3};

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


    }
}
