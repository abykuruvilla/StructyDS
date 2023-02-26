package com.kaby.ds.graph.models;

import java.util.Objects;

public class GridPosition {
    private int rowId;
    private int colId;

    public GridPosition(int rowId, int colId) {
        this.rowId = rowId;
        this.colId = colId;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public int getColId() {
        return colId;
    }

    public void setColId(int colId) {
        this.colId = colId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridPosition that = (GridPosition) o;
        return rowId == that.rowId && colId == that.colId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowId, colId);
    }

    @Override
    public String toString() {
        return "GridPosition{" +
                "rowId=" + rowId +
                ", colId=" + colId +
                '}';
    }
}
