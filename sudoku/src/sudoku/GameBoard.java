/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author claud
 */
public class GameBoard {

    private int[][] solution = new int[9][9];
    /* Array that will contain ONLY the numbers initially drawn on the board and that the player can't change */
    private int[][] initial = new int[9][9];
    /* Array that will contain player's numbers */
    private int[][] player;
    
    int dificuldade = 0;
    /**
     * *
     * @see Arrays
     */
    public GameBoard(int dificuldade) {
        int N = 9;
        int K = 0;
        if(dificuldade == 1) {
            K = (int)(Math.random() * 15) + 10;
        }
        if(dificuldade == 2) {
            K = (int)(Math.random() * 15) + 10;
        }
        
        K = (int)(Math.random() * 15) + 10;
        System.out.println("K");
        
        
        
        
        
        
        Sudoku sudokuGame = new Sudoku(N, K);
        sudokuGame.fillValues();
        
        int[][] valoresSolucao = sudokuGame.getSolution();
        
        sudokuGame.removeKDigits();
        int[][] valoresIniciais = sudokuGame.printSudoku1();
        
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.solution[i][j] = valoresSolucao[i][j];
            }
        }

        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.initial[i][j] = valoresIniciais[i][j];
                
            }
        }
        // 0's will be rendered as empty space and will be editable by player

        // player's array is initialized as a 9x9 full of zeroes
        player = new int[9][9];
    }

    /**
     * *
     *
     * @return the solution array
     */
    public int[][] getSolution() {
        return solution;
    }

    /**
     * *
     *
     * @return the initial filled-in numbers array
     */
    public int[][] getInitial() {
        return initial;
    }

    /**
     * *
     *
     * @return the player array
     */
    public int[][] getPlayer() {
        return player;
    }

    /**
     * *
     *
     * @param val the integer to insert in the player array
     * @param row location in array x
     * @param col location in array y
     */
    public void modifyPlayer(int val, int row, int col) {
        // check if the initial array has a zero (treated as empty square)
        // in the position we want to put in a number in the player array
        // this way we avoid intersections between the two
        if (initial[row][col] == 0) {

            if (val >= 0 && val <= 9) // only values from 0 to 9 inclusive are permitted
            {
                player[row][col] = val;
            } else // print out an error message
            {
                System.out.println("Value passed to player falls out of range");
            }
        }

    }

    /**
     * *
     *
     * @return true if player solution matches original solution, false if not
     */
    public boolean checkForSuccess() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // if the value in the initial array is zero, which means
                // the player has to input a value in the square
                if (initial[row][col] == 0) {

                    // check if the player value corresponds to the solution value
                    // and if it doesn't:
                    if (player[row][col] != solution[row][col]) {

                        // return false, which will tell us there has been a mistake
                        // and that is enough for us to know the player hasn't solved
                        // the puzzle
                        return false;
                    }
                }

            }
        }
        // otherwise, if everything is correct, return true
        return true;
    }

    /**
     * *
     *
     * @return true if player solution is a correct one according to sudoku
     * rules
     */
    public boolean checkForSuccessGeneral() {
        // combine the initial and player arrays
        // instantiate a 9x9 array filled with 0's;
        int[][] combined = new int[9][9];
        // fill it up with the combination of initial number and player answers
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // if there's a valid number in the initial array
                if (initial[row][col] != 0) {
                    // add it at the same position in the combined one
                    combined[row][col] = initial[row][col];
                    // if there isn't
                } else {
                    // add from the same position in the player array
                    combined[row][col] = player[row][col];
                }
            }
        }
        // check if the sum of the numbers in each row is 
        // equal to 45 (the sum of numbers from 1 to 9)
        for (int row = 0; row < 9; row++) {
            //for that row, create a sum variable
            int sum = 0;
            // add all the numbers from a row
            for (int col = 0; col < 9; col++) {
                sum = sum + combined[row][col];
            }
            // if the sum isn't 45, then the row is invalid, invalidating the whole solution
            if (sum != 45) {
                return false;
            }
        }

        // check if the sum of the numbers in each column is
        // equal to 45 (the sum of numbers from 1 to 9)
        for (int col = 0; col < 9; col++) { // note that the for loops are switched around
            //for that column, create a sum variable
            int sum = 0;
            // add all the numbers from a column
            for (int row = 0; row < 9; row++) {
                sum = sum + combined[row][col];
            }
            // if the sum isn't 45, then the column is invalid, invalidating the whole solution
            if (sum != 45) {
                return false;
            }
        }

        // check if the sum of the numbers in each 3x3 unique square
        // on the 9x9 board sums to 45 (the sum of num)
        // we are going to create an offset of 3 squares for each check
        // increment the row offset with 3 each time
        for (int row_offset = 0; row_offset < 9; row_offset += 3) {
            // increment the col offset with 3 each time
            for (int col_offset = 0; col_offset < 9; col_offset += 3) {
                // for each 3x3 cluster, create a sum variable
                int sum = 0;
                // add all numbers from a cluster of 3x3
                for (int row = 0; row < 3; row++) {

                    for (int col = 0; col < 3; col++) {
                        sum = sum + combined[row + row_offset][col + col_offset];
                    }
                }
                // if the sum isn't 45, then the 3x3 cluster is invalid,
                // invalidating the whole solution
                if (sum != 45) {
                    return false;
                }
            }
        }
        // if none of the checks have triggered a return false statement,
        // fly the all-clear and return true
        return true;
    }

}