package util;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Util {
    
    
    public static void inzCombo(String[] arreglo, JComboBox cbx){
        
        cbx.removeAllItems();
        
        for(String item : arreglo){
            
            cbx.addItem(item);
            
        }
        
    }
    
    public static void mensaje(String msg, String title, int tipo) {

        JOptionPane.showMessageDialog(null, msg, title, tipo);

    }
    
    
}
