//: reusing/BlankFinal.java - Page 142
// "Blank" final fields
package org.thinkinginjava.examples.chapter07.reusing.unit08final;

class Poppet {
    private int i;
    Poppet(int ii) {
        this.i = ii;
    }
}

public class BlankFinal {
    private final int i = 0; // Initialized final
    private final int j; // Blank final
    private final Poppet p;
    // Blank finals MUST to initialized in the constructor;
    public BlankFinal() {
        j = 1; // Initialized blank final
        p = new Poppet(1); // Initialize blank final reference
    }

    public BlankFinal(int x) {
        this.j = x; // Initialized blank final
        p = new Poppet(x); // Initialize blank final reference
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
}
