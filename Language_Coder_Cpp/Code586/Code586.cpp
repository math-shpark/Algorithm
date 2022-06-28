// Code586.cpp

#include <iostream>
#include <cmath>
using namespace std;

void func1(int num1, int num2) {
	cout << "(" << num1 << " - " << num2 << ") ^ " << 2 << " = " << (int)pow((num1 - num2), 2) << endl;
}

void func2(int num1, int num2) {
	cout << "(" << num1 << " + " << num2 << ") ^ " << 3 << " = " << (int)pow((num1 + num2), 3) << endl;
}

int main()
{
	int num1, num2;
	cin >> num1 >> num2;
	func1(num1, num2);
	func2(num1, num2);
}