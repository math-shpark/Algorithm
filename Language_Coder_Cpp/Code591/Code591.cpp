// Code591.cpp

#include <iostream>
using namespace std;

int main()
{
	int num;
	cin >> num;

	int* arr = new int[num + 1];

	arr[1] = 1;

	for (int i = 2; i <= num; i++) {
		arr[i] = arr[i / 2] + arr[i - 1];
	}

	cout << arr[num];
}