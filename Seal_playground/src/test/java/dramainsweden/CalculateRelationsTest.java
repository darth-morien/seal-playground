package dramainsweden;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dramainsweden.CalculateRelations;

import org.junit.Test;

public class CalculateRelationsTest {
	
	

	/*@Test (expected = IllegalArgumentException.class)
	public void testValidateRelations() {
		List<Relations> relList = new ArrayList<Relations>(); 
		relList.add(new Relations(2,2));
		calc.validateRelations();
		
	}*/
	
	@Test 
	public void testBandMembers() {
		List<Relations> relList = new ArrayList<Relations>(); 
		relList.add(new Relations(1,2));
		relList.add(new Relations(2,3));
		relList.add(new Relations(1,3));
		relList.add(new Relations(4,5));
		Set<Integer> expectedBandList = new HashSet<>();
		expectedBandList.add(1);
		expectedBandList.add(2);
		expectedBandList.add(3);
		CalculateRelations calc = new CalculateRelations(relList);
		calc.figureOutBandMembers();
		assertArrayEquals(expectedBandList.toArray(), calc.getBandList().toArray());
	
	}

	
	

}
