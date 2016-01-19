package fdoGeometry;

public enum FgfGeometryType {
	NONE(0), 
	POINT(1),
	LINE_STRING(2);
	
	private int val;
	
	private FgfGeometryType(int val) {
		this.val = val;
	}
}
