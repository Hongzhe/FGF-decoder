package fgfUtil;

public class ByteReader {
	
	public static int readInt32(byte[] bytes, int offset) {
		return bytes[0 + offset] & 0xff | (bytes[1 + offset] & 0xff) << 8 |
				(bytes[2 + offset] & 0xff) << 16 | (bytes[3 + offset] & 0xff) << 24;
	}
	
	public static double readDouble(byte[] bytes, int offset) {
		return Double.longBitsToDouble((long)bytes[0+offset] & 0xff | ((long)bytes[1+offset]& 0xff) << 8 | ((long)bytes[2+offset] &0xff) << 16
				| ((long)bytes[3+offset] & 0xff) << 24 |((long)bytes[4+offset] & 0xff) << 32 | ((long)bytes[5+offset] & 0xff) << 40
				| ((long)bytes[6+offset] & 0xff) << 48 | ((long)bytes[7+offset] & 0xff) << 56);		
	}
}
