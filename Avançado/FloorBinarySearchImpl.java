package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if(array != null && array.length > 0 && x != null) {
			quickSort(array, 0, array.length-1);
			return floor(array, x, null, 0, array.length-1);
		}
		return null;
	}
	
	private Integer floor(Integer[] array, Integer x,  Integer floor, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length && array != null) {
			int meio = (leftIndex + rightIndex) / 2;
			if(array[meio].compareTo(x) == 0) {
				return array[meio];
				
			}else if(array[meio].compareTo(x) < 0) {
				return floor(array, x, array[meio], meio+1, rightIndex);
				
			}else {
				return floor(array, x, floor, leftIndex, meio-1);
			}
		}
		return floor;
	}
	
	private void quickSort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length && array != null) {
			int pivot = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivot-1);
			quickSort(array, pivot+1, rightIndex);
		}
	}
	
	private int partition(Integer[] array, int leftIndex, int rightIndex) {
		int indexPivot = calcularPivotAleatorio(leftIndex, rightIndex);
		Util.swap(array, leftIndex, indexPivot);
		
		int pivot = array[leftIndex];
		int i = leftIndex;
		
		for(int j = leftIndex + 1; j <= rightIndex; j++) {
			if(array[j].compareTo(pivot) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;		
	}
	
	private int calcularPivotAleatorio(int leftIndex, int rightIndex) {
		int range = (rightIndex - leftIndex) + 1;
		return (int) (Math.random() * range) + leftIndex;
	}
}
