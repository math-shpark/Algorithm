﻿// Code632.cpp

#include <iostream>
using namespace std;

int main()
{
	int num1, num2, num3;

	cin >> num1 >> num2 >> num3;

	int min = num1 < num2 ? num1 : num2;
	min = min < num3 ? min : num3;

	cout << min;
}