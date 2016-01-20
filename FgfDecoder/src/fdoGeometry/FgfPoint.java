package fdoGeometry;

import fgfUtil.ByteReader;
import fgfUtil.FgfUtil;

/**********
 * Implementation of Fgf Point
 * struct point {
 * 	int geomType;
 *  CoordinateDimensionality type;
 *  double[] coords
 * }
 * @author lihongzhe
 *
 */
public class FgfPoint extends FgfGeometry {
	
	
	public FgfPoint(byte[] bytes) throws FgfGeometryException {
		super(bytes);
	}
	
	public CoorDimensionality getDimensionality() {
		return CoorDimensionality.values()[ByteReader.readInt32(fgf, 4)];
	}
	
	public FgfPosition getPosition() {
		int num = FgfUtil.typeToNumOrdinates(getDimensionality());
		FgfPosition pos = FgfUtil.readPosition(fgf, 8, num);
		return pos;
	}
	
	
	public void reset(byte[] bytes) throws FgfGeometryException {
		this.fgf = bytes;
	}
}
