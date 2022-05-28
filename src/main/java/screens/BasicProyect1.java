package screens;

import javax.swing.JOptionPane;

public class BasicProyect1 {

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Ingrese su Nombre");
        String condicion = frmMainScreen.validatorName(name);
        frmMainScreen view = new frmMainScreen(name);

        if (condicion.equals("")) {
            view.setVisible(true);
            view.setResizable(false);
            view.setLocationRelativeTo(null);

        } else {
            JOptionPane.showMessageDialog(null, condicion, "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            main(args);
        }

    }
}
