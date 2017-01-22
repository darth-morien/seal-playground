package dramainsweden;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dramainsweden.CalculateRelations;

import org.junit.Test;

public class CalculateRelationsTest {
	
	CalculateRelations a = new CalculateRelations();

	@Test (expected = IllegalArgumentException.class)
	public void testValidateRelations() {
		List<Relations> relList = new ArrayList<Relations>(); 
		relList.add(new Relations(2,2));
		a.validateRelations();
		
	}
	
	@Test 
	public void testBandMembers() {
		List<Relations> relList = new ArrayList<Relations>(); 
		relList.add(new Relations(1,2));
		relList.add(new Relations(2,3));
		relList.add(new Relations(1,3));
		relList.add(new Relations(4,5));
		Set<Integer> actualBandList = new HashSet<>();
		actualBandList.add(1);
		actualBandList.add(2);
		actualBandList.add(3);
		assertEquals(CalculateRelations.figureOutBandMembers(), actualBandList);
	
	}

	
	

}
