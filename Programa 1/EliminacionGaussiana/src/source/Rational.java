package source;


/******************************************************************************
 *  Compilation:  javac Rational.java
 *  Execution:    java Rational
 *
 *  ADT for nonnegative Rational numbers. Bare-bones implementation.
 *  Cancel common factors, but does not stave off overflow. Does not
 *  support negative fractions.
 *
 *  Invariant: all Rational objects are in reduced form (except
 *  possibly while modifying).
 *
 *  Remarks
 *  --------
 *    - See http://www.cs.princeton.edu/introcs/92symbolic/BigRational.java.html
 *      for a version that supports negative fractions and arbitrary
 *      precision numerators and denominators.
 *
 *  % java Rational
 *  5/6
 *  1
 *  28/51
 *  17/899
 *  0
 *
 ******************************************************************************/

public class Rational {
    private int num;   // the numerator
    private int den;   // the denominator

    // create and initialize a new Rational object
    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new RuntimeException("Denominator is zero");
        }
        int g = gcd(numerator, denominator);
        num = numerator   / g;
        den = denominator / g;

    }

    // return string representation of (this)
    public String toString() {
        if (den == 1) return num + "";
        else          return num + "/" + den;
    }

    // return (this * b)
    public Rational times(Rational b) {
        return new Rational(this.num * b.num, this.den * b.den);
    }


    // return (this + b)
    public Rational plus(Rational b) {
        int numerator   = (this.num * b.den) + (this.den * b.num);
        int denominator = this.den * b.den;
        return new Rational(numerator, denominator);
    }

    // return (1 / this)
    public Rational reciprocal() { return new Rational(den, num);  }

    // return (this / b)
    public Rational divides(Rational b) {
        return this.times(b.reciprocal());
    }


   /***************************************************************************
    *  Helper functions
    ***************************************************************************/

    // return gcd(m, n)
    private static int gcd(int m, int n) {
        if (0 == n) return m;
        else return gcd(n, m % n);
    }


   /***************************************************************************
    *  Test client
    ***************************************************************************/
/*
    public static void main(String[] args) {
        Rational x, y, z;

        // 1/2 + 1/3 = 5/6
        x = new Rational(1, 2);
        y = new Rational(1, 3);
        z = x.plus(y);
        StdOut.println(z);

        // 8/9 + 1/9 = 1
        x = new Rational(8, 9);
        y = new Rational(1, 9);
        z = x.plus(y);
        StdOut.println(z);

        //  4/17 * 7/3 = 28/51
        x = new Rational(4, 17);
        y = new Rational(7,  3);
        z = x.times(y);
        StdOut.println(z);

        // 203/16957 * 9299/5887 = 17/899
        x = new Rational(203, 16957);
        y = new Rational(9299, 5887);
        z = x.times(y);
        StdOut.println(z);

        // 0/6 = 0
        x = new Rational(0, 6);
        StdOut.println(x);

    }*/

}
