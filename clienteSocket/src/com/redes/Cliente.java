package com.redes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Conexion {


    public Cliente() throws IOException {
        super("cliente");} //Se usa el constructor para cliente de Conexion

    public void desconnectar() {
        try {
            clienteSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log( Level.SEVERE, null, ex);
        }
    }

    public void startClient() //Método para iniciar el cliente
    {
        Scanner scanner = new Scanner(System.in);
        String mensaje = "";
        String respuesta;
        Boolean permitir=true;
        int contador = 0; // borrar
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(clienteSocket.getOutputStream());

            // para recibir mensaje del servidor
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

            System.out.println("Cliente iniciado!\n");
            System.out.println(entrada.readLine());

            do {
                System.out.println("\nIngrese mensajito: ");
                mensaje = scanner.nextLine();
                if(mensaje.equalsIgnoreCase("X")){
                    System.out.println ( "Se ha desconectado" );
                    permitir=false;
                    desconnectar ();
                }
                else {
                    salidaServidor.writeUTF ( mensaje + "\n" );
                    System.out.println ( "Esperando respuesta..." );
                    respuesta=entrada.readLine ();
                    if(respuesta==null){
                        System.out.println ( "El servidor se ha desconectado" );
                        permitir=false;
                    }
                    else{
                        System.out.println (respuesta); // para recibir mensaje del servidor
                    }
                }

            }while (permitir);


            //clienteSocket.close();//Fin de la conexión

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
