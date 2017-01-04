package io.github.dclark87.javatools.builders;

/**
 * Guitar factory class to build guitars
 */
public class GuitarFactory {

    // Cordoba
    private static final Guitar.Color cordobaColor = Guitar.Color.DARK_WOOD;
    private static final Guitar.Make cordobaMake = Guitar.Make.CORDOBA;
    private static final Guitar.Strings cordobaStrings = Guitar.Strings.NYLON;
    private static Guitar.Builder guitarBuilder = new Guitar.Builder();

    /**
     * Build Cordoba guitar via a factory method
     *
     * @return the cordoba guitar object
     */
    public static Guitar buildMyCordoba() {
        guitarBuilder.setColor(cordobaColor);
        guitarBuilder.setMake(cordobaMake);
        guitarBuilder.setStrings(cordobaStrings);

        return guitarBuilder.build();
    }
}
