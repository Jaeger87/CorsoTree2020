import java.util.Random;
import java.util.Scanner;

public class Labyrinth {

    public static void printaMatrice(char[][] labyrinth) {
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++)
                System.out.print(labyrinth[i][j]);
            System.out.println();
        }

    }

    public static boolean muoviGiocatore(char[][] labyrinth, char mossa) {
        int[] posizioneGiocatore = trovaGiocatore(labyrinth);
        int xP = posizioneGiocatore[1];
        int yP = posizioneGiocatore[0];
        switch (mossa) {
            case 'W':
                if (yP - 1 < 0 || labyrinth[yP - 1][xP] == 'W')
                    return false;
                labyrinth[yP][xP] = '-';
                labyrinth[yP - 1][xP] = 'P';
                break;
            case 'A':
                if (xP - 1 < 0 || labyrinth[yP][xP - 1] == 'W')
                    return false;
                labyrinth[yP][xP] = '-';
                labyrinth[yP][xP - 1] = 'P';
                break;
            case 'S':
                if (yP + 1 >= labyrinth.length || labyrinth[yP + 1][xP] == 'W')
                    return false;
                labyrinth[yP][xP] = '-';
                labyrinth[yP + 1][xP] = 'P';
                break;
            case 'D':
                if (xP + 1 >= labyrinth[0].length || labyrinth[yP][xP + 1] == 'W')
                    return false;
                labyrinth[yP][xP] = '-';
                labyrinth[yP][xP + 1] = 'P';
                break;
            default:
                return false;

        }
        return true;
    }

    public static boolean checkPlayerWin(char[][] labyrinth) {
        for (int i = 0; i < labyrinth.length; i++)
            for (int j = 0; j < labyrinth[0].length; j++)
                if (labyrinth[i][j] == 'E')
                    return false;
        return true;
    }

    public static int[] trovaGiocatore(char[][] labyrinth) {
        int[] posizione = new int[2];
        for (int i = 0; i < labyrinth.length; i++)
            for (int j = 0; j < labyrinth[0].length; j++)
                if (labyrinth[i][j] == 'P') {
                    posizione[0] = i;
                    posizione[1] = j;
                    break;
                }
        return posizione;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        /*
        char[][] labyrinth = new char[5][5];

        for (int i = 0; i < labyrinth.length; i++)
            for (int j = 0; j < labyrinth[0].length; j++)
                labyrinth[i][j] = '-';

        labyrinth[0][2] = 'W';
        labyrinth[0][3] = 'W';
        labyrinth[1][1] = 'W';
        labyrinth[1][3] = 'W';
        labyrinth[2][0] = 'P';
        labyrinth[2][1] = 'W';
        labyrinth[2][3] = 'W';
        labyrinth[2][4] = 'W';
        labyrinth[3][2] = 'W';
        labyrinth[3][4] = 'E';
        labyrinth[4][0] = 'W';
        labyrinth[4][4] = 'W';

         */

        char[][] labyrinth = generaLabirintoRandom(5,8);
        printaMatrice(labyrinth);

        while (true) {
            char mossa = reader.next().charAt(0);
            muoviGiocatore(labyrinth, mossa);
            printaMatrice(labyrinth);
            if(checkPlayerWin(labyrinth))
                break;
        }

        System.out.println("Hai vinto!");
    }


    public static char[][] generaLabirintoRandom(int rows, int columns) // Non è detto sia risolvibile
    {
        Random random = new Random();
        char[][] labyrinth = new char[rows][columns];
        for (int i = 0; i < labyrinth.length; i++)
            for (int j = 0; j < labyrinth[0].length; j++)
                labyrinth[i][j] = '-';

        int pRow = random.nextInt(rows);
        int eRow = random.nextInt(rows);

        labyrinth[pRow][0] = 'P';
        labyrinth[eRow][columns - 1] = 'E';

        for (int i = 0; i < labyrinth.length; i++)
            for (int j = 0; j < labyrinth[0].length; j++)
            {
                if(labyrinth[i][j] != '-')
                    continue;
                int prob = random.nextInt(10);
                if (prob <= 2)
                    labyrinth[i][j] = 'W';
            }

        return labyrinth;
    }

}
