public class program {
    public static void main(String[] args){
        chessboard chessboard=new chessboard(3);

        cell bedcell=new cell(2,2,1);
        chessboard.setBedcell(bedcell);
        chessboard.output();
        System.out.println();
        chessboard.conver(0,0, chessboard.getRows(),bedcell);
        chessboard.output();
    }
}
