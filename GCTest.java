class GCBase{
	private String name;
	public GCBase(String name){
		this.name = name;
		System.out.println(name + " init");
	}

	protected void finalize(){
		System.out.println(name + " destroyed!");
	}
}

public class GCTest{
	public static void main(String[] args){

		GCBase base1 = new GCBase("obj one");
		GCBase base2 = new GCBase("obj two");
		GCBase base3 = new GCBase("obj three");

		base1 = null;
		base2 = null;
		base3 = null;

		System.gc();

		while(true);
	}
}
