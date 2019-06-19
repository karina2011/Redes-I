package com.redes;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// servidor usando threads para poder recibir multiples clientes
public class ServidorHilo extends Thread {
    private Socket socket;
    private DataOutputStream bufferSalida;
    private DataInputStream bufferEntrada;
    private int idSession;

    public ServidorHilo(Socket socket, int id) {
        this.socket = socket;
        this.idSession = id;
        try {
            bufferSalida = new DataOutputStream(socket.getOutputStream());
            bufferEntrada = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void desconnectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() {
        String accion = "";
        Boolean permitir=true;
        String respuesta = "";
        Scanner scanner = new Scanner(System.in);
        try {
            bufferSalida.writeUTF("Conectado al servidor!...ingrese mensaje:\n"); // bufferSalida = salidaCliente
            //Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while((permitir)&&((accion = entrada.readLine()) != null)) //Mientras haya mensajes desde el cliente
            {
                //Se muestra por pantalla el mensaje recibido
                System.out.println("[Cliente " + this.idSession +"]: " + accion + "\n");

                System.out.println ( "Ingrese respuesta para cliente " + this.idSession + ": " );
                respuesta = scanner.nextLine ();
                if (respuesta.equalsIgnoreCase ( "x" )) {
                    System.out.println ( "\n Ha descoectado al servidor" );
                    desconnectar ();
                    permitir = false;
                } else {
                     bufferSalida.writeUTF ( "[Server]: " + respuesta + "\n" );
                    }
            }
            if (accion==null){
                System.out.println ( "el cliente se ha desconectado\n" );
            }

            //accion = bufferEntrada.readUTF();

        } catch (IOException ex) {
            Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        desconnectar();
    }
}