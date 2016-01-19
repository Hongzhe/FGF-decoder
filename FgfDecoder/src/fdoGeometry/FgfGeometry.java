package fdoGeometry;

import fgfUtil.ByteReader;

public class FgfGeometry {
	
	protected byte[] fgf;
	
	
	public FgfGeometry(byte[] bytes) {
		this.fgf = bytes;
	}
	
	public FgfGeometryType getDrivedType() {
		int typeInt = ByteReader.readInt32(fgf, 0);
		return FgfGeometryType.values()[typeInt];
	}
}
