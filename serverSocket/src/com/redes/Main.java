package com.redes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

// https://www.programarya.com/Cursos-Avanzados/Java/Sockets
//http://codigoprogramacion.com/cursos/java/103-sockets-en-java-con-cliente-y-servidor.html#.XPWv6rh7m1t
//https://www.solvetic.com/tutoriales/article/2657-como-abrir-o-cerrar-un-puerto-con-el-firewall-en-windows-10/ -->
// creo que es para esto: g) Verificar que el firewall tenga en inbound rules los permisos correctos para la entrada y salida de data.

// https://rootear.com/windows/activa-telnet-w10
//https://www.programacion.com.py/escritorio/java-escritorio/sockets-en-java-udp-y-tcp // socket tcp y sockets udp// diferencias
//http://www.webtutoriales.com/articulos/comunicacion-entre-un-servidor-y-multiples-clientes // este proyecto esta hecho con este
public class Main {

    public static void main(String[] args) {

        ServerSocket ss;
        System.out.print("Inicializando servidor... ");
        try {
            ss = new ServerSocket(3000);
            System.out.println("\t[OK]");
            int idSession = 0;
            while (true) {
                Socket socket;
                socket = ss.accept();
                System.out.println("Nueva conexión entrante: "+socket);
                ((ServidorHilo) new ServidorHilo(socket, idSession)).start();
                idSession++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    // lo q hace este proyecto es levantar el servidor, que se levanta en el puerto 3000 y espera una conexion
    // esta conexion puede ser del telnet, ( que emula un cliente) , o del otro proyecto clienteSocket, que es el cliente real


}
