package fdoGeometry;

import fgfUtil.ByteReader;
import fgfUtil.FgfUtil;

import java.util.Arrays;

/**
 * Implementation of MultiLineString
 * struct {
 *     int geomType;
 *     int numLineString >=0
 *     LineString[] linesString;
 * }
 * Created by Hongzhe on 1/23/2016.
 */
public class FgfMultiLineString extends FgfGeometry{

    public FgfMultiLineString(byte[] bytes) {
        super(bytes);
    }

    public void reset(byte[] bytes) {
        this.fgf = bytes;
    }

    public int getCount() {
        return ByteReader.readInt32(fgf,4);
    }

    public CoorDimensionality getDimensionality() {
        return CoorDimensionality.values()[ByteReader.readInt32(fgf, 12)];
    }

    public FgfLineString getItem(int index) throws FgfGeometryException {
        int count = getCount();
        if(index > count - 1) {
            throw new FgfGeometryException("Index out of bound.");
        }
        int offset = 8;
        int numCoords = FgfUtil.typeToNumOrdinates(getDimensionality());
        int length = numCoords * 8 + 8;
        offset += index * length;
        byte[] bytes = Arrays.copyOfRange(fgf, offset, offset + length);
        return new FgfLineString(bytes);
    }
}
