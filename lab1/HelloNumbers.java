public class HelloNumbers{
    public static int sum(int[] a){
	int ret = 0;
        for (int i = 0; i < a.length; i++){
            ret += a[i]; 
	}
        return ret;
    }
    public static void main(String[] args){
	int[] s = new int[]{4,7,10,1,13,16};
        System.out.println(sum(s));
    }
}

