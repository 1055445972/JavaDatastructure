public class cell {
	private int row;
	private int col;
	private int type;
	
	public cell() {
		
	}
	public cell(int row,int col,int type) {
		this.row=row;
		this.col=col;
		this.type=type;
	}
	public int getRow(){return row;};
	public void setRow(int row) {
		this.row=row;
	}
	public int getcol() {
		return col;
	}
	public void setcol(int col) {
		this.col=col;
	}
	public int gettype() {
		return type;
	}
	public void settype(int type) {
		this.type=type;
	}
}
