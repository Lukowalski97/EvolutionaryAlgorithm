package model.initializer;

import model.problem.Chromosome;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;

public class FloatInitTest {

    @Test
    public void initChromosomes() {
        FloatInit floatInit = new FloatInit();
        assertThat(floatInit.initChromosomes(), instanceOf(List.class));
    }

    @Test
    public void initGenes() {
        FloatInit floatInit = new FloatInit();
        assertThat(floatInit.initChromosomes(), instanceOf(Collection.class));
    }
}