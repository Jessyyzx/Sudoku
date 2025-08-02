// Zhengxiang Yu
// CS 143
// HW #1: Sudoku #1 (Board Setup)
// This class is used to test the function of SudokuBoard class
// to let it read a Sudoku board from a file and print it in a formatted way.
import java.io.*;
import java.util.*;
public class PlaySudoku {
    public static void main(String[] args) throws FileNotFoundException{
        SudokuBoard newBoard = new SudokuBoard("boards/valid-incomplete.sdk");
        System.out.println(newBoard);
    }
}

/*
2| | |1| |5| | |3
 |5|4| | | |7|1| 
 |1| |2| |3| |8| 
6| |2|8| |7|3| |4
 | | | | | | | | 
1| |5|3| |9|8| |6
 |2| |7| |1| |6| 
 |8|1| | | |2|4| 
7| | |4| |2| | |1
 */