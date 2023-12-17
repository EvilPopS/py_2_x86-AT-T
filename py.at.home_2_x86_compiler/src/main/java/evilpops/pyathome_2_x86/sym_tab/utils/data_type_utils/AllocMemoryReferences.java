package main.java.evilpops.pyathome_2_x86.sym_tab.utils.data_type_utils;

import java.util.HashMap;
import java.util.Map;

public class AllocMemoryReferences {
    protected Integer refID;
    protected final Map<Integer, Integer> refCounts;

    public AllocMemoryReferences() {
        this.refID = 0;
        this.refCounts = new HashMap<>();
    }

    public Integer addNewMemRef() {
        this.refCounts.put(this.refID, 1);
        return this.refID++;
    }

    public void incMemRef(Integer memRef) {
        if (memRef != null)
            this.refCounts.put(memRef, this.refCounts.get(memRef) + 1);
    }

    public boolean decMemRefAndCheckIfLast(Integer memRef) {
        Integer currRefCount = this.refCounts.get(memRef);
        this.refCounts.put(memRef, currRefCount - 1);
        return currRefCount == 0;
    }

}
