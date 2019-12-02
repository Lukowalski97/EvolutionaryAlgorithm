package model.problem;

import java.util.List;

public class PolynomialProblem implements IProblem {

    int[] polynomial;
    List<Chromosome> chromosomes;

    public PolynomialProblem(int[] polynomial){
        this.polynomial=polynomial;
    }

    public List<Chromosome> getChromosomes() {
        return chromosomes;
    }

    public void setChromosomes(List<Chromosome> chromosomes) {
        this.chromosomes = chromosomes;
    }

    public void setPolynomial(int[] polynomial) {
        this.polynomial = polynomial;
    }

    public int[]  getPolynomial(){
        return this.polynomial;
    }
}
