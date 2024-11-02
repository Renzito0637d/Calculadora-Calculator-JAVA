package Main;

import Controller.*;
import View.UI_Basic;

/**
 *
 * @author Renzo
 */
public class Main {

    public static UI_Basic bc;
    public static BasicController ctrl;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        bc = new UI_Basic();
        ctrl=new BasicController(bc);
        
    }
    
}
