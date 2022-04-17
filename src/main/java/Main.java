import java.util.Scanner;

public class Main {
    static boolean isOperatorMinus = false;
    static boolean isOperationDelenie = false;
    static boolean outputRomOtvet = false;
    static Roman roman = new Roman();

    public static void main(String[] args) throws ExceptionNumber {
        System.out.println("vvedite virazhenie: ");
        Scanner vvod = new Scanner(System.in);
        String str = vvod.nextLine();
        String result = calc(str);

        int otvet = Integer.parseInt(result);

        if (outputRomOtvet) {
            String otvet2 = roman.arabToRome(otvet);
            System.out.println("Otvet: " + otvet2);
        } else {
            System.out.println("Otvet: " + otvet);
        }
    }

    public static String calc(String input) throws ExceptionNumber {
        String[] stroka = input.split(" ");

        String znak = stroka[1];
        char oper = znak.charAt(0);

        String firstNum = stroka[0];
        String secondNum;

        try {
            secondNum = stroka[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ExceptionNumber("не является выражением");
        }
        if (stroka.length > 3)
            throw new ExceptionNumber("введите два операнда и один оператор");

        int num1;
        int num2;

        if (roman.isRoman(input)) {
            num1 = roman.romChis(firstNum);
            num2 = roman.romChis(secondNum);
        } else {
            num1 = Integer.parseInt(stroka[0]);
            num2 = Integer.parseInt(stroka[2]);
        }

        if (num1 < 0 || num1 > 10) {
            throw new ExceptionNumber("ne podxodit first");
        }
        if (num2 < 0 || num2 > 10) {
            throw new ExceptionNumber("ne podxodit second");
        }

        if ((oper != '-') && (oper != '+') && (oper != '*') && (oper != '/')) {
            throw new ExceptionNumber("vvodite znak operaci:");
        }

        boolean firstNumberIsRoman = roman.isRoman(firstNum);
        boolean secondNumberIsRoman = roman.isRoman(secondNum);

        if (firstNumberIsRoman && secondNumberIsRoman) {
            num1 = roman.romChis(firstNum);
            num2 = roman.romChis(secondNum);
            outputRomOtvet = true;

        } else if (!firstNumberIsRoman && !secondNumberIsRoman) {
            num1 = Integer.parseInt(stroka[0]);
            num2 = Integer.parseInt(stroka[2]);
        } else {
            throw new ExceptionNumber("Должны быть оба арабские или римские");
        }

        if (oper == '-') {
            isOperatorMinus = true;
        } else if (oper == '/') {
            isOperationDelenie = true;
        }


        if (outputRomOtvet && isOperatorMinus && (num1 < num2)) {
            throw new ExceptionNumber("В римской системе нет отрицательных чисел");
        }

        if (outputRomOtvet && isOperatorMinus && (num1 == num2))
            throw new ExceptionNumber("В римской системе нет нолей");

        if (isOperationDelenie && (num2 == 0))
            throw new ExceptionNumber("На ноль делить нельзя");

        int otvet = calcViraz(num1, num2, oper);

        return String.valueOf(otvet);
    }



    static int calcViraz(int num1, int num2, char oper) {
        int otvet;
        switch (oper) {
            case ('+'):
                otvet = num1 + num2;
                break;
            case ('-'):
                otvet = num1 - num2;
                break;
            case ('*'):
                otvet = num1 * num2;
                break;
            default:
                otvet = num1 / num2;
                break;
        }
        return otvet;

    }
}








