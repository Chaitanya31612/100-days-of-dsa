package day12_trie;

public class CheckiSetBit {
    public boolean setBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    public static void main(String[] args) {

    }
}
