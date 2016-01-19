package fgfUtil;

import fdoGeometry.CoorDimensionality;
import fdoGeometry.FgfPosition;

public class FgfUtil {
	
	/**
	 * Given dimensionality, return number of ordinates 
	 * @param dimensionality
	 * @return 
	 */
	public static int typeToNumOrdinates(CoorDimensionality dimensionality) {
		if(dimensionality == CoorDimensionality.XY) {
			return 2;
		} else if(dimensionality == CoorDimensionality.Z) {
			return 3;
		}
		return 0;
	}
	
	/***
	 * Read a FgfPositioin from byte[]
	 * @param bytes
	 * @param offset
	 * @param count  number of ordinates. see typeToNumOrinates
	 * @return
	 */
	public static FgfPosition readPosition(byte[] bytes, int offset, int count) {
		double x = ByteReader.readDouble(bytes, offset);
		double y = ByteReader.readDouble(bytes, offset + 8);
		if(count > 2) {
			double z = ByteReader.readDouble(bytes, offset + 16);
			return new FgfPosition(x, y, z);
		}
		return new FgfPosition(x, y);
	}
}
