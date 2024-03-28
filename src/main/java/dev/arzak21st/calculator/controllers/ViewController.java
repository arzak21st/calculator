package dev.arzak21st.calculator.controllers;

import dev.arzak21st.calculator.services.CalculationService;
import dev.arzak21st.calculator.services.ValidationService;
import javax.swing.JTextField;

public class ViewController {

    ValidationService validationService = new ValidationService();
    CalculationService calculationService = new CalculationService();

    String expression;

    boolean numberIsAllowed;
    boolean symbolIsAllowed;

    int expressionElementsCount;
    String filteredExpression;
    String result;

    public void printNumber(char number, JTextField textField) {

        expression = textField.getText();

        numberIsAllowed = validationService.numberIsAllowed(expression);
        if(numberIsAllowed) {
            textField.setText(expression + number);
        }
    }

    public void printSymbol(char symbol, JTextField textField) {

        expression = textField.getText();

        symbolIsAllowed = validationService.symbolIsAllowed(expression, symbol);
        if(symbolIsAllowed) { // Allowed
            textField.setText(expression + symbol);
        }
        else { // Allowed in specific conditions

            if(expression.length() > 1) { // If there is a symbol after the last number (Ex: 1+)

                boolean expressionContainsLetter = validationService.expressionContainsLetter(expression);
                if(!expressionContainsLetter) {

                    if(symbol != '.') { // If the symbol is + or - or × or /

                        back(textField); // Remove that symbol after the last number (Ex: 1)
                        expression = textField.getText();
                        textField.setText(expression + symbol); // and replace it with the new symbol (Ex: 1-)
                    }
                }
            }
        }
    }

    public void back(JTextField textField) {

        expression = textField.getText();
        if(!expression.equals("")) {
            textField.setText(expression.substring(0, expression.length() - 1));
        }
    }

    public void reset(JTextField textField) {

        expression = textField.getText();
        if(!expression.equals("")) {
            textField.setText("");
        }
    }

    public void getResult(JTextField textField) {

        expression = textField.getText();
        if(!expression.equals("")) {

            filteredExpression = validationService.filterExpression(expression);
            expressionElementsCount = validationService.countExpressionElements(filteredExpression); // Ex: -111+22/3 has 5 elements ('-111' '+' '22' '/' '3')

            if(expressionElementsCount > 2) {

                result = calculationService.getResult(filteredExpression, expressionElementsCount);
                textField.setText(result);
            }
            else {

                result = filteredExpression;
                textField.setText(result);
            }
        }
    }
}
