package ua.artcod.homeWork.week5.recursion;

/**
 * Created by work on 08.09.2016.
 */
public class methods_Rec {

    public int factorial(int n) {

        if (n == 1){
            return 1;
        }

        int res = n * factorial(n-1);

        return res;

    }

    public int bunnyEars(int bunnies) {

        if (bunnies == 0){
            return 0;
        }
        int res = 2 + bunnyEars(bunnies - 1);

        return res;

    }

    public int fibonacci(int n) {

        int res = 0;
        if (n == 0){
            return res = 0;
        } else if (n == 1){
            return res = 1;
        }
        res = fibonacci(n - 1) + fibonacci(n - 2);
        return res;
    }

    public int bunnyEars2(int bunnies) {

        if (bunnies == 0){
            return 0;
        }

        if (bunnies == 1){
            return 2;
        }

        int res = 0;

        if (bunnies%2 == 0){
            res = 3;
        } else res = 2;

        res = bunnyEars2(bunnies - 1) + res;

        return res;
    }


    public int triangle(int rows) {


        if (rows == 0){
            return 0;
        }

        if (rows == 1){
            return 1;
        }

        int res = triangle(rows-1) + rows;

        return res;

    }

    static public String sumDigits(int n) {
        String str = "";
        if (n < 10) {
            str = str.valueOf(n);
            return str;
        } else if (n == 10) {
            str = str.valueOf(1);
            return str;
        }

        str = str.valueOf(sumDigits(n / 10)) + str.valueOf(n % 10);
        return str;
    }

    static int count7(int n) {
        int i = 0;

        if (n < 10 && n == 7) {
            return 1;
        } else if (n < 10) {
            return 0;
        }

        if (n % 10 == 7) {
            i = count7(n / 10) + 1;
        } else {
            i = count7(n / 10);
        }

        return i;
    }

    static int count8(int n) {
        int i = 0;

        if (n < 10 && n == 7) {
            return 1;
        } else if (n < 10) {
            return 0;
        }

        if (n % 10 == 7) {
            i = count7(n / 10) + 1;
        } else {
            i = count7(n / 10);
        }

        return i;
    }

    public int powerN(int base, int n) {
        if (n == 0){
            return 1;
        }

        int res = powerN(base,n-1) * base;

        return res;

    }

    static int countX(String str) {

        int i = 0;

        if (str.length() == 0 ){
            return 0;
        }

        if (str.substring(0,1).equals("x")){
            str = str.substring(1, str.length());
            i = countX(str) + 1;
        } else {
            str = str.substring(1, str.length());
            i = countX(str);
        }

        return i;
    }

    static int countHi(String str) {
        int i = 0;

        if (str.length() == 1 || str.length() == 0){
            return 0;
        }

        if (str.substring(0,2).equals("hi")){
            if (str.length() < 3){
                str = "";
                i = countHi(str) + 1;
            } else {
                str = str.substring(2, str.length());
                i = countHi(str) + 1;
            }
        } else {
                str = str.substring(1, str.length());
                i = countHi(str);
            }

            return i;

        }

        static String changeXY(String str){

            String newStr = "";

            if (str.length() == 0){
                return "";
            }
            if (str.substring(0,1).equals("x")){
                if (str.length() == 1){
                    return "y";
                } else {
                    newStr = "y" + changeXY(str.substring(1, str.length()));
                }
            } else {
                if (str.length() == 1){
                    return str;
                } else {
                    newStr = str.substring(0,1) + changeXY(str.substring(1, str.length()));
                }
            }
            return newStr;
        }

    static String changePi(String str){

        String newStr = "";

        if (str.length() == 0){
            return "";
        }
        if (str.length() > 1 && str.substring(0,2).equals("pi")){
            if (str.length() == 2){
                return "3.14";
            } else {
                newStr = "3.14" + changePi(str.substring(2, str.length()));
            }
        } else {
            if (str.length() == 1){
                return str;
            } else {
                newStr = str.substring(0,1) + changePi(str.substring(1, str.length()));
            }
        }
        return newStr;
    }

    static String noX(String str){

        String newStr = "";

        if (str.length() == 0){
            return "";
        }
        if (str.substring(0,1).equals("x")){
            if (str.length() < 2){
                return "";
            } else {
                newStr = noX(str.substring(1, str.length()));
            }
        } else {
            if (str.length() < 2){
                return str;
            } else {
                newStr = str.substring(0,1) + noX(str.substring(1, str.length()));
            }
        }
        return newStr;
    }

}