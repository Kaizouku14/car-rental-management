package Utils;

import javax.swing.JFrame;

public class CurrentFormHolder {
    private static CurrentFormHolder instance;
    private JFrame currentForm;

    private CurrentFormHolder() {
        // Private constructor to prevent instantiation from outside
    }

    public static CurrentFormHolder getInstance() {
        if (instance == null) {
            instance = new CurrentFormHolder();
        }
        return instance;
    }

    public void setCurrentForm(JFrame form) {
        this.currentForm = form;
    }

    public JFrame getCurrentForm() {
        return currentForm;
    }

    public void closeCurrentForm() {
        if (currentForm != null) {
            currentForm.dispose(); // Close the current form
        }
    }
}

