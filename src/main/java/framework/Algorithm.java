package framework;

import model.crossbreeder.ICrossStrategy;
import model.evaluator.IEvalStrategy;
import model.initializer.IInitStrategy;
import model.mutator.IMutateStrategy;
import model.problem.Chromosome;
import model.problem.IProblem;
import model.selector.ISelectStrategy;

import java.util.List;

public class Algorithm {
    IStopStrategy stopStrategy;
    IProblem problem;
    String name;
    ICrossStrategy crossStrategy;
    IInitStrategy initStrategy;
    IMutateStrategy mutateStrategy;
    IEvalStrategy evalStrategy;
    ISelectStrategy selectStrategy;



    private Algorithm(AlgorithmBuilder algorithmBuilder) {
        this.stopStrategy = algorithmBuilder.stopStrategy;
        this.problem = algorithmBuilder.problem;
        this.name = algorithmBuilder.name;
        this.crossStrategy= algorithmBuilder.crossStrategy;
        this.initStrategy= algorithmBuilder.initStrategy;
        this.mutateStrategy=algorithmBuilder.mutateStrategy;
        this.evalStrategy=algorithmBuilder.evalStrategy;
        this.selectStrategy =algorithmBuilder.selectStrategy;

    }

    public static class AlgorithmBuilder{
        IStopStrategy stopStrategy;
        IProblem problem;
        String name;
        ICrossStrategy crossStrategy;
        IInitStrategy initStrategy;
        IMutateStrategy mutateStrategy;
        IEvalStrategy evalStrategy;
        ISelectStrategy selectStrategy;

        public AlgorithmBuilder(IStopStrategy stopStrategy, IProblem problem) {
            this.stopStrategy = stopStrategy;
            this.problem = problem;
        }

        public AlgorithmBuilder name(String name){
            this.name = name;
            return this;
        }

        public AlgorithmBuilder crossStrategy(ICrossStrategy crossStrategy){
            this.crossStrategy=crossStrategy;
            return this;
        }

        public AlgorithmBuilder initStrategy(IInitStrategy initStrategy){
            this.initStrategy=initStrategy;
            return this;
        }

        public AlgorithmBuilder mutateStrategy(IMutateStrategy mutateStrategy){
            this.mutateStrategy=mutateStrategy;
            return this;
        }

        public AlgorithmBuilder evalStrategy(IEvalStrategy evalStrategy){
            this.evalStrategy=evalStrategy;
            return this;
        }

        public AlgorithmBuilder selectStrategy(ISelectStrategy selectStrategy){
            this.selectStrategy=selectStrategy;
            return this;
        }

        public Algorithm build(){
            return new Algorithm(this);
        }
    }

    public List<Chromosome> getProblemChromosomes(){
        return this.problem.getChromosomes();
    }

    public void setProblemChromosomes(List<Chromosome> chromosomes){
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

    public ICrossStrategy getCrossStrategy() {
        return crossStrategy;
    }

    public IInitStrategy getInitStrategy() {
        return initStrategy;
    }

    public IMutateStrategy getMutateStrategy() {
        return mutateStrategy;
    }

    public IEvalStrategy getEvalStrategy() {
        return evalStrategy;
    }

    public ISelectStrategy getSelectStrategy() {
        return selectStrategy;
    }

    public void run(){
        //initialize
        setProblemChromosomes(this.initStrategy.initChromosomes(10,10));

        while(true){
            //posortuj wg
            //this.problem.getChromosomes().sort();

            //ewaluacja
            setProblemChromosomes(this.evalStrategy.evaluateChromosomes(getProblemChromosomes()));

            if(!this.stopStrategy.isAlgorithmWorking()){
                break;
            }

            //selekcja
            setProblemChromosomes(selectStrategy.selectPersistentChromosomes(getProblemChromosomes()));

            //krzyzowanie
            setProblemChromosomes(crossStrategy.crossChromosomes(getProblemChromosomes()));

            //mutacja

            setProblemChromosomes(mutateStrategy.mutateChromosomes(getProblemChromosomes()));
        }
    }
}
