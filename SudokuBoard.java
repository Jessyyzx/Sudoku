// Zhengxiang Yu
// CS 143
// HW #1: Sudoku #1 (Board Setup)
// This class is used to read a Sudoku board from a file and print it in a formatted way.
import java.io.*;
import java.util.*;
public class SudokuBoard {
    private char[][] board = new char[9][9];
    // pre: filePath is a valid file path containing a Sudoku board
    // post: construct a SudokuBoard object by reading the board from the file
    //       and storing it in the board array
    public SudokuBoard(String filePath) throws FileNotFoundException{
        Scanner read = new Scanner(new File(filePath));
        for(int i = 0; i < 9; i++) {
            String next = read.next();
            for (int j = 0; j < 9; j++) {
                if (next.charAt(j) == '.') {
                    board[i][j] = ' ';
                } else {
                    board[i][j] = next.charAt(j);
                }
            }
        }
    }

    //pre: none
    //post: return a string representation of formatted string of the sudoku board
    public String toString(){
        String result = "";
        for (int i = 0; i < 9; i++) {
            result = result + board[i][0];
            for (int j = 1; j < 9; j++) {
                result = result + ("|" + board[i][j]);
            }
            result = result + "\n";
        }
        return result;
    }

    public boolean isValid() {
        Set<Character> valid = new HashSet<Character>(Arrays.asList('1','2','3','4','5','6','7','8','9',' '));
        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (valid.contains(board[i][j]) == false) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Set<Character> seen = new HashSet<Character>();
            for(int j = 0; j < 9; j++) {
                if ((board[i][j] != ' ') && (seen.add(board[i][j]) == false)) {
                    return false;
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            Set<Character> seen = new HashSet<Character>();
            for(int i = 0; i < 9; i++) {
                if ((board[i][j] != ' ') && (seen.add(board[i][j]) == false)) {
                    return false;
                }
            }
        }

        for (int n = 1; n <=9; n++) {
            Set<Character> seen = new HashSet<Character>();
            int[][] square = miniSquare(n);
            for (int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if ((square[i][j] != ' ') && (seen.add(board[i][j]) == false)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isSolved() {
        if (isValid() == false) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] miniSquare(int spot) {
      int[][] mini = new int[3][3];
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
            // whoa - wild! This took me a solid hour to figure out (at least)
            // This translates between the "spot" in the 9x9 Sudoku board
            // and a new mini square of 3x3
            mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      return mini;
   }
}
