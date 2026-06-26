package FirstOne_26_06_26;

public class SingletonOne {
	private static SingletonOne instance;
	private SingletonOne() {}
		public static synchronized SingletonOne getInstance() {
			if (instance == null) instance = new SingletonOne();
			return instance;
				
	}
		public static void main(String[] args) {
		
			SingletonOne s2=SingletonOne.getInstance();
			SingletonOne s1= SingletonOne.getInstance();

			System.out.println(s1==s2);
		
		}

}
