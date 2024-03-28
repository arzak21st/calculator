package dev.arzak21st.calculator.services;

public class ValidationService {

    char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] symbols = {'.', '+', '-', '×', '/'};

    public boolean numberIsAllowed(String expression) {

        if(!expression.equals("")) {

            boolean expressionContainsLetter = expressionContainsLetter(expression);
            if(!expressionContainsLetter) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean symbolIsAllowed(String expression, char symbol) {

        if(expression.equals("") && symbol == '-') {
            return true;
        }

        if(!expression.equals("")) {

            char lastCharacter = expression.charAt(expression.length() - 1);
            boolean lastCharacterIsNumber = isNumber(lastCharacter);
            if(lastCharacterIsNumber) {

                if(symbol == '.') {

                    char dot = symbol;
                    boolean dotIsAllowed = dotIsAllowed(expression, dot); // You know to prevent having a number with two dots (Ex: 1.5.)
                    if(!dotIsAllowed) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private boolean isNumber(char character) {

        for(char number : numbers) {

            if(character == number) {
                return true;
            }
        }
        return false;
    }

    public boolean expressionContainsLetter(String expression) {

        for(int expressionIndex = 0; expressionIndex < expression.length(); expressionIndex++) {

            char character = expression.charAt(expressionIndex);
            if(Character.isLetter(character)) {
                return true;
            }
        }
        return false;
    }

    private boolean dotIsAllowed(String expression, char dot) {

        int lastIndexOfDot = expression.lastIndexOf(dot);
        if(lastIndexOfDot > 0) { // If there is at least one last dot within the expression

            for(char symbol : symbols) { // Iterate over 'symbols' array

                if(symbol != dot) { // except for the dot element

                    if(expression.substring(lastIndexOfDot).indexOf(symbol) > 0) { // If there is any other symbol after the last dot. If yes then the number after that last dot has not dot (Ex: 1.5+1)
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public String filterExpression(String expression) {

        String filteredExpression = expression;

        // Remove the last character if it's a symbol
        for(char symbol : symbols) {

            char lastCharacter = expression.charAt(expression.length() - 1);
            if(lastCharacter == symbol) {

                filteredExpression = expression.substring(0, expression.length() - 1);
                break;
            }
        }

        return filteredExpression;
    }

    public int countExpressionElements(String expression) {

        int expressionElementsCount = 0;
        int counter = 0;

        for(int expressionIndex = 1; expressionIndex < expression.length(); expressionIndex++) { // Iterate over the expression characters except for the first one (could be either a number or a symbol)

            for(int symbolIndex = 1; symbolIndex < symbols.length; symbolIndex++) { // Iterate over the symbols except for the first one (.)

                if(expression.charAt(expressionIndex) == symbols[symbolIndex]) { // If the current expression character is a symbol (+ - × /)
                    counter++; // Count an element
                }
            }
        }
        expressionElementsCount = counter * 2 + 1; // * 2 because each symbol is associated with a number before it | + 1 in case there is only one element of numbes
        
        return expressionElementsCount;
    }
}
