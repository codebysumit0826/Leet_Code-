class Solution {
    public boolean isValidSudoku(char[][] board) {
         int[] cols = new int[9]; // columns bit masks
        int[] boxes = new int[9]; // boxes 0-8, box index = (row / 3) * 3 + col / 3

        for (int row = 0; row < 9; row++) {
            int rowBox = (row / 3) * 3; // row part of box index -> 0/3/6
            int rowMask = 0; // bit mask for current row
            
            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];
                if (ch == '.') {
                    continue;
                }

                int box = rowBox + col / 3; // 0-8
                int bit = 1 << (ch - '1'); // digit -> mask, move 1 bit by 0-8(= ch - '1') positions left

                // if bit has already been seen -> board is ivalid
                if ((rowMask & bit) != 0 || (cols[col] & bit) != 0 || (boxes[box] & bit) != 0) {
                    return false;
                }

                // mark digit as seen in current row, column and box
                rowMask |= bit;
                cols[col] |= bit;
                boxes[box] |= bit;
            }
        }

        return true;
        
    }
}