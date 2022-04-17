public class Roman {

    int[] arab = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] roma = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    boolean isRoman(String input) {
        return input.contains("I") || input.contains("V") || input.contains("X") || input.contains("L") || input.contains("C");
    }

    int romChis(String c) {
        switch (c) {
            case ("I"):
                return 1;
            case ("II"):
                return 2;
            case ("III"):
                return 3;
            case ("IV"):
                return 4;
            case ("V"):
                return 5;
            case ("VI"):
                return 6;
            case ("VII"):
                return 7;
            case ("VIII"):
                return 8;
            case ("IX"):
                return 9;
            case ("X"):
                return 10;
            case ("C"):
                return 100;
            case ("M"):
                return 1000;
            default:
                return 0;
        }
    }

    public String arabToRome(int otvet) {
        String result = "";
        for (int i = 0; i < arab.length; i++) {
            if ((otvet - arab[i]) >= 0) {
                otvet = otvet - arab[i];
                result += roma[i];
                i = 0;
            }
        }
        return result;
    }

}
