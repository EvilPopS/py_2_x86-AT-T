package main.java.evilpops.pyathome_2_x86.compilation_info_tracker.components;

import lombok.Getter;

@Getter
public class BlockScopeTracker {
    protected int scope;

    public BlockScopeTracker() {
        this.scope = 0;
    }

    public void incScope() {
        this.scope++;
    }

    public void decScope() {
        this.scope--;
    }
}
