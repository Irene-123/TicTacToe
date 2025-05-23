package model;

public enum Symbol {
    START("*"),
    ZERO("0"),
    CROSS("X");

    private String symbol;
    Symbol(String symbol) {
        this.symbol = symbol;
    }
    public String getSymbol() {
        return symbol;
    }
}
