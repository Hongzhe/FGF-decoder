package fdoGeometry;

import fgfUtil.ByteReader;
import fgfUtil.FgfUtil;

/******
 * Implementation for FGF LineString
 * struct LineString {
 * 	int geomType;
 * 	CoordinateDimensionality type;
 *  int numPts;
 *  double[] coords;
 * }
 * @author lihongzhe
 *
 */
public class FgfLineString extends FgfGeometry {
	
	public FgfLineString(byte[] bytes) {
		super(bytes);
	}
	

	public void reset(byte[] bytes) {
		this.fgf = bytes;
	}
	
	//return number of points.
	public int getCount() {
		return ByteReader.readInt32(fgf, 8);
	}
	
	public CoorDimensionality getDimensionality() {
		return CoorDimensionality.values()[ByteReader.readInt32(fgf, 4)];
	}
	
	public FgfPosition[] getPositions() throws FgfGeometryException {
		int numPts = ByteReader.readInt32(fgf, 8);
		FgfPosition[] positions = new FgfPosition[numPts];
		for(int i = 0; i < numPts; i++) {
			positions[i] = getPosition(i);
		}
		return positions;
	}
	
	public FgfPosition getPosition(int index) throws FgfGeometryException
	{
		CoorDimensionality dimensionality = getDimensionality();
		int nums = getCount();
		int numOrdinates = FgfUtil.typeToNumOrdinates(dimensionality);
		if(index > nums -1) {
			throw new FgfGeometryException("Index out of bound.");
		}
		FgfPosition pos = FgfUtil.readPosition(fgf, 12 + 8 * index, numOrdinates);
		return pos;
	}
}
