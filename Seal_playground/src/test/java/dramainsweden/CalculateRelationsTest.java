package dramainsweden;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dramainsweden.CalculateRelations;

import org.junit.Test;

public class CalculateRelationsTest {
	
	

	@Test (expected = IllegalArgumentException.class)
	public void testValidateRelationsWithDuplicates() {
		List<Relations> relList = new ArrayList<Relations>(); 
		relList.add(new Relations(2,2));
		CalculateRelations calc = new CalculateRelations(relList);
		calc.validateRelations();
		
	}
	
	@Test 
	public void testValidateRelationsWithOutDuplicates() {
		List<Relations> relList = new ArrayList<Relations>(); 
		relList.add(new Relations(1,2));
		CalculateRelations calc = new CalculateRelations(relList);
		calc.validateRelations();
		
	}
	
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
	
	@Test (expected = IllegalArgumentException.class)
	public void testBandMembers_dupl() {
		List<Relations> relList = new ArrayList<Relations>(); 
		relList.add(new Relations(2,2));
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
	
	@Test 
	public void testBandMembers_everyone() {
		List<Relations> relList = new ArrayList<Relations>(); 
		relList.add(new Relations(51,62));
		relList.add(new Relations(52,62));
		relList.add(new Relations(53,62));
		relList.add(new Relations(62,133));
		relList.add(new Relations(133,51));
		relList.add(new Relations(53,133));
		Set<Integer> expectedBandList = new HashSet<>();
		expectedBandList.add(51);
		expectedBandList.add(52);
		expectedBandList.add(53);
		expectedBandList.add(62);
		expectedBandList.add(133);
		CalculateRelations calc = new CalculateRelations(relList);
		calc.figureOutBandMembers();
		assertArrayEquals(expectedBandList.toArray(), calc.getBandList().toArray());
	
	}



	
	

}
