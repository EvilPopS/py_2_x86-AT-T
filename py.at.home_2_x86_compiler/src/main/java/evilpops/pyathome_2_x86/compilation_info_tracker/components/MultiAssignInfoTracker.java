package main.java.evilpops.pyathome_2_x86.compilation_info_tracker.components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import main.java.evilpops.pyathome_2_x86.exceptions.other.BadImplementationException;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

import java.util.ArrayDeque;
import java.util.Deque;

public class MultiAssignInfoTracker {
    @Getter
    @AllArgsConstructor
    protected static class VarInfo {
        protected int numExpOrdinality;
        protected DataType numExpDataType;
    }

    protected Deque<VarInfo> varInfos;
    protected Deque<Integer> memOrdinalities;

    public void onMultiAssignStatementStart() {
        this.varInfos = new ArrayDeque<>();
        this.memOrdinalities = new ArrayDeque<>();
    }

    public void onMultiAssignNumExpEnd(int ordinality, DataType dataType) {
        this.varInfos.addLast(new VarInfo(ordinality, dataType));
        this.memOrdinalities.addLast(ordinality);
    }

    public int getNextFreeMemOrdinality() {
        Integer ordinality = this.memOrdinalities.pollFirst();
        if (ordinality == null)
            throw new BadImplementationException();
        return ordinality;
    }

    public int getNumOfMemOrdinalitiesLeft() {
        return this.memOrdinalities.size();
    }

    public void popNextVarInfoFromHead() {
        this.varInfos.pollFirst();
    }

    public int getNextNumExpOrdinality() {
        return this.getFirstVarInfoFromDeque().getNumExpOrdinality();
    }

    public DataType getNextNumExpDataType() {
        return this.getFirstVarInfoFromDeque().getNumExpDataType();
    }

    private VarInfo getFirstVarInfoFromDeque() {
        VarInfo info = this.varInfos.peekFirst();
        if (info == null)
            throw new BadImplementationException();
        return info;
    }
}
