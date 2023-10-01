package com.kaby.ds.helper;

import java.util.Objects;

public class Triplet<U, V, T> {

    public final U first;       // the first field of a triplet
    public final V second;      // the second field of a triplet
    public final T third;       // the third field of a triplet

    // Constructs a new triplet with the given values
    private Triplet(U first, V second, T third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triplet<?, ?, ?> triplet = (Triplet<?, ?, ?>) o;
        return Objects.equals(first, triplet.first) && Objects.equals(second, triplet.second) && Objects.equals(third, triplet.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public String toString() {
        return "Triplet{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }

    // Factory method for creating a typed immutable instance of triplet
    public static <U, V, T> Triplet <U, V, T> of(U a, V b, T c) {
        return new Triplet <>(a, b, c);
    }
}
