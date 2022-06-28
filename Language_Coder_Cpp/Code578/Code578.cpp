// Code578.cpp 

#include <iostream>
using namespace std;

void multiply(int num) {
	cout << "== " << num << "dan ==" << endl;
	for (int i = 1; i <= 9; i++) {
		cout << num << " * " << i << " =";
		if (num * i >= 10) {
			cout << " ";
		}
		else {
			cout << "  ";
		}
		cout << num * i << endl;
	}
	cout << endl;
}

int main()
{
	int num1, num2;
	cin >> num1 >> num2;

	if (num1 >= num2) {
		int temp = num1;
		num1 = num2;
		num2 = temp;
	} // swap

	for (int i = num1; i <= num2; i++) {
		multiply(i);
	}
}