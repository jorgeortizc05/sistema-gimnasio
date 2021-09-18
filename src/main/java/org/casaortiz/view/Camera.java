/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.imageio.ImageIO;

/**
 *
 * @author jorge
 */
public class Camera {
    private Executor executor = Executors.newSingleThreadExecutor();
    private AtomicBoolean initialized = new AtomicBoolean(false);
   
    public static void takePhoto(BufferedImage image, String nameFile) throws IOException{
        ImageIO.write(image, "PNG", new File(FileLocation.pathImagePerson + nameFile + ".png"));
    }
    
    public void cameraOff(){
        
    }
}
