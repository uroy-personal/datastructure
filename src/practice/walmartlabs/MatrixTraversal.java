package practice.walmartlabs;

public class MatrixTraversal {
	
	static int numberOfpaths(int m, int n) {
		if(m<=0 || n<=0) {
			return 0;
		}
		if(m==1 && n==1) {
			return 1;
		}
		return numberOfpaths(m-1,n)+numberOfpaths(m,n-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOfpaths(3,3));

	}

}
