package com.kaby.ds.helper;

public class Pair<A, B> {
    A valA;
    B valB;

    public Pair(A valA, B valB) {
        this.valA = valA;
        this.valB = valB;
    }

    public A getValA() {
        return valA;
    }

    public void setValA(A valA) {
        this.valA = valA;
    }

    public B getValB() {
        return valB;
    }

    public void setValB(B valB) {
        this.valB = valB;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "valA=" + valA +
                ", valB=" + valB +
                '}';
    }
}
