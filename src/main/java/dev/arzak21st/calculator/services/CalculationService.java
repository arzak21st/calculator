package dev.arzak21st.calculator.services;

public class CalculationService {

    char[] symbols = {'+', '-', '×', '/'};

    public String getResult(String expression, int expressionCharactersCount) {

        String result = expression;
        String formattedResult = result;

        String[] expressionAsArray = convertExpression(expression, expressionCharactersCount);
        String[] expressionAsArrayWithoutDivision = calculateResult(expressionAsArray, "/");
        String[] expressionAsArrayWithoutMultiplication = calculateResult(expressionAsArrayWithoutDivision, "×");
        String[] expressionAsArrayWithoutSubtraction = calculateResult(expressionAsArrayWithoutMultiplication, "-");
        String[] expressionAsArrayWithoutAddition = calculateResult(expressionAsArrayWithoutSubtraction, "+");

        if(expressionAsArrayWithoutAddition.length == 1) {

            result = expressionAsArrayWithoutAddition[0];
            formattedResult = formatResult(result);
        }

        return formattedResult;
    }

    private String[] convertExpression(String expression, int expressionCharactersCount) {

        String[] expressionAsArray = new String[expressionCharactersCount];
        int expressionAsArrayIndex = 0;

        String element = "";
        int startIndex = 0;
        int endIndex = 0;

        for(int expressionIndex = 1; expressionIndex < expression.length(); expressionIndex++) {

            for(int symbolIndex = 0; symbolIndex < symbols.length; symbolIndex++) {

                if(expression.charAt(expressionIndex) == symbols[symbolIndex]) {

                    endIndex = expressionIndex;

                    element = expression.substring(startIndex, endIndex);
                    expressionAsArray[expressionAsArrayIndex] = element;
                    expressionAsArrayIndex++;

                    element = String.valueOf(expression.charAt(expressionIndex));
                    expressionAsArray[expressionAsArrayIndex] = element;
                    expressionAsArrayIndex++;

                    startIndex = expressionIndex + 1;
                }
            }
        }
        element = expression.substring(startIndex);
        expressionAsArray[expressionAsArrayIndex] = element;

        return expressionAsArray;
    }

    private String[] calculateResult(String[] expressionAsArray, String symbol) {

        double firstNumber = 0;
        double secondNumber = 0;
        double result = 0;
        String resultAsString = "";

        // Calculating & Shefting
        for(int arrayIndex = 0; arrayIndex < expressionAsArray.length; arrayIndex++) {

            if(expressionAsArray[arrayIndex].equals(symbol)) {

                // Calculating
                firstNumber = Double.parseDouble(expressionAsArray[arrayIndex - 1]);
                secondNumber = Double.parseDouble(expressionAsArray[arrayIndex + 1]);

                if(symbol.equals("/")) {
                    result = firstNumber / secondNumber;
                }
                else if(symbol.equals("×")) {
                    result = firstNumber * secondNumber;
                }
                else if(symbol.equals("-")) {
                    result = firstNumber - secondNumber;
                }
                else if(symbol.equals("+")) {
                    result = firstNumber + secondNumber;
                }

                resultAsString = String.valueOf(result);
                expressionAsArray[arrayIndex - 1] = resultAsString;

                // Shifting
                for(int index = arrayIndex; index < expressionAsArray.length; index++) {

                    if(index < expressionAsArray.length - 2) {
                        expressionAsArray[index] = expressionAsArray[index + 2];
                    }
                    else {
                        expressionAsArray[index] = "null";
                    }
                }

                arrayIndex--;
            }
        }

        // Fetshing
        int expressionAsArrayLength = expressionAsArray.length;
        for(int arrayIndex = 0; arrayIndex < expressionAsArray.length; arrayIndex++) {

            if(expressionAsArray[arrayIndex].equals("null")) {

                expressionAsArrayLength = arrayIndex;
                break;
            }
        }

        String[] expressionAsArrayWithoutOperation = new String[expressionAsArrayLength];
        for(int arrayIndex = 0; arrayIndex < expressionAsArrayWithoutOperation.length; arrayIndex++) {
            expressionAsArrayWithoutOperation[arrayIndex] = expressionAsArray[arrayIndex];
        }

        return expressionAsArrayWithoutOperation;
    }

    private String formatResult(String result) {

        String formattedResult = result;
        if(formattedResult.endsWith(".0")) {
            formattedResult = formattedResult.substring(0, formattedResult.indexOf("."));
        }

        return formattedResult;
    }

    private void printArray(String[] array) {

        for(String element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

//    private int countExpressionElements(String expression) {
//
//        int expressionElementsCount = 0;
//        int counter = 0;
//
//        for(int expressionIndex = 1; expressionIndex < expression.length(); expressionIndex++) {
//
//            for(int symbolIndex = 0; symbolIndex < symbols.length; symbolIndex++) {
//
//                if(expression.charAt(expressionIndex) == symbols[symbolIndex]){
//                    counter++;
//                }
//            }
//        }
//
//        expressionElementsCount = counter * 2 + 1;
//        return expressionElementsCount;
//    }
//
//    private boolean hasSymbol(String[] expressionAsArray, String symbol){
//
//        for(int arrayIndex = 0; arrayIndex < expressionAsArray.length; arrayIndex++) {
//
//            if(expressionAsArray[arrayIndex].equals(symbol)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void shiftArrayElements(String[] array, int arrayIndex) {
//
//        for(int index = arrayIndex; index < array.length; index++) {
//
//            if(index < array.length - 2){
//                array[index] = array[index + 2];
//            }
//            else{
//                array[index] = "null";
//            }
//        }
//    }
//
//    private String[] fetchArrayElements(String[] expressionAsArray) {
//
//        int expressionAsArrayLength = expressionAsArray.length;
//        for(int arrayIndex = 0; arrayIndex < expressionAsArray.length; arrayIndex++) {
//
//            if(expressionAsArray[arrayIndex].equals("null")){
//
//                expressionAsArrayLength = arrayIndex;
//                break;
//            }
//        }
//
//        String[] expressionAsArrayWithoutOperation = new String[expressionAsArrayLength];
//        for(int arrayIndex = 0; arrayIndex < expressionAsArrayWithoutOperation.length; arrayIndex++) {
//            expressionAsArrayWithoutOperation[arrayIndex] = expressionAsArray[arrayIndex];
//        }
//
//        return expressionAsArrayWithoutOperation;
//    }
}
