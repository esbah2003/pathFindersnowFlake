package PartA;
import Media.*;

/** This class draws a snowflake.
 * @author Esbah Majoka
 * @student# 7357981
 * @version 2.0 (March 24th)                                                     */
public class Snowflake {
    private final Turtle yertle;            // Pen
    private final TurtleDisplayer canvas;  // Canvas

    public Snowflake ( ) { //constructor
        yertle = new Turtle(0);
        canvas = new TurtleDisplayer(yertle, 600, 550);
        int repeat = 10; // repeat the snowflake 10 times

        yertle.penDown();
        yertle.moveTo(0,0);

        for (int i = 0; i < repeat; i++) {
            yertle.left(2 * Math.PI / repeat);
            branchOne(8,120);
            branchTwo(6,120);
            branchThree(7,140);
            branchFour(5,170);
        }

        yertle.penUp();
        canvas.close();
    }

    /** Drawing the snowflake by recursively calling until hit */
    public void branchOne (int order, int len) {
        if (order > 0 && len > 0) {
            yertle.forward(len);
            yertle.left(1 * Math.PI / 4);
            branchOne(order - 1, len / 2); // Recursive
            yertle.right(1 * Math.PI / 2);
            branchOne(order - 1, len / 2); // Recursive
            yertle.left(1 * Math.PI / 4);
            yertle.backward(len);
        }
    }

    /** The method branchTwo draws the snowflake pattern by recursively calling itself until it hits an order of 0
     */
    public void branchTwo (int order, int len) {
        if (order > 0 && len > 0) {
            branchTwo(order - 1, len / 3); // Recursive call
            yertle.forward(len);
            yertle.right(1 * Math.PI / 4);
            branchTwo(order - 1, len / 2); // Recursive call
            yertle.left(1 * Math.PI / 4);
            yertle.backward(len);
        }
    }

    public void branchThree (int order, int len) {
        if (order > 0 && len > 0) {
            yertle.forward(len);
            yertle.left(1 * Math.PI / 4);
            branchThree(order -1, len / 4); // Recursive
            yertle.right(1 * Math.PI / 2);
            branchThree(order - 1, len / 2); // Recursive
            yertle.left(1 * Math.PI / 4);
            yertle.backward(len);
        }
    }
    public void branchFour (int order, int len) {
        if (order > 0 && len > 0) {
            branchFour(order - 1, len / 2); // Recursive call
            yertle.forward(len);
            yertle.right(1 * Math.PI / 4);
            branchFour(order - 1, len / 2); // Recursive call
            yertle.left(1 * Math.PI / 4);
            yertle.backward(len);
        }
    }

    public static void main (String[] arg) { Snowflake s = new Snowflake(); }
}

