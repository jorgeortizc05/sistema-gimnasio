/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.casaortiz.view.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.casaortiz.view.FileLocation;

/**
 *
 * @author jorge
 */
public class CopiaSeguridadDB {
    
    public static void copiaSeguridad(JFrame main, String pathPgDump){
        // TODO add your handling code here:
        Runtime rt = Runtime.getRuntime();
        Process p;
        ProcessBuilder pb;
        rt = Runtime.getRuntime();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd-HHmmss");
        String fileBackup = FileLocation.pathBackupDB+"gimnasio"+ ft.format(new Date())+".backup";
        pb = new ProcessBuilder(
                pathPgDump,
                "--host", "localhost",
                "--port", "5432",
                "--username", "jorge",
                "--no-password",
                "--format", "custom",
                "--blobs",
                "--verbose", "--file", fileBackup, "gimnasio");
        try {
            final Map<String, String> env = pb.environment();
            env.put("PGPASSWORD", "jorge");
            p = pb.start();
            final BufferedReader r = new BufferedReader(
                    new InputStreamReader(p.getErrorStream()));
            String line = r.readLine();
            while (line != null) {
                System.err.println(line);
                line = r.readLine();
            }
            r.close();
            p.waitFor();
            System.out.println(p.exitValue());

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");
            int userSelection = fileChooser.showSaveDialog(main);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                Path in = Paths.get(fileBackup);
                Path path = Paths.get(fileToSave.getAbsolutePath()+ft.format(new Date())+".backup");
                CopyOption[] options = new CopyOption[] { StandardCopyOption.REPLACE_EXISTING,
				StandardCopyOption.COPY_ATTRIBUTES };
                Files.copy(in, path, options);
                JOptionPane.showMessageDialog(null, "Copia de seguridad fue satisfactorio");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
