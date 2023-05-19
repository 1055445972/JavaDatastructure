import java.util.Random;

public class chessboard {
    private int size=1;
    private cell[][] cells=new cell[2][2];
    private cell bedcell=cells[0][0];
    private int rows,cols;

    public void setSize(int size){
        int count=(int)Math.pow(2,size);
        cells=new cell[count][count];
        for (int i=0;i<count;i++){
            for(int j=0;j<count;j++){
                cells[i][j]=new cell(i,j,0);
            }
        }
        rows=count;
        cols=count;
    }
    public chessboard(int size){
        this.size=size;
        setSize(size);
        bedcell=cells[0][0];
        bedcell.settype(1);
    }
    public cell getBedcell(){
        return bedcell;
    }
    public void setBedcell(cell bedcell){
        this.bedcell.settype(0);
        this.bedcell=cells[bedcell.getRow()][bedcell.getcol()];
        this.bedcell.settype(1);
    }
    public int getRows(){
        return rows;
    }
    public int getCols(){
        return cols;
    }
    public void output(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(cells[i][j].gettype()+" ");
            }
            System.out.println();
        }
    }

    public void conver(int left,int top,int rcount,cell bedcell){
        cell lefttopbedcell=bedcell;
        cell leftbottombedcell=bedcell;
        cell righttopbedcell=bedcell;
        cell rightbottombedcell=bedcell;
        Random rnd=new Random();
        int r;
        if(rcount==1){
            return;//递归出口
        }else{
            int count=rcount/2;
            //坏块在左上角
            if(bedcell.getRow()>=top && bedcell.getRow()<top+count && bedcell.getcol()>=left && bedcell.getcol()<left+count){
                lefttopbedcell=bedcell;

                righttopbedcell=cells[top+count-1][left+count];
                righttopbedcell.settype(2);
                rightbottombedcell=cells[top+count][left+count];
                rightbottombedcell.settype(2);
                leftbottombedcell=cells[top+count][left+count-1];
                leftbottombedcell.settype(2);
            }
            //坏块在右上角
            if(bedcell.getRow()>=top && bedcell.getRow()<top+count && bedcell.getcol()>=left+count && bedcell.getcol()<left+2*count){
                righttopbedcell=bedcell;

                lefttopbedcell=cells[top+count-1][left+count-1];
                lefttopbedcell.settype(3);
                leftbottombedcell=cells[top+count][left+count-1];
                leftbottombedcell.settype(3);
                rightbottombedcell=cells[top+count][left+count];
                rightbottombedcell.settype(3);
            }
            //坏块在右下角
            if(bedcell.getRow()>=top+count && bedcell.getRow()<top+2*count && bedcell.getcol()>=left+count && bedcell.getcol()<left+2*count){
                rightbottombedcell=bedcell;

                righttopbedcell=cells[top+count-1][left+count];
                righttopbedcell.settype(4);
                lefttopbedcell=cells[top+count-1][left+count-1];
                lefttopbedcell.settype(4);
                leftbottombedcell=cells[top+count][left+count-1];
                leftbottombedcell.settype(4);
            }
            //坏块在左上角
            if(bedcell.getRow()>=top+count && bedcell.getRow()<top+2*count && bedcell.getcol()>=left && bedcell.getcol()<left+count){
                rightbottombedcell=bedcell;

                lefttopbedcell=cells[top+count-1][left+count-1];
                lefttopbedcell.settype(5);
                righttopbedcell=cells[top+count-1][left+count];
                righttopbedcell.settype(5);
                rightbottombedcell=cells[top+count][left+count];
                rightbottombedcell.settype(5);
            }
        }
    }
}
