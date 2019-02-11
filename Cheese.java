public class Cheese{
public static void main(String[] args) {
    QueenBoard bod = new QueenBoard (8);
    System.out.println(bod.toString());
    System.out.println(bod.countSolutions());
}
}
