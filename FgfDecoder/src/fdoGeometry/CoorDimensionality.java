package fdoGeometry;

public enum CoorDimensionality {
	XY(0),
	Z(1),
	M(2);
	
	private int val;
    CoorDimensionality(int v) {
		this.val = v;
	}
}
