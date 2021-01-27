package com.company;

public class Method {

    public int begin, end, per, even ,odd = 0 ;
    /**поля: початок інтервалу, кінець інтервалу,
     * кількість непарних чисел, кількість парних чисел
     */

    public void Odd() {
        for (int i = begin; i <= end; ++i)
            if (i % 2 != 0)
                System.out.print(i + ";");
        System.out.println();
    }

    public void Even() {
        for (int i = end; i >= begin; --i)
            if (i % 2 == 0)
                System.out.print(i + ";");
        System.out.println();
    }
    /** функція додавання непарних чисел
     * @return повертає суму непарних чисел
     */
    public int SumOdd() {
        int sum = 0;
        for (int i = begin; i <= end; ++i)
            if (i % 2 != 0)
                sum += i;
        return sum;
    }
    /** функція додавання парних чисел
     * @return повертає суму парних чисел
     */

    public int SumEven() {
        int sum = 0;
        for (int i = begin; i <= end; ++i)
            if (i % 2 == 0)
                sum += i;
        return sum;
    }
    /**Функція побудови ряду Фібоначчі
     * @return повертає друге число ряду
     */

    public int Fibonacci(int length) {
        int first = begin, second = end, temp;
        if (end % 2 != 0) {
            first = end;
            second = end - 1;
        }
        else if (end % 2 == 0){
            first = end - 1;
            second = end;
        }
        for (int i = 0; i < length; ++i) {
            temp = first + second;
            first = second;
            second = temp;
        }
        if (second % 2 != 0)
            odd++;
        return second;
    }

    public int percentOdd(int length) {
        per = odd * 100/ length ;
        return per;
    }
    /** функція для обчислення відсотка непарних чисел
     * @return повертає відсоток непарних чисел
     */
    public int percentEven(int length) {

        return 100 - per;
    }
    /** функція обчислення відсотка парних чисел
     * @return повертає відсоток парних чисел
     */
}
