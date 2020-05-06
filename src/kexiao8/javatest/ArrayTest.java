package kexiao8.javatest;

public class ArrayTest{
	public static void main(String[] args){
		int[] scores = new int[10];
		System.out.println("no init");
		for (int i = 0; i < scores.length; i++){
			System.out.printf("Score[%d] = %d ", i, scores[i]);
		}

		System.out.println("\n\nafter init");
		int[] scores2 = {90,80,87,85};
		scores = scores2;
		for (int i = 0; i < scores.length; i++){
			System.out.printf("Score[%d] = %d ", i, scores[i]);
		}

		System.out.println("\n\ntwo dim array");
		int[][] arr = { {1,2,3},
			{4,5,6}};
		for(int i = 0; i < arr.length;i++){
			for (int j = 0; j < arr[0].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("\n\nArray copy");
		int[] arrCopy = new int[6];
		System.arraycopy(scores2, 0, arrCopy, 0, scores2.length);

		for (int i = 0; i < scores.length; i++){
			System.out.printf("arrCopy[%d] = %d ", i, arrCopy[i]);
		}

		System.out.println("\n\nthe end");
	}
}
