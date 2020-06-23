package leetcode;

/**
 * 二进制求和
 */
class Solution67 {
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }
}

