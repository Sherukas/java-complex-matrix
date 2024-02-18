public class Matrix {
    private int rows, cols;
    private Complex[][] matrix;

    public Matrix() {
        this(0, 0);
    }

    public Matrix(int n) {
        this(n, n);
    }

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new Complex[rows][cols];
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < cols; ++j)
                matrix[i][j] = new Complex(0);
    }

    public Matrix(Complex[][] arr) {
        this.rows = arr.length;
        this.cols = arr[0].length;
        matrix = arr;
    }

    public Matrix(double[][] arr) {
        this.rows = arr.length;
        this.cols = arr[0].length;
        matrix = new Complex[this.rows][this.cols];
        for (int i = 0; i < this.rows; ++i)
            for (int j = 0; j < this.cols; ++j)
                matrix[i][j] = new Complex(arr[i][j]);
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Complex[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Complex[][] matrix) {
        this.matrix = matrix;
    }

    public void setElem(int i, int j, Complex value) {
        matrix[i][j].setRe(value.getRe());
        matrix[i][j].setIm(value.getIm());
    }

    public Complex getElem(int i, int j) {
        return matrix[i][j];
    }

    public static Matrix sum(Matrix a, Matrix b) {
        if (a.getRows() != b.getRows() || a.getCols() != b.getCols()) {
            throw new IllegalArgumentException("The sum cannot be found for matrices of different dimensions");
        }
        Matrix res = new Matrix(a.rows, a.cols);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                res.setElem(i, j, Complex.sum(a.getElem(i, j), b.getElem(i, j)));
            }
        }
        return res;
    }

    public static Matrix diff(Matrix a, Matrix b) {
        if (a.getRows() != b.getRows() || a.getCols() != b.getCols()) {
            throw new IllegalArgumentException("The difference cannot be found for matrices of different dimensions");
        }
        Matrix res = new Matrix(a.rows, a.cols);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                res.setElem(i, j, Complex.diff(a.getElem(i, j), b.getElem(i, j)));
            }
        }
        return res;
    }

    public static Matrix mul(Matrix a, Matrix b) {
        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException("Matrix sizes are incompatible for multiplication");
        }

        Matrix res = new Matrix(a.rows, b.cols);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < b.cols; j++) {
                Complex sum = new Complex(0);
                for (int k = 0; k < a.cols; ++k) {
                    sum.addToCurrent(Complex.mul(a.getElem(i, k), b.getElem(k, j)));
                }
                res.setElem(i, j, sum);
            }
        }
        return res;
    }

    public static Matrix mulnum(Matrix a, Complex b) {
        Matrix res = new Matrix(a.rows, a.cols);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                res.setElem(i, j, Complex.mul(a.getElem(i, j), b));
            }
        }
        return res;
    }

    public void transposition() {
        Matrix res = new Matrix(this.cols, this.rows);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                res.setElem(j, i, this.getElem(i, j));
            }
        }
        this.matrix = res.matrix;
        this.cols = res.cols;
        this.rows = res.rows;
    }

    public static Matrix transposition(Matrix a) {
        Matrix res = new Matrix(a.cols, a.rows);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.cols; j++) {
                res.setElem(j, i, a.getElem(i, j));
            }
        }
        return res;
    }

    public Matrix minor(int x, int y) {
        Matrix minor = new Matrix(this.cols - 1, this.rows - 1);
        int k = 0, n = 0;
        for (int i = 0; i < this.rows; i++) {
            if (i == x) continue;
            for (int j = 0; j < this.cols; j++) {
                if (j == y) continue;
                minor.setElem(k, n++, this.getElem(i, j));
            }
            ++k;
            n = 0;
        }
        return minor;
    }

    public Complex det() {
        if (this.rows == 0 || this.cols == 0) {
            throw new IllegalArgumentException("Matrix is empty");
        } else if (this.rows != this.cols) {
            throw new IllegalArgumentException("Determinant can only be found in a square matrix");
        } else if (this.rows == 1) {
            return this.getElem(0, 0);
        }
        Complex det = new Complex(0);
        for (int i = 0; i < this.cols; ++i) {
            Complex detMinor = Complex.mul(this.getElem(0, i), this.minor(0, i).det());
            if (i % 2 == 0) {
                det.addToCurrent(detMinor);
            } else {
                det.diffToCurrent(detMinor);
            }
        }
        return det;
    }

    public void print() {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                System.out.print(matrix[i][j].toStr() + "  ");
            }
            System.out.println();
        }
    }
}
