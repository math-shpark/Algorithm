// Code554.cpp

#include <iostream>
using namespace std;

int main()
{
	int num;
	cin >> num;

	int numS = 1;
	char charS = 'A';
	int numR = num;
	int charR = 1;
	
	for (int i = 0; i < num; i++) {
		for (int j = 0; j < numR; j++) {
			cout << numS << " ";
			numS++;
		}
		numR--;

		for (int j = 0; j < charR; j++) {
			cout << charS << " ";
			charS++;
		}
		charR++;
		cout << endl;
	}
}