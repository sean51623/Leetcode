import java.util.*;

public class IterateMap {
	public static void main(String[] args) {
		HashMap<Integer, String> rec = new HashMap<>();
		rec.put(1106, "Sean");
		rec.put(1101, "Fanya");
		rec.put(1121, "PeiI");
		
		for (HashMap.Entry<Integer, String> ent: rec.entrySet()) {
			System.out.println(ent.getKey()+", "+ent.getValue());
		}
	}
}