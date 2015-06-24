package rishabhSQL;

public class Main {

	public static void main(String[] args) {
		MySQLAccess a = new MySQLAccess(args[0], args[1]);
		a.insert("Rishabh", 1200000);
		a.insert("Ritesh", 12000000);
		//a.Display();
		a.deleteByName("Rishabh");
		a.deleteByName("Ritesh");
		a.close();
	}

}
