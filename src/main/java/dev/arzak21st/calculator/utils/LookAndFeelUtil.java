package dev.arzak21st.calculator.utils;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.UIManager;

public class LookAndFeelUtil {

    public void setLookAndFeel() {

        try {

            FlatMacDarkLaf flatMacDarkLaf = new FlatMacDarkLaf();
            FlatDarkLaf flatDarkLaf = new FlatDarkLaf();
            String systemLookAndFeel = UIManager.getSystemLookAndFeelClassName();

            if(flatMacDarkLaf.isSupportedLookAndFeel()) {
                UIManager.setLookAndFeel(flatMacDarkLaf);
            }
            else if(flatDarkLaf.isSupportedLookAndFeel()) {
                UIManager.setLookAndFeel(flatDarkLaf);
            }
            else {
                UIManager.setLookAndFeel(systemLookAndFeel);
            }
        }
        catch(Exception exception) {
            ExceptionHandlingUtil.getException(exception);
        }
    }
}
