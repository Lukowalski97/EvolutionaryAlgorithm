package model.initializer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntInitStrategyTest {
    IInitStrategy init;

    @Before
    public void init() {
        init = new IntInitStrategy();
    }


    @Test
    public void initChromosomes() {
        assertEquals(init.initChromosomes(10,1).size(), 10);
    }

    @Test
    public void initGenes() {
        assertEquals(init.initGenes(1).size(), 1);
    }
}