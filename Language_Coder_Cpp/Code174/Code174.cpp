// Code174.cpp

#include <iostream>
using namespace std;

int add(int num1, int num2, int num3) {
	return num1 + num2 + num3;
}

int main()
{
	int** arr = new int* [4];

	for (int r = 0; r < 4; r++) {
		arr[r] = new int[4];
	}

	for (int r = 0; r < 3; r++) {
		for (int c = 0; c < 3; c++) {
			cin >> arr[r][c];
		}
	} // data input

	for (int c = 0; c < 3; c++) {
		arr[3][c] = add(arr[0][c], arr[1][c], arr[2][c]);
	}

	for (int r = 0; r < 4; r++) {
		arr[r][3] = add(arr[r][0], arr[r][1], arr[r][2]);
	}

	for (int r = 0; r < 4; r++) {
		for (int c = 0; c < 4; c++) {
			cout << arr[r][c] << " ";
		}
		cout << endl;
	}
}