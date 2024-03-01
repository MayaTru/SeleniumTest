import java.util.HashMap;
import java.util.Map;

public class Map_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> m1 = new HashMap<Integer, String>();
		m1.put(1, "One");
		m1.put(1, null);
		System.out.println(m1.get(1));
	}

}
