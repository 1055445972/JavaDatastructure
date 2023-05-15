public class quicks {
    static int LomutoPartition(int[] a ,int left,int right){
        int p=a[right];
        int i=left-1;
        int j=left;
        while(j<right){
            if (a[j]<p){
                int t=a[i+1];
                a[i+1]=a[j];
                a[j]=t;
                i++;
            }
            j++;
        }
        a[right]=a[i+1];
        a[i+1]=p;
        return i+1;
    }
    static void quicks(int[] a,int left,int right) {
        if(left<right) {
            int q=LomutoPartition(a,left,right);
            quicks(a,left,q-1);
            quicks(a,q+1,right);
        }
    }

    public static void main(String[] args) {
        int[] a= {415,50,34,6,67,23,78,2837,234,627,462};
        quicks(a,0,a.length-1);
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+"  ");
        }
    }
}