// Code525.cpp

#include <iostream>
using namespace std;

int main()
{
	int num1, num2, num3;
	cin >> num1 >> num2 >> num3;

	if (num1 > num2 && num1 > num3) {
		cout << 1;
	}
	else {
		cout << 0;
	}

	cout << " ";

	if (num1 == num2 && num2 == num3) {
		cout << 1;
	}
	else {
		cout << 0;
	}
}