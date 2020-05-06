package kexiao8.javatest;

public class CommandLineArg{
	public static void main(String[] args){
		System.out.print("Input paras:");
		for (int i = 0; i < args.length; ++i){
			System.out.print(args[i] + " ");
		}
		System.out.println();

		for (String arg:args){
			System.out.print(arg + " ");
		}

		System.out.println();
	}
}
