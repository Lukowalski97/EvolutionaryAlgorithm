import framework.Algorithm;
import framework.GenerationsCountStopStrategy;
import framework.IStopStrategy;
import model.problem.Chromosome;
import model.problem.IProblem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IStopStrategy stopStrategy = new GenerationsCountStopStrategy(100);

        IProblem problem = new IProblem() {
            public void setChromosomes(List<Chromosome> chromosomes) {

            }

            public List<Chromosome> getChromosomes() {
                return null;
            }
        };

       Algorithm algorithm = new Algorithm.AlgorithmBuilder(stopStrategy,problem).name("Test").build();




    }
}
