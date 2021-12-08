/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jorge
 */
public class Images {
    
    /**
     * Carga imagenes de la carpeta photos/persona
     * @param name ej: 0105183795.png
     * @return obj ImageIcon
     */
    public ImageIcon getImage(String name) {
        String string = FileLocation.pathImagePerson + name;
        Image img = new ImageIcon(string).getImage();
            //Me permite redimensionar la imagen para que se adapte al jLabel
        ImageIcon ii = new ImageIcon(img.getScaledInstance(400, 300, Image.SCALE_SMOOTH));
        return ii;
    }
    
    /**
     * Carga Imágenes del producto
     * @param name - ruta absoluta de la imagen fuente
     * @param _lblFoto - para mostrar la imagen en un label 
     */
    public static void loadImageSrc(String name, JLabel _lblFoto) {

        try {
            String string = name;
            
            Image img = new ImageIcon(string).getImage();
            
            //Me permite redimensionar la imagen para que se adapte al jLabel
            ImageIcon ii = new ImageIcon(img.getScaledInstance(400, 300, Image.SCALE_SMOOTH));

            _lblFoto.setIcon(ii);
            _lblFoto.validate();
            _lblFoto.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Realiza una copia de un archivo
     * @param src - Fuente del archivo
     * @param dest - A donde va a copiar, su destino
     */
    public static void copyImages(File src, File dest){
        try {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
              out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Images.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(Images.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Obtengo imagen de las personas pero con resolucion 640 x 480
     * @param name - ej: 01051827385.png
     * @return ImageIcon - Objeto Imagen icon
     */
    public ImageIcon getImageForCheckSuscription(String name) {
        String string = FileLocation.pathImagePerson + name;
        Image img = new ImageIcon(string).getImage();
            //Me permite redimensionar la imagen para que se adapte al jLabel
        ImageIcon ii = new ImageIcon(img.getScaledInstance(640, 480, Image.SCALE_SMOOTH));
        return ii;
    }
    
    //Para mostrar publicidad en el checkSuscription
    public ImageIcon addIconForAdvertising(String pathIcon){
        ImageIcon iconBtn = loadImageIconForAdvertising(pathIcon);
        return iconBtn;
    }
    
    private ImageIcon loadImageIconForAdvertising(String path) {
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
