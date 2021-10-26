/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ordson
 */
public class ToBody {

    public ToBody() {
    }

    
    
    public String convert (HttpServletRequest request) throws IOException {
                 BufferedReader reader = request.getReader();
        String body = "";
        String line = reader.readLine();
        while (line != null) {
            body = body + line;
            line  = reader.readLine();
        }
        return  body;
    }
}
