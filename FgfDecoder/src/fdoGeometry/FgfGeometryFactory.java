package fdoGeometry;

import fgfUtil.ByteReader;

public class FgfGeometryFactory {
		
	private static final ThreadLocal<FgfGeometryFactory> factory = new ThreadLocal<FgfGeometryFactory>(){
		@Override
		protected FgfGeometryFactory initialValue() {
			return new FgfGeometryFactory();
		}
	};
	
	//singleton in each thread.
	public static FgfGeometryFactory getInstance() {
		return factory.get();
	}
	
	public FgfGeometry createFgfGeometry(byte[] bytes) throws FgfGeometryException {
		FgfGeometryType type = FgfGeometryType.values()[ByteReader.readInt32(bytes,0)];
		switch(type) {
		case POINT:
			return createFgfPoint(bytes);
		default:
			throw new FgfGeometryException("Ivalid goemetry type.");
		}
	}
	
	public FgfPoint createFgfPoint(byte[] bytes) throws FgfGeometryException {
		 FgfPoint point = new FgfPoint(bytes);
		 return point;
	}
}
