//最大子数组分治算法
public class maxsubarray_fenzhi {
    //跨中心最大子数组

    private static int[] acrosscentresubarray(int[] a, int left, int mid, int right){
        //左边数组开始下标，从中心往左
        //右边数组结束下标，从中心往右
        int leftsubarray=mid;
        int rightsubarray=mid+1;
        //相加和与左数组最大和
        int sum=0;
        int leftsum=a[mid];
        //遍历左数组,从中心往左
        for(int i=mid;i>=left;i--){
            //依次相加和
            sum+=a[i];
            //判断相加和是否大于左数组最大和
            if(sum>leftsum){
                leftsum=sum;
                leftsubarray=i;
            }
        }
        //
        sum=0;
        int rightsum=a[mid+1];
        for(int i=mid+1;i<=right;i++){
            sum+=a[i];
            if(sum>rightsum){
                rightsum=sum;
                rightsubarray=i;
            }
        }
        //数组长度
        int length=rightsubarray-leftsubarray+1;
        int[] subarray=new int[length];
        for(int i=0;i<length;i++){
            subarray[i]=a[leftsubarray+i];
        }
        return subarray;
    }
    //数组求和
    private static int sumarray(int[] a){
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];

        }
        return sum;
    }
    //递归法-分治
    public static int[] dividconquermaxsubarray(int[] a,int left,int right){
        //数组左下标等于右下标,即只有一个数
        if (left==right){
            int[] maxsubarray=new int[1];
            maxsubarray[0]=a[left];
            return maxsubarray;
        }
        //数组左下标大于右下标，即空数组或错误数组
        else if(left>right){
            int[] maxsubarray=new int[1];
            maxsubarray[0]= 0x3fffffff;
            return maxsubarray;
        }
        //正常情况，右下标大于左下标
        else{
            //确定中心下标
            int mid=(left+right)/2;
            //左数组,递归调用该算法，传数组，左下标到中间下标
            int[] leftsubarray=dividconquermaxsubarray(a,left,mid);
            //右数组
            int[] rightsubarray=dividconquermaxsubarray(a,mid+1,right);
            //跨中心数组,
            int[] centresubarrray=acrosscentresubarray(a,left,mid,right);

            int leftsubarraysum=sumarray(leftsubarray);
            int rightsubarraysum=sumarray(rightsubarray);
            int centresubarraysum=sumarray(centresubarrray);
            if(leftsubarraysum<rightsubarraysum){
                if(rightsubarraysum<centresubarraysum){
                    return centresubarrray;
                }else{
                    return rightsubarray;
                }
            }else{
                if(rightsubarraysum<centresubarraysum){
                    return centresubarrray;
                }else{
                    return rightsubarray;
                }
            }

        }
    }
    public static void main(String[] args){
        int[] a={7,5,-5,-8,15,6,-9,16,8,-23,46,9,-6,7};
        int[] maxsubarray=dividconquermaxsubarray(a,0,a.length-1);
        for(int i=0;i<maxsubarray.length;i++){
            System.out.print(maxsubarray[i]+" ");
        }
        System.out.println();
        System.out.print(sumarray(maxsubarray));
    }
}
