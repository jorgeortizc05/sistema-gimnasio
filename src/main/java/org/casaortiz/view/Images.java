/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author jorge
 */
public class Images {

    public ImageIcon getImage(String name) {
        String string = FileLocation.pathImagePerson + name;
        Image img = new ImageIcon(string).getImage();
            //Me permite redimensionar la imagen para que se adapte al jLabel
        ImageIcon ii = new ImageIcon(img.getScaledInstance(400, 300, Image.SCALE_SMOOTH));
        return ii;
    }
    
    public ImageIcon getImageForCheckSuscription(String name) {
        String string = FileLocation.pathImagePerson + name;
        Image img = new ImageIcon(string).getImage();
            //Me permite redimensionar la imagen para que se adapte al jLabel
        ImageIcon ii = new ImageIcon(img.getScaledInstance(640, 480, Image.SCALE_SMOOTH));
        return ii;
    }
    
    //Para mostrar publicidad en el checkSuscription
    public ImageIcon addIconForAdvertising(String pathIcon){
        ImageIcon iconBtn = createImageIconForAdvertising(pathIcon);
        return iconBtn;
    }
    
    private ImageIcon createImageIconForAdvertising(String path) {
        URL imgURL = getClass().getResource(path);

        if (imgURL != null) {
            Image img = new ImageIcon(imgURL).getImage();
            return new ImageIcon(img.getScaledInstance(640, 480, Image.SCALE_SMOOTH));
        } else {
            System.err.println("Couldn't find file: " + path);
            System.out.println("imgURL = " + imgURL.getPath());
            return null;
        }
    }
}
