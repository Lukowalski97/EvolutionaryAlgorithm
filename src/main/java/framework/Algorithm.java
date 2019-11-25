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

        public AlgorithmBuilder(ICrossStrategy crossStrategy){
            this.crossStrategy=crossStrategy;
        }

        public AlgorithmBuilder(IInitStrategy initStrategy){
            this.initStrategy=initStrategy;
        }

        public AlgorithmBuilder(IMutateStrategy mutateStrategy){
            this.mutateStrategy=mutateStrategy;
        }

        public AlgorithmBuilder(IEvalStrategy evalStrategy){
            this.evalStrategy=evalStrategy;
        }

        public AlgorithmBuilder(ISelectStrategy selectStrategy){
            this.selectStrategy=selectStrategy;
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
