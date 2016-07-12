// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Board {

    private final int rows;
    private final int columns;
    private boolean isFalling = false;
    private Block block;
    private List<Block> fallenBlocks = new ArrayList<>();
    private int fallenCount;
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.fallenCount = rows;
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                s += displayOf(row, col);
            }
            s += "\n";
        }
        return s;
    }

    @NotNull
    private String displayOf(int row, int col) {
        Block block = blockIn(row);
        if (block == null) {
            block = this.block;
        }
        return block != null && row == block.position() && col == 1 ? block.display() : ".";
    }

    private Block blockIn(int row) {
        for(int i = 0; i < fallenBlocks.size(); i++) {
            if(fallenBlocks.get(i).position() == row)
                return fallenBlocks.get(i);
        }
        return null;
    }

    public boolean hasFalling() {
        return isFalling;
    }

    public void drop(Block block) {
        if (isFalling) {
            throw new IllegalStateException("already falling");
        } else {
            this.block = block;
            isFalling = true;

        }
    }

    public void tick() {
        System.out.println(block.position());
        if (block.position() == fallenCount - 1) {
            isFalling = false;
            fallenBlocks.add(block);
            fallenCount--;
        } else {
            block.updatePostion();
        }
    }
}
