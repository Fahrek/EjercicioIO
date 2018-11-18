package ejemploio;

import java.io.*;

public class EjemploIO implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Escribir el contenido de un objeto serializado en un archivo
        Persona p1 = new Persona();
        p1.setNombre("Andres");
        p1.setApellidos("Garcia Quina");

        FileOutputStream archivo1 = new FileOutputStream("objeto.dat");
        ObjectOutputStream salida = new ObjectOutputStream(archivo1);
        salida.writeObject(p1);
        salida.close();

        FileInputStream archivo2 = new FileInputStream("objeto.dat");
        ObjectInputStream entrada = new ObjectInputStream(archivo2);
        Persona recuperada = new Persona();
        recuperada = (Persona) entrada.readObject();
        System.out.println(recuperada.getNombre());
        entrada.close();

        // Proyeccion de directorios
        File fichero = new File(".");
        File[] directorio = fichero.listFiles();
        for (File directorio1 : directorio) {
            if (directorio1.isDirectory()) {
                System.out.println("-> " + directorio1.getName());
            }
            if (directorio1.isFile()) {
                System.out.print("--- " + directorio1.getName() + " | Tamaño: " + directorio1.length());
                System.out.println();
            }
        }

        // Entrada por teclado
        InputStreamReader teclado = new InputStreamReader(System.in);
        BufferedReader br1 = new BufferedReader(teclado);
        String aux;
        aux = br1.readLine();
        System.out.println("Ha leido: " + aux + "\n\n");

        String filename = "salidafichero2.txt";

        FileWriter w2 = new FileWriter(filename);
        w2.write("Hola linea 1\nLinea 2\nLinea 3\n6\n\n");
        w2.close();

        FileReader lector = new FileReader("salidafichero2.txt");
        BufferedReader br = new BufferedReader(lector);
        String cadena = br.readLine();
        System.out.println(cadena);
        while (cadena != null) {
            System.out.println(cadena);
            cadena = br.readLine();
        }

        // Escritura en memoria
        String cadenadetexto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n Duis eget bibendum neque. Mauris et ligula sollicitudin, congue leo eu, bibendum tellus. Morbi eget egestas nunc.\n Aenean malesuada arcu nec nulla laoreet, vel consectetur neque pulvinar. Morbi eget nulla consectetur, mattis mi nec, tempor felis.\n Nam volutpat ut nisi quis dictum. Maecenas orci lectus, ornare et lectus et, hendrerit ultricies metus.\n\n";
        StringWriter w1;
        try {
            // Abriendo el flujo de datos
            w1 = new StringWriter();
            // Trabajando con el flujo de datos
            w1.write("Hola estoy escribiendo en este archivo\n");
            w1.write("Hola estoy escribiendo en otra linea\n");
            w1.write("Estoy escribiendo en la tercera linea\n\n");
            // Cerrar el flujo
            w1.close();
        } catch (IOException e) {
            System.out.println("No se ha podido Leer/Escribir en el archivo");
        }

        // Escritura de fichero
        String nombrearchivo = "salidafichero1.txt";
        FileWriter writer;
        try {
            // Abriendo el flujo de datos
            writer = new FileWriter(nombrearchivo);
            // Trabajando con el flujo de datos
            writer.write("Hola estoy escribiendo en este archivo\n");
            writer.write("Hola estoy escribiendo en otra linea\n");
            writer.write("Estoy escribiendo en la tercera linea\n\n");
            // Cerrar el flujo
            writer.close();
        } catch (IOException e) {
            System.out.println("No se ha podido Leer/Escribir en el archivo");
        }

        // Lectura de memoria
        StringReader r1;
        try {
            r1 = new StringReader(cadenadetexto);
            int caracter;
            caracter = r1.read();
            while (caracter != -1) {
                System.out.print((char) caracter);
                caracter = r1.read();
            }
            r1.close();
        } catch (IOException e) {
            System.out.println("No se ha podido Leer/Escribir en el archivo");
        }

        // Lectura de fichero
        FileReader reader;
        try {
            reader = new FileReader(nombrearchivo);
            int caracter;
            caracter = reader.read();
            while (caracter != -1) {
                if ((char) caracter == 'e') {
                    System.out.println("He encontrado la letra 'e'");
                }
                System.out.print((char) caracter);
                caracter = reader.read();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("No se ha podido Leer/Escribir en el archivo");
        }
    }
}
