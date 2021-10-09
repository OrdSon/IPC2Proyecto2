package Utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImgCatcher {

    public FileInputStream catchImg(String path) throws SQLException {
        FileInputStream fis = null;
        try {
            File image = new File(path);
            fis = new FileInputStream(image);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImgCatcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fis;
    }
}
