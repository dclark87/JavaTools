package io.github.dclark87.javatools.builders;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test case for the Guitar class
 */
public class GuitarTest {

    // Taylor
    private static final Guitar.Color taylorColor = Guitar.Color.LIGHT_WOOD;
    private static final Guitar.Make taylorMake = Guitar.Make.TAYLOR;
    private static final Guitar.Strings taylorStrings = Guitar.Strings.ELIXIR;

    // Gibson
    private static final Guitar.Color gibsonColor = Guitar.Color.ICED_TEA;
    private static final Guitar.Make gibsonMake = Guitar.Make.GIBSON;
    private static final Guitar.Strings gibsonStrings = Guitar.Strings.ERNIE_BALL;

    // Fender
    private static final Guitar.Color fenderColor = Guitar.Color.BLONDE;
    private static final Guitar.Make fenderMake = Guitar.Make.FENDER;
    private static final Guitar.Strings fenderStrings = Guitar.Strings.D_ADDARIO;

    /**
     * Test we can build my Taylor acoustic
     */
    @Test
    public void testGuitarBuilderMyTaylor() {
        Guitar.Builder guitarBuilder = new Guitar.Builder();
        guitarBuilder.setColor(taylorColor);
        guitarBuilder.setMake(taylorMake);
        guitarBuilder.setStrings(taylorStrings);

        // Create my taylor acoustic!
        Guitar myTaylor = guitarBuilder.build();
        Assert.assertEquals(myTaylor.getColor(), taylorColor);
        Assert.assertEquals(myTaylor.getMake(), taylorMake);
        Assert.assertEquals(myTaylor.getStrings(), taylorStrings);
    }

    /**
     * Test we can build my Les Paul
     */
    @Test
    public void testGuitarBuilderMyGibson() {
        Guitar.Builder guitarBuilder = new Guitar.Builder();
        guitarBuilder.setColor(gibsonColor);
        guitarBuilder.setMake(gibsonMake);
        guitarBuilder.setStrings(gibsonStrings);

        // Create my taylor acoustic!
        Guitar myGibson = guitarBuilder.build();
        Assert.assertEquals(myGibson.getColor(), gibsonColor);
        Assert.assertEquals(myGibson.getMake(), gibsonMake);
        Assert.assertEquals(myGibson.getStrings(), gibsonStrings);
    }

    /**
     * Test we can build my Stratocaster
     */
    @Test
    public void testGuitarBuilderMyFender() {
        Guitar.Builder guitarBuilder = new Guitar.Builder();
        guitarBuilder.setColor(fenderColor);
        guitarBuilder.setMake(fenderMake);
        guitarBuilder.setStrings(fenderStrings);

        // Create my taylor acoustic!
        Guitar myFender = guitarBuilder.build();
        Assert.assertEquals(myFender.getColor(), fenderColor);
        Assert.assertEquals(myFender.getMake(), fenderMake);
        Assert.assertEquals(myFender.getStrings(), fenderStrings);
    }
}
