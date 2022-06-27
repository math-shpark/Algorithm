// Code548.cpp

#include <iostream>
using namespace std;

int main()
{
	for (int i = 2; i <= 4; i++) {
		for (int j = 1; j <= 5; j++) {
			cout << i << " * " << j << " =";

			if (i * j >= 10) {
				cout << " ";
			}
			else {
				cout << "  ";
			}

			cout << i * j<<"   ";
		}
		cout << endl;
	}
}