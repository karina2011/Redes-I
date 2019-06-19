package com.redes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Conexion {

    private Integer PUERTO = 3000; //Puerto para la conexión
    private String HOST = "localhost"; //Host para la conexión
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket serverSocket; //Socket del servidor
    protected Socket clienteSocket; //Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida

    public Conexion(String tipo) throws IOException //Constructor
    {
        if(tipo.equalsIgnoreCase("servidor"))
        {
            serverSocket = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 1234
            clienteSocket = new Socket(); //Socket para el cliente
        }
        else
        {
            System.out.println("Ingrese el numero de ip(host): ");
            Scanner scanner = new Scanner(System.in);
            HOST = scanner.nextLine();

            System.out.println("\nIngrese el numero de puerto que desea utulizar: ");
            PUERTO = scanner.nextInt();
            System.out.println("Creando socket...");
            clienteSocket = new Socket(HOST, PUERTO); //Socket para el cliente en el host y puerto indicado
            System.out.println("\nSocket creado!");
        }
    }
}
