// Code139.cpp

#include <iostream>
using namespace std;

int main()
{
	int num1, num2;
	cin >> num1 >> num2;

	int add;
	if (num1 <= num2) {
		add = 1;
	}
	else {
		add = -1;
	}

	for (int i = 1; i <= 9; i++) {
		for (int j = num1; num1 <= num2 ? j <= num2 : j >= num2; j += add) {
			cout << j << " * " << i << " =";

			if (i * j >= 10) {
				cout << " ";
			}
			else {
				cout << "  ";
			}

			cout << i * j << "   ";
		}
		cout << endl;
	}
}