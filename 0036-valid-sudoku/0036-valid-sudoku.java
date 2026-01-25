class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] box = new int[9][9];
         for(int r = 0; r<9;r++){
            for(int c = 0; c<9;c++){
                char var = board[r][c];
                if(var  == '.') continue;
                int num = var - '1';
                int boxIndex = (r/3) *3 + (c/3);

                if(rows[r][num] == 1) return false;
                if(cols[c][num] == 1)return false;
                if(box[boxIndex][num] ==1) return false;

                rows[r][num] = 1;
                cols[c][num] = 1;
                box[boxIndex][num]=1;
            }
         }
         return true;
        
    }
}