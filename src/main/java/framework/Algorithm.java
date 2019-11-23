package framework;

import model.problem.IProblem;

public class Algorithm {
    IStopStrategy stopStrategy;
    IProblem problem;
    String name;

    private Algorithm(AlgorithmBuilder algorithmBuilder) {
        this.stopStrategy = algorithmBuilder.stopStrategy;
        this.problem = algorithmBuilder.problem;
        this.name = algorithmBuilder.name;
    }

    public static class AlgorithmBuilder{
        IStopStrategy stopStrategy;
        IProblem problem;
        String name;

        public AlgorithmBuilder(IStopStrategy stopStrategy, IProblem problem) {
            this.stopStrategy = stopStrategy;
            this.problem = problem;
        }

        public AlgorithmBuilder name(String name){
            this.name = name;
            return this;
        }

        public Algorithm build(){
            return new Algorithm(this);
        }
    }

}
