// Zhengxiang Yu
// CS 143
// HW #2: Sudoku #2 (isValid, isSolved)
// This class add two methods to check if a Sudoku board is valid and solved.
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

    //pre: none
    //post: return a boolean indicating whether the board is valid
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
            char[][] square = miniSquare(n);
            for (int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if ((square[i][j] != ' ') && (seen.add(square[i][j]) == false)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //pre: none
    //post: return a boolean indicating whether the board is solved
    public boolean isSolved() {
        if (isValid() == false) {
            return false;
        }
        Map<Character, Integer> count = new HashMap<>();
        Set<Character> valid = new HashSet<Character>(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        for (char i : valid) {
            count.put(i,0);
        }
        
        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] != ' ') {
                    int val = count.get(board[i][j]);
                    count.put(board[i][j], val + 1);
                }
            }
        }
        for (char i : count.keySet()) {
            if (count.get(i) != 9) {
                return false;
            }
        }
        return true;
    }

    //pre: spot is an integer between 1 and 9
    //post: return a 3x3 2d array of char of the Sudoku board corresponding to the
    //      given spot 
    private char[][] miniSquare(int spot) {
      char[][] mini = new char[3][3];
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
