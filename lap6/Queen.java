package lap6;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
	int limit=Node.N;
	if(this.row==limit-1) {
		setRow(0);
	}else {
		setRow(row+1);
	}
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		if((Math.abs(this.row-q.row))==(Math.abs(this.column-q.column))||(this.row==q.row)){
			return true;
		}else {
			return false;
		}
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
