package br.leda;

public class Floor {

	public static void main(String[] args) {
		int[] array = {4, 15, 25, 30, 38, 84, 96};
		System.out.println(floor(array, 14));
	}
	
	public static int floor(int[] array, int x) {
		return floor(array, x, 0, array.length - 1);
	}
	
	private static int floor(int[] array, int x, int left, int right) {
		int result = 0;
		if(left <= right && left >= 0 && right <= array.length) {
			int meio = (left + right) / 2;
			if(x == array[meio]) {
				result = array[meio];
			}else if(x < array[meio]) {
				if(array[meio - 1] < x) {
					result = array[meio - 1];
				}else {
					result = floor(array, x, left, meio - 1);
				}
			}else {
				result = floor(array, x, meio + 1, right);
			}
		}
		return result;
	}

}
