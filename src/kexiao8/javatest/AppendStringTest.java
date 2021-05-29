package kexiao8.javatest;

public class AppendStringTest{
	public static void main(String[] args){

		String text = "";

		long beginTime = System.currentTimeMillis();
		int times = 200000;
		for (int i = 0; i < times; i++){
			text = text +i;
		}

		long endTime = System.currentTimeMillis();
		System.out.println("plus time cost: " + (endTime - beginTime));

		StringBuilder builder = new StringBuilder("");
		beginTime = System.currentTimeMillis();
		for (int i = 0; i < times; i++){
			builder.append(String.valueOf(i));
		}

		endTime = System.currentTimeMillis();
		System.out.println("string builder time cost: " + (endTime - beginTime));
		//on macbook pro 2013 i7 16G, cost is:43461 vs 10
	}
}
