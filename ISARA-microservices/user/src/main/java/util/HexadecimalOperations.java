package util;

import java.util.HexFormat;

public class HexadecimalOperations {
    public static String getHexStringFromBytes(byte[] content) {
        return HexFormat.of().formatHex(content);
    }

    public static byte[] getBytesFromHex(String hex) {
        return HexFormat.of().parseHex(hex);
    }
}
