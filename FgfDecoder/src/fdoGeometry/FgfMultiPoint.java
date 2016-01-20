package fdoGeometry;

import fgfUtil.ByteReader;
import fgfUtil.FgfUtil;

import java.util.Arrays;

/**
 * Implementation of FGF MultiPoint
 * strcut MultiPoint {
 *  int geomType
 *  int numPoints
 *  Point[] points
 * }
 * Created by Hongzhe on 1/20/2016.
 */
public class FgfMultiPoint extends FgfGeometry {

    public FgfMultiPoint(byte[] bytes) {
        super(bytes);
    }

    public void reset(byte[] bytes) {
        this.fgf = bytes;
    }
    public int getCount() {
        return ByteReader.readInt32(fgf, 4);
    }

    public CoorDimensionality getDimensionliaty() {
        //skip geomtype, numPts and geomPointType
       return CoorDimensionality.values()[ByteReader.readInt32(fgf, 12)];
    }

    public FgfPoint getItem(int index) throws FgfGeometryException {
        int numPoints = getCount();
        int coordNum = FgfUtil.typeToNumOrdinates(getDimensionliaty());
        int length = 8 * coordNum + 8;
        if(index > numPoints - 1) {
            throw new FgfGeometryException("Index out of bound.");
        }
        byte[] bytes = Arrays.copyOfRange(fgf, (index)*length, (index)*length+length);
        return new FgfPoint(bytes);
    }
}
