package com.kaby.ds.helper;

public class ResultPair<E, A> {

    String description;
    E expectedVal;
    A actualVal;

    public ResultPair(String description, E expected, A actual) {
        this.description = description;
        this.expectedVal = expected;
        this.actualVal = actual;
    }

    public ResultPair(E expected, A actual) {
        this.description = "RESULT";
        this.expectedVal = expected;
        this.actualVal = actual;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public E getExpectedVal() {
        return expectedVal;
    }

    public void setExpectedVal(E expectedVal) {
        this.expectedVal = expectedVal;
    }

    public A getActualVal() {
        return actualVal;
    }

    public void setActualVal(A actualVal) {
        this.actualVal = actualVal;
    }

    @Override
    public String toString() {
        return "{" +
                description + " : " +
                " Expected = " + expectedVal +
                ", Actual = " + actualVal +
                "}";
    }

    public void printResultPair() {
        System.out.println("{ RESULT: " +
                description + " - " +
                "Expected = " + expectedVal +
                ", Actual = " + actualVal +
                "}");
        System.out.println(" ============================== \n");
    }
}
