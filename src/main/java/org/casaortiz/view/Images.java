/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jorge
 */
public class Images {
    
    public static ImageIcon getImage(String name){
        try {
            String string = FileLocation.pathImage + name;
            Image img = new ImageIcon(string).getImage();
            //Me permite redimensionar la imagen para que se adapte al jLabel
            ImageIcon ii = new ImageIcon(img.getScaledInstance(400, 300, Image.SCALE_SMOOTH));
            return ii;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
