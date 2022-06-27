// Code159.cpp

#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	int person;
	cin >> person;

	int* arr = new int[person];

	for (int i = 0; i < person; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + person);

	for (int i = person - 1; i >= 0; i--) {
		cout << arr[i] << endl;
	}
}