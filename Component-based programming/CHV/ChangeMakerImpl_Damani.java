package change;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ChangeMakerImpl_Damani implements ChangeMaker
{	
	private List<Integer> listOfDenominations;
	
	//part of pre: i <= 0 ==> !denominations.contains(i)
	//Student should figure out other parts of the precondition
	public ChangeMakerImpl_Damani(Set<Integer> denominations)
	{
		assert denominations != null: "Set cannot be null";
		assert !denominations.contains(null): "Set cannot contain null";
		
		List<Integer> newList = new ArrayList<Integer>(denominations);
		Collections.sort(newList);
		Collections.reverse(newList);
		listOfDenominations = newList;
		
	}
	
	//part of post: for i in [0, rv.size() - 1): rv.get(i) > rv.get(i + 1)
	public List<Integer> getDenominations()
	{
		
		return listOfDenominations;
		
	}
	
	public boolean canMakeExactChange(int valueInCents)
	{
		boolean canMakeExactChange = true;
		if(valueInCents == 0)
			return canMakeExactChange;
		
//		for (int i =0; i<=listOfDenominations.size(); i++) {
//			if(valueInCents % listOfDenominations.get(i) == 0) { 
//				return canMakeExactChange;
//			}
//			
//		}
//		return !canMakeExactChange;
		if(valueInCents < 0 || valueInCents < Collections.min(getDenominations()))
			return !canMakeExactChange;
		
		List<Integer> exactChange = new ArrayList<Integer>();
		
		int count = 0;
		for(int i = getDenominations().size() - 1;i >= 0; i--) {
			
			int denominationIndex = getDenominations().get(i);
			exactChange.add(valueInCents / denominationIndex);
			valueInCents -= exactChange.get(count) * denominationIndex;
			count++;
		}
		if (valueInCents == 0)
			return canMakeExactChange;
		return !canMakeExactChange;
		
	}
	
	//part of pre: changeList.size() == getDenominations().size()
		//part of pre: SIZE = changeList.size()
		//part of post: rv == (
		//	getDenominations().get(0)*changeList.get(0) + 
		//	getDenominations().get(1)*changeList.get(1) +
		//	getDenominations().get(2)*changeList.get(2) +
		//					   ...
		//	getDenominations().get(getDenominations().size()-1)*changeList.get(changeList.size()-1)
	public int calculateValueOfChangeList(List<Integer> changeList)
	{
		
		//System.out.println("size of denomination set = " + getDenominations().size());
		assert changeList.size() == getDenominations().size(): "size of changeList and denominationList are different!!";
		int valueOfChange = 0;
		for(int i=getDenominations().size() - 1; i >=0; i--)
		//for(int i=0; i <= getDenominations().size(); i++)
		
		{
			valueOfChange += getDenominations().get(i)*changeList.get(i);
			
		}
		return valueOfChange;

	}

	//part of pre: canMakeExactChange(valueInCents)
	//part of post: calculateValueOfChangeList(rv) == valueInCents
	//part of post: i in (0, rv.size() - 1) => getDenominations.get(i).rv.get(i+1)*getDenominations.get(i+1)
	public List<Integer> getExactChange(int valueInCents)
	{
		assert canMakeExactChange(valueInCents) : "Cannot make exact change";
		List<Integer> exactChange = new ArrayList<Integer>();
		//int count = 0;
		//for(int i = getDenominations().size() - 1; i >=0; i--) {
		for(int i=0; i<getDenominations().size(); i++) {
			
			int denominationIndex = getDenominations().get(i);
			int valueOfChange = valueInCents/denominationIndex;
			exactChange.add(valueOfChange);
			//valueInCents -= exactChange.get(count) * denominationIndex;
			valueInCents -= valueOfChange * listOfDenominations.get(i);
			//count++;
		}
		return exactChange;
	}
	
	public String toString()
	{
		return ("The denomination set is "+ listOfDenominations);
	}
}
