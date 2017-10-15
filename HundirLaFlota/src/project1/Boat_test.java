package project1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Boat_test {

	@Test
	public void test() {
		
		List <Boat>	ships = new ArrayList<Boat>();
		Boat b = new Boat(0,0,1, false, 0);
		ships = b.createBoats();
		
	}

}
