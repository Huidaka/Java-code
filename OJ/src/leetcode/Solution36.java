package leetcode;

/**
 * 有效的数独
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        int row[][] = new int[9][10];
        int line[][] = new int[9][10];
        int son[][] = new int[9][10];
        for(int i=0; i < 9; i++){
            for(int j=0; j < 9; j++){
                if( board[i][j] == '.'){
                    continue;
                }
                int num = board[i][j] - '0';
                row[i][num]++;
                line[j][num]++;
                son[(i/3)*3 + j/3][num]++;
                if(row[i][num] + line[j][num] + son[(i/3)*3 + j/3][num] > 3){
                    return false;
                }
            }
        }
        return true;
    }
}
