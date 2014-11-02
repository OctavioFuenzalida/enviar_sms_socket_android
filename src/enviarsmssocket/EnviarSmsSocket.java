/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enviarsmssocket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author ofuenzalida
 */
public class EnviarSmsSocket
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket("192.168.0.90", 2180);
        try
        {
            for (int i = 1; i < 11; i++)
            {
                StringBuilder msg = new StringBuilder();
                msg.append(i + " un nuevo mensaje SMS ").append("Prueba desde JAVA SOCKET :D").append(". ");
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                String mensaje = "73389295" + ";;" + msg.toString();
                out.println(mensaje);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        socket.close();
    }

}
