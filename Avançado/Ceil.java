package problems;

import util.Util;

public class Ceil {
	
	public Integer ceil(Integer[] array, Integer x) {
		if(array.length > 0 && array != null && x != null) {
			quickSort(array, 0, array.length-1);
			return ceil(array, x, null, 0, array.length-1);
		}
		return null;
	}
	
	
	private Integer ceil(Integer[] array, Integer x, Integer ceil, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length && array != null) {
			int meio = (leftIndex + rightIndex) / 2;
			if(array[rightIndex].compareTo(x) < 0) {
				return null;
			}
			
			if(array[meio].compareTo(x) == 0) {
				return array[meio];
			}else if(array[meio].compareTo(x) < 0) {
				return ceil(array, x, array[rightIndex], meio+1, rightIndex);
			}else {
				return ceil(array, x, array[meio], leftIndex, meio-1);
			}
		}
		return ceil;
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
		
		Integer pivot = array[leftIndex];
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
