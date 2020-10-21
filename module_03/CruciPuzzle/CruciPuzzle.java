public class CruciPuzzle {


    public static void printaMatrice(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                if(j < matrix[0].length - 1)
                    System.out.print("" + matrix[i][j] + '-');
                else
                    System.out.print(matrix[i][j]);
            System.out.println();
        }

    }

    public static boolean trovaParola(char[][] puzzle, String parola) {
        parola = parola.toUpperCase();
        for (int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle[0].length; col++) {
                if (puzzle[row][col] != parola.charAt(0))
                    continue;
                if (verificaParola(puzzle, parola, row, col, 1, 0)) //Controllo orizzontale
                    return true;
                if (verificaParola(puzzle, parola, row, col,  -1, 0)) //Controllo orizzontale contrario
                    return true;
                if (verificaParola(puzzle, parola, row, col,  0, 1)) //Controllo verticale
                    return true;
                if (verificaParola(puzzle, parola, row, col,  0, -1)) //Controllo verticale contrario
                    return true;
                if (verificaParola(puzzle, parola, row, col,  -1, -1)) //Controllo diagonale SinistraSopra
                    return true;
                if (verificaParola(puzzle, parola, row, col,  1, -1)) //Controllo diagonale DestraSopra
                    return true;
                if (verificaParola(puzzle, parola, row, col,  -1, 1)) //Controllo diagonale SinistraGiù
                    return true;
                if (verificaParola(puzzle, parola, row, col,  1, 1)) //Controllo diagonale DestraGiù
                    return true;
            }

        }
        return false;
    }

    public static boolean verificaParola(char[][] puzzle, String parola, int startRow, int startCol, int incRow, int incCol)
    {
        for(int charIndex = 1; charIndex < parola.length(); charIndex++) {
            int rowToCheck = startRow + charIndex * incRow;
            if (rowToCheck < 0 || rowToCheck >= puzzle.length)
                return false;
            int colToCheck = startCol + charIndex * incCol;
            if (colToCheck < 0 || colToCheck >= puzzle[0].length)
                return false;
            if(puzzle[rowToCheck][colToCheck] != parola.charAt(charIndex))
                return false;
        }

        char[][] puzzleSolved = new char[puzzle.length][puzzle[0].length];

        for (int row = 0; row < puzzleSolved.length; row++)
            for (int col = 0; col < puzzleSolved[0].length; col++)
                puzzleSolved[row][col] = '⬜';

        for(int charIndex = 0; charIndex < parola.length(); charIndex++) {
            int row = startRow + charIndex * incRow;
            int col = startCol + charIndex * incCol;
            puzzleSolved[row][col] = parola.charAt(charIndex);
        }
        printaMatrice(puzzleSolved);
        return true;
    }


    public static void main(String[] args) {
        char[][] puzzle = {{'H','D','G','U','P','Y','S','P','A','O'},
                {'T','S','A','K','O','Y','O','L','P','S'},
                {'R','C','M','C','N','R','I','A','A','B'},
                {'I','O','B','A','I','S','C','T','L','A'},
                {'G','R','E','L','F','A','C','E','O','L'},
                {'L','F','R','A','L','L','U','S','I','E'},
                {'I','A','E','M','E','M','L','S','L','N'},
                {'A','N','T','A','D','O','C','A','G','A'},
                {'J','O','T','R','B','N','D','G','O','D'},
                {'L','Y','O','O','U','E','S','M','S','M'}};

        printaMatrice(puzzle);

        System.out.println(trovaParola(puzzle, "LUCCIO"));
        System.out.println(trovaParola(puzzle, "CALAMARO"));
        System.out.println(trovaParola(puzzle, "SOGLIOLA"));
        System.out.println(trovaParola(puzzle, "PLATESSA"));
        System.out.println(trovaParola(puzzle, "DELFINO"));
        System.out.println(trovaParola(puzzle, "GAMBERETTO"));
        System.out.println(trovaParola(puzzle, "SCORFANO"));
        System.out.println(trovaParola(puzzle, "SALMONE"));
        System.out.println(trovaParola(puzzle, "BALENA"));
        System.out.println(trovaParola(puzzle, "TRIGLIA"));
        System.out.println(trovaParola(puzzle, "EBAEFG"));
        System.out.println(trovaParola(puzzle, "GOMKP"));
        System.out.println(trovaParola(puzzle, "PYITOE"));
        System.out.println(trovaParola(puzzle, "OPACALMTOL"));
        System.out.println(trovaParola(puzzle, "SDA"));
    }

}
