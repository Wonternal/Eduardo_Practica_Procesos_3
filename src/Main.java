import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    //Ruta al bash que deseemos usar. En este caso Git Bash porque permite comandos de linux en Windows
    public static final String path_bash = "C:/Program Files/Git/git-bash.exe";

    public static void main(String[] args) {
        /*
         * 3- Desarrolla una tercera aplicación en Java que reciba como entrada una ruta a un fichero del
         * sistema. Tu programa debe abrir el fichero, si existe, utilizando el comando cat y enviar la salida a la
         * entrada del comando wc, que se utiliza para contar las líneas de un fichero. (4 puntos)
         */

        // Página con información relacionada al ejercicio.  (Fuentes)
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/ProcessBuilder.html
        // https://stackoverflow.com/questions/53189986/open-git-bash-using-processbuilder-and-execute-command-in-it
        // https://stackoverflow.com/questions/3776195/using-java-processbuilder-to-execute-a-piped-command

        // Configuramos un pb
        ProcessBuilder pb = new ProcessBuilder();
        pb.directory(new File("."));
        pb.command(path_bash, "-c", "cat prueba.txt | wc > wcResult.txt");

        try {

            // Iniciamos el proceso
            pb.start();

            //Esperamos a que se cree el archivo con un sleep de 2 segundos
            Thread.sleep(2000);

            //Leemos el archivo con el resultado del comando ejecutado por pb
            FileReader fileReader = new FileReader("wcResult.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println("Resultado del comando ejecutado -> " + bufferedReader.readLine());

        } catch (IOException | InterruptedException err) {
            err.printStackTrace();
        }

    }
}
