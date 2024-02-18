public class Test {
    public static void main(String[] args) {
        // Тестирование класса Complex
        // Создаем два числа
        Complex a = new Complex(5, -3);
        Complex b = new Complex(12, 8);
        System.out.println("a = " + a.toStr());
        System.out.println("b = " + b.toStr());

        //Вычисляем сумму
        Complex sum_c = Complex.sum(a, b);
        System.out.println("Сумма: " + sum_c.toStr());

        //Вычисляем разность
        Complex diff_c = Complex.diff(a, b);
        System.out.println("Разность: " + diff_c.toStr());

        //Вычисляем произведение
        Complex product_c = Complex.mul(a, b);
        System.out.println("Произведение: " + product_c.toStr());

        //Вычисляем частное
        Complex div = Complex.div(a, b);
        System.out.println("Частное: " + div.toStr() + "\n");


        // Тестирование класса Matrix
        // Создаем две матрицы 2х2
        Complex[][] arr1 = {{new Complex(1, 2), new Complex(-3, -4)}, {new Complex(5, -6), new Complex(7, 8)}};
        Complex[][] arr2 = {{new Complex(1, -1), new Complex(2, 2)}, {new Complex(3, -3), new Complex(4, 4)}};

        Matrix m1 = new Matrix(arr1);
        Matrix m2 = new Matrix(arr2);

        System.out.println("Матрица m1:");
        m1.print();
        System.out.println();

        System.out.println("Матрица m2:");
        m2.print();
        System.out.println();

        // Проверяем сложение матриц
        Matrix sum = Matrix.sum(m1, m2);
        System.out.println("Сумма матриц:");
        sum.print();
        System.out.println();

        // Проверяем вычитание матриц
        Matrix diff = Matrix.diff(m1, m2);
        System.out.println("Разность матриц:");
        diff.print();
        System.out.println();

        // Проверяем умножение матриц
        Matrix product = Matrix.mul(m1, m2);
        System.out.println("Произведение матриц:");
        product.print();
        System.out.println();

        // Проверяем умножение матриц на число
        Matrix mulnum = Matrix.mulnum(m1, new Complex(5, -3));
        System.out.println("Произведение матрицы m1 на 5-3i:");
        mulnum.print();
        System.out.println();

        // Проверяем транспонирование матрицы
        Matrix tr = Matrix.transposition(m1);
        System.out.println("Транспонированная матрица m1:");
        tr.print();
        System.out.println();

        // Проверяем нахождение детерминанта матрицы
        Complex determinant = m1.det();
        System.out.println("Детерминант матрицы m1: " + determinant.toStr());
        System.out.println();

        // Создаем две матрицы 2х3 и 2х2
        Complex[][] arr3 = {{new Complex(0, 1), new Complex(-4, 2), new Complex(5, 0)}, {new Complex(-2, -9), new Complex(3, -3), new Complex(4, 4)}};
        Complex[][] arr4 = {{new Complex(6, 1), new Complex(-1, -4)}, {new Complex(4, -6), new Complex(8, 3)}};

        Matrix m3 = new Matrix(arr3);
        Matrix m4 = new Matrix(arr4);

        System.out.println("Матрица m3:");
        m3.print();
        System.out.println();

        System.out.println("Матрица m4:");
        m4.print();
        System.out.println();

        // Проверяем сложение матриц разных размерностей
        try {
            Matrix sum1 = Matrix.sum(m3, m4);
        } catch (IllegalArgumentException e) {
            System.out.println("Матрицы разных размерностей нельзя складывать");
        }
        System.out.println();

        // Проверяем вычитание матриц разных размерностей
        try {
            Matrix diff1 = Matrix.diff(m3, m4);
        } catch (IllegalArgumentException e) {
            System.out.println("Матрицы разных размерностей нельзя вычитать");
        }
        System.out.println();

        // Проверяем умножение матриц, которые нельзя умножать
        try {
            Matrix product1 = Matrix.mul(m3, m4);
        } catch (IllegalArgumentException e) {
            System.out.println("При перемножении количество столбцов первой матрицы должно равняться количеству строк второй");
        }
        System.out.println();

        // Проверяем умножение матриц на число
        Matrix mulnum1 = Matrix.mulnum(m3, new Complex(5, -3));
        System.out.println("Произведение матрицы m3 на 5-3i:");
        mulnum1.print();
        System.out.println();

        // Проверяем транспонирование матрицы
        Matrix tr1 = Matrix.transposition(m3);
        System.out.println("Транспонированная матрица m3:");
        tr1.print();
        System.out.println();

        // Проверяем нахождение детерминанта не квадратной матрицы
        try {
            Complex determinant1 = m3.det();
        } catch (IllegalArgumentException e) {
            System.out.println("У не квадратной матрицы нельзя находить детерминант");
        }
        System.out.println();
    }
}
