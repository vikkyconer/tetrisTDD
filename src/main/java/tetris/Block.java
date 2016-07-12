// Copyright (c) 2008-2016  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import org.jetbrains.annotations.NotNull;

/**
 * Created by vikas on 8/7/16.
 */
public class Block {
    private char block;
    private int position;
    public Block(char block) {
        this.block = block;
        this.position = 0;
    }

    @Override
    public String toString()
    {
        return String.valueOf(block);
    }

    public int position() {
        return position;
    }
    public void updatePostion() {
        this.position++;
    }

    @NotNull
    public String display() {
        return String.valueOf(block);
    }
}
