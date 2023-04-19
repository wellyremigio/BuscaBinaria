package br.leda;

public class Ceil {

	public static void main(String[] args) {
		int[] array = {4, 15, 25, 30, 38, 84, 96};
		System.out.println(ceil(array, 95));
	}
	
	public static int ceil(int[] array, int x) {
		return ceil(array, x, 0, array.length - 1);
	}
	
	private static int ceil(int[] array, int x, int left, int right) {
		int result = 0;
		if(!(left > right || left < 0 || right > array.length)) {
			int meio = (left + right) / 2;
			if(x == array[meio]) {
				return array[meio];
			}else if (x > array[meio - 1]) {
				if(x < array[meio]) {
					result = array[meio];
				}else {
					result = ceil(array, x, meio + 1, right);
				}
			}else {
				result = ceil(array, x, left, meio - 1);
			}
		}
		return result;
	}
}
