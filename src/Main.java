import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        String palabraSecreta = obtenerPalabra();
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < palabraSecreta.length(); i++) {
            letrasAdivinadas[i] = '_';
        }

        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar" + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            System.out.println("Introduce una letra, por favor");
            char letra = Character.toLowerCase(escaner.next().charAt(0)); //solo toma la primera letra de una palabra

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("!Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos.");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("Felicidades, has adivinado la palabra secreta: " + palabraSecreta);
            }

        }

        if (!palabraAdivinada){
            System.out.println("Que pena, te has quedado sin intentos. La palabra era: **** " + palabraSecreta + " ****");
        }

        escaner.close();
    }



    private static String obtenerPalabra(){
        String[] palabras = {"casa", "perro", "gato", "amarillo", "azul", "rojo", "sol", "luna", "agua", "arbol", "ciudad", "libro", "amigo", "familia", "comida", "jugar", "trabajar", "aprender", "cantar", "bailar"};
        int indiceRandom = new Random().nextInt(palabras.length);
        return palabras[indiceRandom];
    }
}