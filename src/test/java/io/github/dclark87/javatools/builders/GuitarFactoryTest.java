package io.github.dclark87.javatools.builders;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Danny on 9/26/16.
 */
public class GuitarFactoryTest {

    // Cordoba
    private static final Guitar.Color cordobaColor = Guitar.Color.DARK_WOOD;
    private static final Guitar.Make cordobaMake = Guitar.Make.CORDOBA;
    private static final Guitar.Strings cordobaStrings = Guitar.Strings.NYLON;

    /**
     * Test the factory can make a Cordoba guitar
     */
    @Test
    public void testBuildMyCordoba() {
        // Create my Cordoba!
        Guitar myCordoba = GuitarFactory.buildMyCordoba();
        Assert.assertEquals(myCordoba.getColor(), cordobaColor);
        Assert.assertEquals(myCordoba.getMake(), cordobaMake);
        Assert.assertEquals(myCordoba.getStrings(), cordobaStrings);
    }
}
