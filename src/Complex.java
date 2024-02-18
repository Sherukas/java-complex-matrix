public class Complex {
    private double re, im;

    public Complex() {
        this(0, 0);
    }

    public Complex(double re) {
        this(re, 0);
    }

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }

    public static Complex sum(Complex a, Complex b) {
        return new Complex(a.re + b.re, a.im + b.im);
    }

    public static Complex diff(Complex a, Complex b) {
        return new Complex(a.re - b.re, a.im - b.im);
    }

    public static Complex mul(Complex a, Complex b) {
        return new Complex(a.re * b.re - a.im * b.im, a.re * b.im + a.im * b.re);
    }


    public static Complex div(Complex a, Complex b) {
        return new Complex((a.re * b.re + a.im * b.im) / (b.re * b.re + b.im * b.im), (a.im * b.re - a.re * b.im) / (b.re * b.re + b.im * b.im));
    }


    public void addToCurrent(Complex other) {
        this.re += other.re;
        this.im += other.im;
    }

    public void diffToCurrent(Complex other) {
        this.re -= other.re;
        this.im -= other.im;
    }

    public void mulToCurrent(Complex other) {
        double new_re = this.re * other.re - this.im * other.im;
        double new_im = this.re * other.im + this.im * other.re;
        this.re = new_re;
        this.im = new_im;
    }


    public void divToCurrent(Complex other) {
        double new_re = (this.re * other.re + this.im * other.im) / (other.re * other.re + other.im * other.im);
        double new_im = (this.im * other.re - this.re * other.im) / (other.re * other.re + other.im * other.im);
        this.re = new_re;
        this.im = new_im;
    }

    public String toStr() {
        return this.re + (this.im < 0 ? "" : "+") + this.im + "*i";
    }

    public void print() {
        System.out.print(this.re + (this.im < 0 ? "" : "+") + this.im + "*i");
    }

    public void println() {
        System.out.println(this.re + (this.im < 0 ? "" : "+") + this.im + "*i");
    }
}
