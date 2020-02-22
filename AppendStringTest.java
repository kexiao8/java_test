public class AppendStringTest{
	public static void main(String[] args){

		String text = "";

		long beginTime = System.currentTimeMillis();
		int times = 10000;
		for (int i = 0; i < times; i++){
			text = text +i;
		}

		long endTime = System.currentTimeMillis();
		System.out.println("exeu time: " + (endTime - beginTime));

		StringBuilder builder = new StringBuilder("");
		beginTime = System.currentTimeMillis();
		for (int i = 0; i < times; i++){
			builder.append(String.valueOf(i));
		}

		endTime = System.currentTimeMillis();
		System.out.println("exeu time: " + (endTime - beginTime));
	}
}
