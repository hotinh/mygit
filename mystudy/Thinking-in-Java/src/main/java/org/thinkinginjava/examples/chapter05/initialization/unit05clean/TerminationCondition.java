//: initialization/TerminationCondition.java - Page 89
// Using finalize() to detech an object that
// hasn't been properly cleaned up.
package org.thinkinginjava.examples.chapter05.initialization.unit05clean;

class Book {
    boolean checkedOut = false;

    Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
    void CheckIn() {
        checkedOut =false;
    }
    @Override
    protected void finalize() {
        if (checkedOut) {
            System.out.println("Error: checked out");
        }
        // Normally, you'll also do this:
        // super.finalize(); //Call the base-class version
    }
}
public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        // Proper cleanup
        novel.CheckIn();
        // Drop the reference, forget to clean up:
        new Book(true);
        // Force garbage collection & finalization:
        System.gc();
    }
}
