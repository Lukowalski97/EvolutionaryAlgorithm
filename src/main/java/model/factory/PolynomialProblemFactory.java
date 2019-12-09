package model.factory;

import model.crossbreeder.ICrossStrategy;
import model.evaluator.IEvalStrategy;
import model.initializer.IInitStrategy;
import model.mutator.IMutateStrategy;
import model.problem.IProblem;
import model.problem.PolynomialProblem;

public class PolynomialProblemFactory implements IProblemFactory {


    public IProblem createProblem() {
        return new PolynomialProblem(new float[]{1,2,3});
    }
}
