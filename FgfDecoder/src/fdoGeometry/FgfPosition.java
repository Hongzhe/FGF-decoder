package fdoGeometry;

/*
 * Immutable class.
 */
public class FgfPosition {
	
	private double _x;
	private double _y;
	private double _z;
	private double _m;
	private CoorDimensionality dimensionality;
	
	public FgfPosition(double x, double y) {
		this._x = x;
		this._y = y;
		this.dimensionality = CoorDimensionality.XY;
	}
	
	public FgfPosition(double x, double y, double z) {
		this._x = x;
		this._y = y;
		this._z = z;
		this.dimensionality = CoorDimensionality.Z;
	}

	public double getX() {
		return _x;
	}

	public double getY() {
		return _y;
	}

	public double getZ() {
		return _z;
	}

	public CoorDimensionality getDimensionality() {
		return dimensionality;
	}

	public void getM() throws FgfGeometryException {
		throw new FgfGeometryException("feature not supported.");
	}
}
