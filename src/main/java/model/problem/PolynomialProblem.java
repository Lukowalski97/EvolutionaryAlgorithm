package model.problem;

import java.util.List;

public class PolynomialProblem implements IProblem {

    int[] polynomial;

    public PolynomialProblem(int[] polynomial){
        this.polynomial=polynomial;
    }

    public void setChromosomes() {

    }

    public List<Chromosome> getChromosomes() {
        return null;
    }

    public void setPolynomial(int[] polynomial) {
        this.polynomial = polynomial;
    }

    public int[]  getPolynomial(){
        return this.polynomial;
    }
}
