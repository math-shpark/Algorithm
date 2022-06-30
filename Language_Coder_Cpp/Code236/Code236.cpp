// Code236.cpp

#include <iostream>
using namespace std;

int main()
{
	int num1, num2, num3;
	cin >> num1 >> num2 >> num3;

	int multi = num1 * num2 * num3;
	int result = 1;

	while (multi > 0) {
		int num = multi % 10;
		if (num != 0) {
			result *= num;
		}
		multi /= 10;
	}

	cout << result;
}
