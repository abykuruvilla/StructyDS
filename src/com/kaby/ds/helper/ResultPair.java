package com.kaby.ds.helper;

import java.util.Objects;

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
        System.out.println("{\n RESULT: " +
                description + " - " +
                "\n Expected = " + expectedVal +
                ",\n Actual   = " + actualVal +
                "\n}");
        System.out.println(" ============================== \n");
    }

    public void assertMatch() {
        if (!Objects.equals(expectedVal, actualVal)) {
            throw new AssertionError(
                    "Assertion failed for " + description +
                            ": Expected = " + expectedVal +
                            ", but Actual = " + actualVal
            );
        }
        System.out.println("Assertion passed for " + description);
    }
}
