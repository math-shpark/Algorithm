// Code124.cpp

#include <iostream>
using namespace std;

int main()
{
	int days[12] = { 31, 28, 31, 30, 31, 30, 31,31,30,31,30,31 };

	int month;
	cin >> month;

	cout << days[month - 1];
}