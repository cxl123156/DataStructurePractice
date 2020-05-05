package cxl.study.orther;

public class FindInMatrix {

    public boolean Find(int target, int [][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt == target) {
                    return true;
                }
            }
        }
        return false;
    }

}
