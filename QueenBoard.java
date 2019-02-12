public class QueenBoard{
    private int[][]board;
    private int max;
    private int total;
    public QueenBoard(int size){
        max = size;
        board = new int [max][max];
    }
    public void setup (){
        for (int a = 0; a < max; a++){
          for (int b = 0; b < max; b++){
              board [a][b] = 0;
    }}}
    //      /
    //     /
    // \  /
    //  v
    private boolean addQueen(int r, int c){
        if (board [r] [c] != 0) {
            return false;
        }
        return true;
    }
    //      /
    //     /
    // \  /
    //  v
    private void adder (int r, int c){
        board [r] [c] = -1;
        //  >/
        for (int i = 0; c + i < max && r- i >= 0; i ++){
            if (board [r - i] [c + i] >= 0){
            board [r - i] [c + i] += 1;
            }
        }
        // <\
        for (int i = 0; c- i >= 0 && r- i >= 0; i ++){
            if (board [r - i] [c - i] >= 0){
            board [r- i] [c- i] += 1;
            }
        }
        // >\
        for (int i = 0; c+ i < max && r+ i < max; i ++){
            if (board [r + i] [c + i] >= 0){
            board [r+ i] [c+ i] += 1;
            }
        }
        // </
        for (int i = 0; c- i >= 0 && r+ i < max; i ++){
            if (board [r + i] [c - i] >= 0){
            board [r + i] [c - i] += 1;
            }
        }
        //  >
        for (int i = 0; r+ i < max; i ++){
            if (board [r + i] [c] >= 0){
            board [r + i] [c] += 1;
            }
        }
        // <
        for (int i = 0; r - i >= 0 ; i ++){
            if (board [r - i] [c] >= 0){
            board [r - i] [c] += 1;
            }
        }
        // v
        for (int i = 0; c - i >= 0; i ++){
            if (board [r] [c - i] >= 0){
            board [r] [c - i] += 1;
            }
        }
        // ^
        for (int i = 0; c + i < max; i ++){
            if (board [r] [c + i] >= 0){
            board [r] [c + i] += 1;
            }
        }
    }
    //      /
    //     /
    // \  /
    //  v
  private boolean removeQueen(int r, int c){
      if (board [r] [c] >= 0) {
          return false;
      }
      return true;
  }
  //      /
  //     /
  // \  /
  //  v
    private void remover (int r, int c){
      //  >/
      for (int i = 0; c + i < max && r- i >= 0; i ++){
          board [r - i] [c + i] +=  - 1 ;
      }
      // <\
      for (int i = 0; c- i >= 0 && r- i >= 0; i ++){
          board [r- i] [c- i] +=  - 1 ;
      }
      // >\
      for (int i = 0; c+ i < max && r+ i < max; i ++){
          board [r+ i] [c+ i] +=  - 1 ;
      }
      // </
      for (int i = 0; c- i >= 0 && r+ i < max; i ++){
          board [r + i] [c - i] +=  - 1 ;
      }
      //  >
      for (int i = 0; r+ i < max; i ++){
          board [r + i] [c] +=  - 1 ;
      }
      // <
      for (int i = 0; r - i >= 0 ; i ++){
          board [r - i] [c] +=  - 1 ;
      }
      // v
      for (int i = 0; c - i >= 0; i ++){
          board [r] [c - i] +=  - 1 ;
      }
      // ^
      for (int i = 0; c + i < max; i ++){
          board [r] [c + i] +=  - 1 ;
      }
      board [r][c] = 0;
  }
/**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  //      /
  //     /
  // \  /
  //  v
  public String toString(){
      String display = "";
      for (int y = 0; y < board.length; y++){
        for (int x = 0; x < board[y].length; x++){
            if( board [y][x] >= 0){
                display = display + "_ ";
            }
            else {
                display = display + "Q ";
            }
            if (x == max - 1){
                display = display + "\n";
            }
  }
}
    return display;
}


  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */

  private void solve (int y){
      // System.out.println(toString());
     if (y >= max){
         total ++;
     }
     else{
      if (y < 0 ){
          throw new IllegalStateException ("");
        }
        for (int x = 0; x < max; x ++){
            if (addQueen(y,x)){
                adder(y,x);
                solve (y + 1);

            remover(y, x);
        }
        }
    }
}




//
//
//
//
// System.out.println(toString());
//       // - - - -
//       // - - - -
//       // - - - -
//       // Q - - -
//
//       // If it is solved, return true, keeping the board solved.
//       if (checker()){
//           return true;
//       }
//
//       // If you can add a queen, add one and move onto the next column
//       if (addQueen(y, x)){
//           adder(y, x);
//           if (solve (0, x + 1)){
//               return true;
//           }
//       }
//       else {
//           solve (y + 1, x);
//       }
//
//       // If one can't add a queen to the second coluumn, and the Queen is on the bottom of the first column, return false.
//       if (!free (1, max)){
//               setup();
//           return false;
//      }
//
//      // If one can't add a queen to the current column, go to the one before this column and remove the current queen, and try to add it one spcae lower and continue
//      if (!free (x, max)){
//          if (x >= 1){
//          remover(findcolQ (x - 1), x - 1);
//          return solve (findcolQ (x - 1) + 1, x - 1);
//      }
//  }
//  return false;
// }








private boolean free(int x, int z){
    for (int y = 0; y < z; y ++){
        if (board [y] [x] == 0){
            return true;
        }
    }
        return false;
}

private int findcolQ (int x){
    for (int y = 0; y < board.length; y ++){
        if (board [y] [x] < 0){
            return y;
        }
    }
        return -1;
}
  private boolean checker (){
      int sum = 0;
      for (int y = 0; y < max; y++){
        for (int x = 0; x < max; x++){
            if( board [y][x] < 0){
                sum++;
            }}}
    if (max == sum){
        return true;
    }
    return false;
}

//
//   public boolean solve(){
//       if ( size < 0){
//           throw new IllegalStateException ("");
//       }
//       int sum = 0;
//       for (int y = 0; y < board.length; y++){
//         for (int x = 0; x < board[y].length; x++){
//             if( board [y][x] < 0){
//                 sum++;
//             }}}
//     if (max == sum){
//         return true;
//     }
//     return false;
// }

  //     solver(0, 0);
  //
  //   for (int y = 0; y < board.length; y++){
  //     for (int x = 0; x < board[y].length; x++){
  //         board [y][x] = 0;}}
  //   return false;
  // }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
      if (max == 0){
          return 0;
      }
      if (board [0] [0] != 0){
          throw new IllegalStateException ("");
      }
      solve (0);
      return total;
  }
      }
