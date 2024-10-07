public class Singleton {

	static Singleton instance = null;

	private Singleton(){}

	public static Singleton getInstance(){

		synchronized (Singleton.class){
			if(instance == null){
				synchronized (Singleton.class){
					instance = new Singleton();
				}

			}
		}


		return instance;
	}
}
