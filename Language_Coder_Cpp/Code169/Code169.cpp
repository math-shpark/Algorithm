// Code169.cpp

#include <iostream>
using namespace std;

int main()
{
	char** arr = new char* [3];

	for (int r = 0; r < 3; r++) {
		arr[r] = new char[5];
	}

	for (int r = 0; r < 3; r++) {
		for (int c = 0; c < 5; c++) {
			cin >> arr[r][c];
			arr[r][c] += 32;
		}
	} // input

	for (int r = 0; r < 3; r++) {
		for (int c = 0; c < 5; c++) {
			cout << arr[r][c] << " ";
		}
		cout << endl;
	} // print
}