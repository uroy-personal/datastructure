package practice.miscelleneous;

public class GameOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] initalPhaseLifeMatrix = new int[][] {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		int[][] nextPhaseLifeMatrix = new int[initalPhaseLifeMatrix.length][initalPhaseLifeMatrix[0].length];
		
		clone(initalPhaseLifeMatrix, nextPhaseLifeMatrix);
		printMatrix(initalPhaseLifeMatrix);
		//nextPhaseLifeMatrix[0][2]=100;
		System.out.println("Cloned Matrix");
		performTransition(initalPhaseLifeMatrix,nextPhaseLifeMatrix);
		printMatrix(nextPhaseLifeMatrix);
		System.out.println("Cloned Matrix");
		printMatrix(initalPhaseLifeMatrix);


	} 
	
	static void  performTransition(int [][] matrix, int [][]target) {
		// Max row count 
		
		int m = matrix.length;
		int n =  matrix[0].length;
		for(int row=0;row<=m-1;row++) {
			for(int column=0;column<=n-1;column++) {
				
				int rightNeighborValue = (column+1<=n-1)?matrix[row][column+1]:0;
				int leftNeighborValue = (column-1>=0)?matrix[row][column-1]:0;
				
				int topNeighborValue = (row-1>=0)?matrix[row-1][column]:0;
				int downNeighborValue = (row+1<=m-1)?matrix[row+1][column]:0;
				
				
				int topLeftCorner = (row-1>=0)&&(column-1>=0)?matrix[row-1][column-1]:0;
				int topRightCorner = (row-1>=0)&&(column+1<=n-1)?matrix[row-1][column+1]:0;
				
				int bottomLeftCorner = (row+1<=m-1)&&(column-1>=0)?matrix[row+1][column-1]:0;
				int bottomRightCorner = (row+1<=m-1)&&(column+1<=n-1)?matrix[row+1][column+1]:0;
				
				int totalLiveNeighbors = rightNeighborValue+leftNeighborValue+topNeighborValue+downNeighborValue+topLeftCorner+topRightCorner+bottomLeftCorner+bottomRightCorner;
				
				if(matrix[row][column]==1) {
					// Live cell dies by under or over population
					if(totalLiveNeighbors<2 || totalLiveNeighbors >3) {
						target[row][column] =0;
					}else {
						target[row][column] =1;
					}
				}else {
					if(totalLiveNeighbors==3) {
						target[row][column] =1;
					}
				}
			}
	}
	}
	static void  printMatrix(int [][] matrix) {
		int m=matrix.length;
		int n = matrix[0].length;
		for(int i=0;i<=m-1;i++) {
			for(int j=0;j<=n-1;j++) {
				System.out.printf(" %s", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	static void  clone(int [][] source, int [][] destination) {
		int m=source.length;
		int n = source[0].length;
		for(int i=0;i<=m-1;i++) {
			for(int j=0;j<=n-1;j++) {
				destination[i][j] = source[i][j];
			}
			
		}
	}

}
