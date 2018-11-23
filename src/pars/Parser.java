package pars;

import java.math.BigDecimal;

public class Parser {
    final int NONE = 0;
    final int DELIMITER = 1;
    final int VARIABLE = 2;
    final int NUMBER = 3;
    final int SYNTAX_ERROR = 0;
    final int UNBALPARENS = 1;
    final int NOEXP = 2;
    final int DIVBYZERO = 3;
    final String EOF = "\0";
    public String link_for_line;     //  Ссылка на строку с выражением
    public int index;     //  Текущий индекс в выражении
    public String lexeme;   //  Сохранение текущей лексемы
    public int lexemeType;    //  Сохранение типа лексемы


    public String toString() {
        return String.format("link_for_line = {0}\nexplds = {1}\nToken = {2}\nTokType = {3}", link_for_line.toString(), index, lexeme.toString(), lexemeType);
    }

    public void getToken() { //  Получить следующую лексему
        lexemeType = NONE;
        lexeme = "";

        if (index == link_for_line.length()) { //  Проверка на окончание выражения
            lexeme = EOF;
            return;
        }
        while (index < link_for_line.length() && Character.isWhitespace(link_for_line.charAt(index))) //  Проверка на пробелы
            ++index;
        if (index == link_for_line.length()) {      //  Проверка на окончание выражения
            lexeme = EOF;
            return;
        }
        if (isDelim(link_for_line.charAt(index))) {
            lexeme += link_for_line.charAt(index);
            index++;
            lexemeType = DELIMITER;
        } else if (Character.isLetter(link_for_line.charAt(index))) {
            while (!isDelim(link_for_line.charAt(index))) {
                lexeme += link_for_line.charAt(index);
                index++;
                if (index >= link_for_line.length()) break;
            }
            lexemeType = VARIABLE;
        } else if (Character.isDigit(link_for_line.charAt(index))) {
            while (!isDelim(link_for_line.charAt(index))) {
                lexeme += link_for_line.charAt(index);
                index++;
                if (index >= link_for_line.length())
                    break;
            }
            lexemeType = NUMBER;
        } else {
            lexeme = EOF;
            return;
        }
    }

    public boolean isDelim(char charAt) {
        if ((" +-/*%^=()".indexOf(charAt)) != -1)
            return true;
        return false;
    }

    public BigDecimal evaluate(String expstr) throws ParserException {
        BigDecimal result = new BigDecimal("0");
        link_for_line = expstr;
        index = 0;
        getToken();
        if (lexeme.equals(EOF))
            handleErr(NOEXP);   //  Нет выражения
        result = evalExp2();
        if (!lexeme.equals(EOF))
            handleErr(SYNTAX_ERROR);
        return result;
    }

    public BigDecimal evalExp2() throws ParserException {
        char c;
        BigDecimal result;
        BigDecimal partialResult;
        result = evalExp3();
        while ((c = lexeme.charAt(0)) == '+' ||
                c == '-') {
            getToken();
            partialResult = evalExp3();
            switch (c) {
                case '-':
                    result = result.subtract(partialResult);
                    break;
                case '+':
                    result = result.add(partialResult);
                    break;
            }
        }
        return result;
    }

    public BigDecimal evalExp3() throws ParserException {
        int one = 0;
        int two = 0;
        int n = 0;
        char c;
        BigDecimal result;
        BigDecimal partialResult;
        result = evalExp4();
        while ((c = lexeme.charAt(0)) == '*' ||
                c == '/' | c == '%') {
            getToken();
            partialResult = evalExp4();
            switch (c) {
                case '*':
                    result = result.multiply(partialResult);
                    break;
                case '/': {
                    BigDecimal zero = new BigDecimal("0");
                    int ch = zero.compareTo(result);
                    if (ch == 0)
                        handleErr(DIVBYZERO);
                    one = result.toString().length();
                    two = partialResult.toString().length();
                    if (one > two) {
                        n = one;
                    } else {
                        n = two;
                    }
                    result = result.divide(partialResult, n, BigDecimal.ROUND_CEILING);
                    break;
                }
                case '%':
                    BigDecimal zero = new BigDecimal("0");
                    int ch = zero.compareTo(result);
                    if (ch == 0)
                        handleErr(DIVBYZERO);
                    result = result.remainder(partialResult);
                    break;
            }
        }
        return result;
    }

    public BigDecimal evalExp4() throws ParserException {

        BigDecimal result;
        BigDecimal partialResult;
        BigDecimal a;
        int t;
        result = evalExp5();
        if (lexeme.equals("^")) {
            getToken();
            partialResult = evalExp4();
            a = result;
            BigDecimal zero = new BigDecimal("0");
            int ch = zero.compareTo(result);
            if (ch == 0) {
                BigDecimal one1 = new BigDecimal("1");
                result = result.multiply(zero).add(one1);
            } else {
                int value = partialResult.intValue();
                for (t = value - 1; t > 0; t--)
                    result = result.multiply(a);
            }
        }
        return result;
    }

    public BigDecimal evalExp5() throws ParserException {
        BigDecimal result;
        String c;
        c = " ";

        if ((lexemeType == DELIMITER) && lexeme.equals("+") ||
                lexeme.equals("-")) {
            c = lexeme;
            getToken();
        }
        result = evalExp6();
        if (c.equals("-")) {
            BigDecimal one = new BigDecimal("-1");
            result = result.multiply(one);
        }
        return result;
    }

    public BigDecimal evalExp6() throws ParserException {
        BigDecimal result;
        if (lexeme.equals("(")) {
            getToken();
            result = evalExp2();
            if (!lexeme.equals(")"))
                handleErr(UNBALPARENS);
            getToken();
        } else result = atom();
        return result;
    }

    public BigDecimal atom() throws ParserException {
        BigDecimal result = new BigDecimal("0");

    }

    //  Кинуть ошибку
    private void handleErr(int nOEXP2) throws ParserException {

        String[] err = {
                "Синтаксическая ошибка",
                "Некорректное количество скобок",
                "Отсутствует выражение",
                "Деление на 0"
        };
        throw new ParserException(err[nOEXP2]);
    }


}