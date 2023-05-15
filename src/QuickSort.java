public class QuickSort {
    static int HoarePartition(int[] a ,int left,int right){
        int mainElement=a[right];
        int i=left;
        int j=right-1;
        while(i<=j){
            while(a[i]<mainElement){
                i++;
            }
            while(j>=left && a[j]>mainElement){
                j--;
            }
            if (i<j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        a[right]=a[i];
        a[i]=mainElement;
        return i;
    }
    static void quickSort(int[] a,int left,int right) {
        if(left<right) {
            int q=HoarePartition(a,left,right);
            quickSort(a,left,q-1);
            quickSort(a,q+1,right);
        }
    }

    public static void main(String[] args) {
        //int[] a= {3,50,34,6,67,23,78,287,234,627,462};
        int[] a= {229,142,86,43,12,3};
        quickSort(a,0,a.length-1);
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+"  ");
        }
    }
}