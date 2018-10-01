//: reusing/Jurassic.java - Page 144-145
// Making an entire class final.
package org.thinkinginjava.examples.chapter07.reusing.unit08final;

class SmallBrain {

}

final class Dinosaur {
    int i = 7;
    int j = 1;
    SmallBrain x = new SmallBrain();
    void f() {

    }
}

// class Further extends Dinosaur {}
// error: cannot extend final class 'Dinosaur'

public class Jurasic {
    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
    }
}
