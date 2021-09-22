/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view.components;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author jorge
 */
public class ButtonsColors {
    
    public ImageIcon addIconButton(String pathIcon){
        ImageIcon iconBtn = createImageIcon(pathIcon);
        return iconBtn;
    }
    
    private ImageIcon createImageIcon(String path) {
        URL imgURL = getClass().getResource(path);

        if (imgURL != null) {
            Image img = new ImageIcon(imgURL).getImage();
            return new ImageIcon(img.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        } else {
            System.err.println("Couldn't find file: " + path);
            System.out.println("imgURL = " + imgURL.getPath());
            return null;
        }
    }
    
}
