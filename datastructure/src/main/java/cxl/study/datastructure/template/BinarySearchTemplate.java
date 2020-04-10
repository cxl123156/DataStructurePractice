package cxl.study.datastructure.template;

public class BinarySearchTemplate {

    public int binarySearch(int[] array,int target){
        int left=0,right = array.length-1;
        int mid = 0;
        while (left <= right){
            mid = (left + right) / 2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchTemplate binarySearchTemplate = new BinarySearchTemplate();
        int[] array = {5,6,1,2,3,4};
        System.out.println(binarySearchTemplate.binarySearch(array, 1));
    }

}
