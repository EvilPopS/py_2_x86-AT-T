package main.java.evilpops.pyathome_2_x86.compilation_info_tracker.components;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReturnStatInfoTracker {
    protected static class BlockReturnInfo {
        @Getter
        protected boolean hasExplicitReturn;
        @Getter
        protected BlockReturnInfo parentBlock;

        protected boolean hasElseStatement;

        protected List<BlockReturnInfo> branches;

        public BlockReturnInfo(BlockReturnInfo parentBlock) {
            this.hasExplicitReturn = false;
            this.parentBlock = parentBlock;
            this.hasElseStatement = false;
            this.branches = new ArrayList<>();
        }

        public void setHasExplicitReturnTrue() {
            this.hasExplicitReturn = true;
        }

        public void setHasElseStatementTrue() {
            this.hasElseStatement = true;
        }

        public void setHasElseStatementFalse() {
            this.hasElseStatement = false;
        }

        public boolean checkHasReturn() {
            return this.hasExplicitReturn || (this.hasElseStatement && this.checkAllBranchesHaveReturn());
        }

        public BlockReturnInfo addBranch() {
            BlockReturnInfo newBranch = new BlockReturnInfo(this);
            this.branches.add(newBranch);
            return newBranch;
        }

        private boolean checkAllBranchesHaveReturn() {
            for (BlockReturnInfo bri : this.branches)
                if (!bri.checkHasReturn())
                    return false;
            return true;
        }
    }

    protected final Stack<BlockReturnInfo> funcBlocks;
    protected Stack<BlockReturnInfo> currBlocksTrack;

    public ReturnStatInfoTracker() {
        this.funcBlocks = new Stack<>();
        this.currBlocksTrack = new Stack<>();
    }

    public boolean isReturnAllowed() {
        return !this.funcBlocks.isEmpty();
    }

    public boolean doesFunctionHasReturn() {
        if (!this.funcBlocks.isEmpty())
            return this.funcBlocks.peek().checkHasReturn();
        return false;
    }

    public void onReturnStatementCreate() {
        this.currBlocksTrack.peek().setHasExplicitReturnTrue();
    }

    public void onIfOrWhileStatementCreate() {
        if (!this.funcBlocks.isEmpty())
            this.currBlocksTrack.peek().setHasElseStatementFalse();
    }

    public void onElsePartCreate() {
        if (!this.funcBlocks.isEmpty())
            this.currBlocksTrack.peek().setHasElseStatementTrue();
    }

    public void onNewFuncStart() {
        this.funcBlocks.push(new BlockReturnInfo(null));
        this.currBlocksTrack.push(this.funcBlocks.peek());
    }

    public void onFuncEnd() {
        this.funcBlocks.pop();
        this.currBlocksTrack.pop();
    }

    public void onBlockStart() {
        if (!this.funcBlocks.isEmpty()) {
            BlockReturnInfo newCurrBlockInfo = this.currBlocksTrack.peek().addBranch();
            this.currBlocksTrack.pop();
            this.currBlocksTrack.push(newCurrBlockInfo);
        }
    }

    public void onBlockEnd() {
        if (!this.funcBlocks.isEmpty()) {
            BlockReturnInfo parentBlockInfo = this.currBlocksTrack.peek().getParentBlock();
            this.currBlocksTrack.pop();
            this.currBlocksTrack.push(parentBlockInfo);
        }
    }

}
