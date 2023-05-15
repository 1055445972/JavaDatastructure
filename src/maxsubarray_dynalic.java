public class maxsubarray_dynalic {
    public static int[] dynamicmaxsubarray(int[] a){
        int d[]=new int[a.length+1];
        int rec[]=new int[a.length+1];
        //d[0]=0;
        int r=0;
        int max=Integer.MIN_VALUE;

        for(int i=1;i<=a.length;i++){
            if(d[i-1]>0){
                d[i]=d[i-1]+a[i-1];
                rec[i]=rec[i-1];
            }else {
                d[i]=a[i-1];
                rec[i]=i-1;
            }
            if (d[i]>max){
                max=d[i];
                r=i;
            }
        }
        int[] maxsubarray=new int[r-rec[r]];
        for (int i=0;i<maxsubarray.length;i++){
            maxsubarray[i]=a[i+rec[r]];
        }
        return maxsubarray;
    }
    public static void main(String[] args){
        int[] a={-5,2,6,-1,3,-2};
        int[] maxsubarray=dynamicmaxsubarray(a);
        int sum=0;
        for (int i=0;i<maxsubarray.length;i++){
            sum+=maxsubarray[i];
            System.out.print(maxsubarray[i]+" ");
        }
        System.out.println();
        System.out.print(sum);
    }
}
