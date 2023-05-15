public class maxsubarray {
    //蛮力法——改进后的蛮力法。
    public  static  int[] bruteforcemaxsubarray(int[] a,int n){
        int left=0;
        int right=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=a[j];
                if(sum>maxsum){
                    maxsum=sum;
                    left=i;
                    right=j;
                }
            }

        }
        int[] maxsubarray=new int[right-left+1];
        for(int i=0;i<maxsubarray.length;i++){
            maxsubarray[i]=a[left+i];
        }
        return maxsubarray;
    }
    public static  void main(String[] args ){
        int[] a={5,-2,12,-3,15,4};
        int[] maxsubarray=bruteforcemaxsubarray(a,a.length);
        int sum=0;
        for(int i=0;i<maxsubarray.length;i++){
            sum+=maxsubarray[i];
            System.out.print(maxsubarray[i]+" ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
