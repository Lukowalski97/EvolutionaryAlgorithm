package framework;

import framework.stopstrategy.IStopStrategy;
import model.IOperationStrategy;
import model.crossbreeder.ICrossStrategy;
import model.evaluator.IEvalStrategy;
import model.initializer.IInitStrategy;
import model.mutator.IMutateStrategy;
import model.problem.Chromosome;
import model.problem.Gene;
import model.problem.IProblem;
import model.selector.ISelectStrategy;

import java.util.ArrayList;
import java.util.List;

public class Algorithm<T extends Gene> {
    private IStopStrategy stopStrategy;
    private IProblem<T> problem;
    private String name;
    private IInitStrategy<T> initStrategy;
    private ISelectStrategy selectStrategy;
    private List<IOperationStrategy<T>> operationsList;

    private Algorithm(AlgorithmBuilder<T> algorithmBuilder) {
        this.stopStrategy = algorithmBuilder.stopStrategy;
        this.problem = algorithmBuilder.problem;
        this.name = algorithmBuilder.name;
        this.initStrategy = algorithmBuilder.initStrategy;
        this.selectStrategy = algorithmBuilder.selectStrategy;
        if(algorithmBuilder.operationsList != null){
            this.operationsList = algorithmBuilder.operationsList;
        }else{
            this.operationsList = new ArrayList<>();
        }

    }

    public static class AlgorithmBuilder<T extends Gene> {
        IStopStrategy stopStrategy;
        IProblem<T> problem;
        String name;
        IInitStrategy<T> initStrategy;
        ISelectStrategy selectStrategy;
        private List<IOperationStrategy<T>> operationsList;


        public AlgorithmBuilder(IStopStrategy stopStrategy, IProblem<T> problem) {
            this.stopStrategy = stopStrategy;
            this.problem = problem;
        }

        public AlgorithmBuilder<T> name(String name) {
            this.name = name;
            return this;
        }


        public AlgorithmBuilder<T> initStrategy(IInitStrategy<T> initStrategy) {
            this.initStrategy = initStrategy;
            return this;
        }


        public AlgorithmBuilder<T> selectStrategy(ISelectStrategy selectStrategy) {
            this.selectStrategy = selectStrategy;
            return this;
        }

        public AlgorithmBuilder<T> operationsList(List<IOperationStrategy<T>> operationsList) {
            this.operationsList = operationsList;
            return this;
        }

        public Algorithm<T> build() {
            return new Algorithm<>(this);
        }
    }

    public List<Chromosome<T>> getProblemChromosomes() {
        return this.problem.getChromosomes();
    }

    public void setProblemChromosomes(List<Chromosome<T>> chromosomes) {
        this.problem.setChromosomes(chromosomes);
    }

    public String getName() {
        return name;
    }

    public IStopStrategy getStopStrategy() {
        return stopStrategy;
    }

    public IProblem getProblem() {
        return problem;
    }


    public IInitStrategy<T> getInitStrategy() {
        return initStrategy;
    }


    public ISelectStrategy getSelectStrategy() {
        return selectStrategy;
    }


    public void run() {
        //initialize
        setProblemChromosomes(this.initStrategy.initChromosomes(100, 1));


        while (this.stopStrategy.isAlgorithmWorking()) {

            for (IOperationStrategy<T> operation : operationsList) {
                setProblemChromosomes(operation.executeOperation(getProblemChromosomes()));
                if (operation instanceof IEvalStrategy) {
                    setProblemChromosomes(selectStrategy.selectChromosomesWithBiggestFitness(getProblemChromosomes()));
                }
            }
        }
    }

}
