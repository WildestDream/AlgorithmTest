package string;

public class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        return lena == lenb && (A + A).contains(B);
    }
}
