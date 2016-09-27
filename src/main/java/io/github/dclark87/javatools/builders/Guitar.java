package io.github.dclark87.javatools.builders;

import lombok.Getter;

/**
 * Guitar class with builder - because guitars are cool!
 */
public class Guitar {

    // Instance variables
    @Getter private Strings strings;
    @Getter private Make make;
    @Getter private Color color;

    private Guitar(Builder builder) {
        this.strings = builder.strings;
        this.make = builder.make;
        this.color = builder.color;
    }

    /**
     * Guitar strings enum
     */
    enum Strings {
        D_ADDARIO, ELIXIR, ERNIE_BALL, NYLON;
    }

    /**
     * Guitar make enum
     */
    enum Make {
        FENDER, GIBSON, TAYLOR, CORDOBA;
    }

    /**
     * Guitar color enum
     */
    enum Color {
        BLONDE, ICED_TEA, LIGHT_WOOD, DARK_WOOD;
    }

    /**
     * Guitar builder nested class
     */
    public static class Builder {

        // Instance variables
        private Strings strings;
        private Make make;
        private Color color;

        /**
         * Guitar builder constructor
         */
        public Builder() {}

        /**
         * Set the guitar strings
         * @param strings strings enum for the guitar
         */
        public void setStrings(Strings strings) {
            this.strings = strings;
        }

        /**
         * Set the make of the guitar
         * @param make the make enum for the guitar
         */
        public void setMake(Make make) {
            this.make = make;
        }

        /**
         * Set the color of the guitar
         * @param color the color string
         */
        public void setColor(Color color) {
            this.color = color;
        }

        /**
         * Build method to return the completed Guitar object
         * @return the full built guitar
         */
        public Guitar build() {
            return new Guitar(this);
        }
    }
}
