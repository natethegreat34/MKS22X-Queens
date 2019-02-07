public class QueenBoard{
    private int[][]board;
    private int max;
    public QueenBoard(int size){
        max = size;
    }
    private boolean addQueen(int r, int c){
        if (board [r] [c] != 0) {
            return false;
        }
        board [r] [c] = -1;
        //  >/
        for (int i = 0; c + i < max && r- i >= 0; i ++){
            board [r - i] [c + i] = 1;
        }
        // <\
        for (int i = 0; c- i >= 0 && r- i >= 0; i ++){
            board [r- i] [c- i] = 1;
        }
        // >\
        for (int i = 0; c+ i < max && r+ i < max; i ++){
            board [r+ i] [c+ i] = 1;
        }
        // </
        for (int i = 0; c- i >= 0 && r+ i < max; i ++){
            board [r + i] [c - i] = 1;
        }
        //  >
        for (int i = 0; r+ i < max; i ++){
            board [r + i] [c] = 1;
        }
        // <
        for (int i = 0; r - i >= 0 ; i ++){
            board [r - i] [c] = 1;
        }
        // v
        for (int i = 0; c - i >= 0; i ++){
            board [r] [c - i] = 1;
        }
        // ^
        for (int i = 0; c + i < max; i ++){
            board [r] [c + i] = 1;
        }
        return true;
    }
  private boolean removeQueen(int r, int c){
      //  >/
      for (int i = 0; c + i < max && r- i >= 0; i ++){
          board [r - i] [c + i] = board [r - i] [c + i]  - 1 ;
      }
      // <\
      for (int i = 0; c- i >= 0 && r- i >= 0; i ++){
          board [r- i] [c- i] = board [r - i] [c + i]  - 1 ;
      }
      // >\
      for (int i = 0; c+ i < max && r+ i < max; i ++){
          board [r+ i] [c+ i] = board [r - i] [c + i]  - 1 ;
      }
      // </
      for (int i = 0; c- i >= 0 && r+ i < max; i ++){
          board [r + i] [c - i] = board [r - i] [c + i]  - 1 ;
      }
      //  >
      for (int i = 0; r+ i < max; i ++){
          board [r + i] [c] = board [r - i] [c + i]  - 1 ;
      }
      // <
      for (int i = 0; r - i >= 0 ; i ++){
          board [r - i] [c] = board [r - i] [c + i]  - 1 ;
      }
      // v
      for (int i = 0; c - i >= 0; i ++){
          board [r] [c - i] = board [r - i] [c + i]  - 1 ;
      }
      // ^
      for (int i = 0; c + i < max; i ++){
          board [r] [c + i] = board [r - i] [c + i]  - 1 ;
      }
      return true;
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
  public String toString(){}


  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){}

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){}
  }
