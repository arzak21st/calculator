package dev.arzak21st.calculator;

import dev.arzak21st.calculator.utils.LookAndFeelUtil;
import dev.arzak21st.calculator.views.View;

public class Main {

    public static void main(String[] args) {

        new LookAndFeelUtil().setLookAndFeel();
        new View().setVisible(true);
    }
}
