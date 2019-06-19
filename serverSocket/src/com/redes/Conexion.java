package com.redes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {

    private final int PUERTO = 3000; //Puerto para la conexión
    private final String HOST = "localhost"; //Host para la conexión
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket serverSocket; //Socket del servidor
    protected Socket clienteSocket; //Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida

    public Conexion(String tipo) throws IOException //Constructor
    {
        if(tipo.equalsIgnoreCase("servidor"))
        {
            serverSocket = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 3000
            clienteSocket = new Socket(); //Socket para el cliente
        }
        else
        {
            clienteSocket = new Socket(HOST, PUERTO); //Socket para el cliente en localhost en puerto 3000
        }
    }
}
