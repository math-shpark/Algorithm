﻿// Code563.cpp

#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	int* arr = new int[10];

	for (int i = 0; i < 10; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + 10);

	for (int i = 9; i >= 0; i--) {
		cout << arr[i] << " ";
	}
}