package com.java.Collections.Builder;

public class House {
    private String foundation;
    private String structure;
    private String roof;
    private String interior;

    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.roof = builder.roof;
        this.interior = builder.interior;
    }

    @Override
    public String toString() {
        return "House [foundation=" + foundation + ", structure=" + structure +
                ", roof=" + roof + ", interior=" + interior + "]";
    }

    // Builder Class
    public static class HouseBuilder {
        private String foundation;
        private String structure;
        private String roof;
        private String interior;

        public HouseBuilder buildFoundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public HouseBuilder buildStructure(String structure) {
            this.structure = structure;
            return this;
        }

        public HouseBuilder buildRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public HouseBuilder buildInterior(String interior) {
            this.interior = interior;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}

