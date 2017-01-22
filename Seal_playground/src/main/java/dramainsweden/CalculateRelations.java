package dramainsweden;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class CalculateRelations {
	
	

	private List<Relations> relationsList = new ArrayList<>();
	
	public CalculateRelations(List<Relations> relationsList) {
		this.relationsList = relationsList;
	}

	private Set<Integer> bandList = new HashSet<>();

	public Set<Integer> getBandList() {
		return bandList;
	}

	public List<Relations> getRelationsList() {
		return relationsList;
	}

	public Set<Integer> figureOutBandMembers() {
		//validateRelations();
		
		int currentFirstPerson = 0;
		int currentSecondPerson = 0;

		for (Relations relation : relationsList) {
			int firstPerson = relation.getId1();
			int secondPerson = relation.getId2();

			if (currentFirstPerson == firstPerson) {
				bandList.add(firstPerson);
				bandList.add(currentSecondPerson);
			}

			if (currentSecondPerson == firstPerson) {
				bandList.add(firstPerson);
				bandList.add(currentFirstPerson);
			}

			if (currentFirstPerson == secondPerson) {
				bandList.add(secondPerson);
				bandList.add(currentSecondPerson);
			}

			if (currentSecondPerson == secondPerson) {
				bandList.add(secondPerson);
				bandList.add(currentFirstPerson);
			}

			currentFirstPerson = firstPerson;
			currentSecondPerson = secondPerson;
		}
		return bandList;

	}

	public void validateRelations() {
		for (Relations relation : relationsList) {
			int firstPerson = relation.getId1();
			int secondPerson = relation.getId2();

			if (firstPerson == secondPerson) {
				throw new IllegalArgumentException("Ids are duplicated");
			}

		}
	}

}
