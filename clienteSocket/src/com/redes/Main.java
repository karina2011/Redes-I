package com.redes;

import java.io.IOException;

// https://www.programarya.com/Cursos-Avanzados/Java/Sockets // este proyecto esta hecho con este
//http://codigoprogramacion.com/cursos/java/103-sockets-en-java-con-cliente-y-servidor.html#.XPWv6rh7m1t
//https://www.solvetic.com/tutoriales/article/2657-como-abrir-o-cerrar-un-puerto-con-el-firewall-en-windows-10/
// https://rootear.com/windows/activa-telnet-w10
public class Main {

    public static void main(String[] args) {


        iniciarCliente();


        /// el cliente y el servidor son 2 proyectos separados, ambos se corren al mismo tiempo
        // en la consola del cliente (este) se debe ingresar por teclado el IP (localhost) y el puerto (3000)
        //ejemplo: ingrese IP:
        // hay q hacer el metodo para que pueda ingresarlo por teclado: fijarse el constructor del cliente ?
    }

    public static void iniciarCliente(){
        Cliente cli = null; //Se crea el cliente
        try {
            cli = new Cliente();
            System.out.println("\nIniciando cliente\n");
            cli.startClient(); //Se inicia el cliente
        } catch (IOException e) {
            System.out.println("ERROR CON EL IP O EL PUERTO INGRESADO. VUELVA A INTENTAR");
            iniciarCliente();

        }

    }
}
