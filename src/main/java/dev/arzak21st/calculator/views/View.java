package dev.arzak21st.calculator.views;

import dev.arzak21st.calculator.controllers.ViewController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class View extends JFrame implements ActionListener {

    ViewController viewController = new ViewController();

    char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] symbols = {'.', '+', '-', '×', '/'};

    JButton[] buttons;

    public View() {

        initComponents();

        buttons = new JButton[] {
            zeroButton,
            oneButton, twoButton, threeButton,
            fourButton, fiveButton, sixButton,
            sevenButton, eightButton, nineButton,
            dotButton,
            addButton, subtractButton, multiplyButton, divideButton,
            equalButton,
            resetButton, backButton
        };
        setActionListeners(buttons);
    }

    private void setActionListeners(JButton[] buttons) {

        for(JButton button : buttons) {
            button.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String value = event.getActionCommand();

        // Check if value is a number (0 1 2 ...)
        for(char number : numbers) {

            if(number == value.charAt(0)) {

                viewController.printNumber(number, textField);
                return;
            }
        }

        // Check if value is a symbol (+ - × / .)
        for(char symbol : symbols) {

            if(symbol == value.charAt(0)) {

                viewController.printSymbol(symbol, textField);
                return;
            }
        }

        // Check if value is "Back"
        if(value.equals("Back")) {

            viewController.back(textField);
            return;
        }

        // Check if value is "Reset"
        if(value.equals("Reset")) {

            viewController.reset(textField);
            return;
        }
        
        // Check if value is the equal symbol (=)
        if(value.equals("=")) {

            viewController.getResult(textField);
            return;
        }
    }

    /* ==================== IDE Generated Code ==================== */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uiPanel = new javax.swing.JPanel();
        textField = new javax.swing.JTextField();
        resetButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        equalButton = new javax.swing.JButton();
        divideButton = new javax.swing.JButton();
        multiplyButton = new javax.swing.JButton();
        subtractButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        dotButton = new javax.swing.JButton();
        zeroButton = new javax.swing.JButton();
        oneButton = new javax.swing.JButton();
        twoButton = new javax.swing.JButton();
        threeButton = new javax.swing.JButton();
        fourButton = new javax.swing.JButton();
        fiveButton = new javax.swing.JButton();
        sixButton = new javax.swing.JButton();
        sevenButton = new javax.swing.JButton();
        eightButton = new javax.swing.JButton();
        nineButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator App");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setResizable(false);

        textField.setEditable(false);
        textField.setFont(new java.awt.Font("Consolas", 1, 21)); // NOI18N
        textField.setToolTipText("Input/Output");

        resetButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        resetButton.setText("Reset");

        backButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        backButton.setText("Back");

        equalButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        equalButton.setText("=");

        divideButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        divideButton.setText("/");

        multiplyButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        multiplyButton.setText("×");

        subtractButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        subtractButton.setText("-");

        addButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        addButton.setText("+");

        dotButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        dotButton.setText(".");

        zeroButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        zeroButton.setText("0");

        oneButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        oneButton.setText("1");

        twoButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        twoButton.setText("2");

        threeButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        threeButton.setText("3");

        fourButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        fourButton.setText("4");

        fiveButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        fiveButton.setText("5");

        sixButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        sixButton.setText("6");

        sevenButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        sevenButton.setText("7");

        eightButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        eightButton.setText("8");

        nineButton.setFont(new java.awt.Font("Dialog", 1, 21)); // NOI18N
        nineButton.setText("9");

        javax.swing.GroupLayout uiPanelLayout = new javax.swing.GroupLayout(uiPanel);
        uiPanel.setLayout(uiPanelLayout);
        uiPanelLayout.setHorizontalGroup(
            uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(equalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, uiPanelLayout.createSequentialGroup()
                        .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(uiPanelLayout.createSequentialGroup()
                                .addComponent(zeroButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(uiPanelLayout.createSequentialGroup()
                                .addComponent(fourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sixButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(uiPanelLayout.createSequentialGroup()
                                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(uiPanelLayout.createSequentialGroup()
                                        .addComponent(oneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(twoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(threeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(uiPanelLayout.createSequentialGroup()
                                        .addComponent(sevenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(eightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subtractButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(multiplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(divideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        uiPanelLayout.setVerticalGroup(
            uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sevenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtractButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(multiplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(uiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(divideButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dotButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zeroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(equalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(uiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(uiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addButton;
    public javax.swing.JButton backButton;
    public javax.swing.JButton divideButton;
    public javax.swing.JButton dotButton;
    public javax.swing.JButton eightButton;
    public javax.swing.JButton equalButton;
    public javax.swing.JButton fiveButton;
    public javax.swing.JButton fourButton;
    public javax.swing.JButton multiplyButton;
    public javax.swing.JButton nineButton;
    public javax.swing.JButton oneButton;
    public javax.swing.JButton resetButton;
    public javax.swing.JButton sevenButton;
    public javax.swing.JButton sixButton;
    public javax.swing.JButton subtractButton;
    public javax.swing.JTextField textField;
    public javax.swing.JButton threeButton;
    public javax.swing.JButton twoButton;
    public javax.swing.JPanel uiPanel;
    public javax.swing.JButton zeroButton;
    // End of variables declaration//GEN-END:variables
}
