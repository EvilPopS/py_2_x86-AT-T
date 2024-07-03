package main.java.evilpops.pyathome_2_x86.compilation_info_tracker.components;

import lombok.Getter;

@Getter
public class FunctionScopeTracker {
    protected int scope;

    public FunctionScopeTracker() {
        this.scope = 0;
    }

    public void incScope() {
        this.scope++;
    }

    public void decScope() {
        this.scope--;
    }
}
