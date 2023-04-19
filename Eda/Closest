package br.leda;

public class Closest {

	public static void main(String[] args) {
		int[] array = {4, 15, 25, 30, 38, 84, 96};
		System.out.println(closest(array, 28)); 
	}
	
	
	public static int closest(int[] array, int x) {
		int result = 0;
		int floor = floor(array, x, 0, array.length - 1);
		int ceil = ceil(array, x, 0, array.length - 1);
		int calcularFloor = x - floor;
		int calcularCeil = ceil - x;
		if(calcularFloor <= calcularCeil) {
			result = floor;
		}else {
			result = ceil;
		}
		return result;
	}
	
	public static int floor(int[] array, int x, int left, int right) {
		int result = 0;
		if(!(left > right || left < 0 || right > array.length)) {
			int meio = (left + right) / 2;
			if(x == array[meio]) {
				return array[meio];
			}else if(x < array[meio]) {
				if(x > array[meio - 1]) {
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
	
	public static int ceil(int[] array, int x, int left, int right) {
		int result = 0;
		if(!(left > right || left < 0 || right > array.length)) {
			int meio = (left + right) / 2;
			if(x == array[meio]) {
				return array[meio];
			}else if(x > array[meio - 1]) {
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
