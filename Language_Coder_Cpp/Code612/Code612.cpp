// Code612.cpp

#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main()
{
	int* arr = new int[5];

	for (int i = 0; i < 5; i++) {
		cin >> arr[i];
	}

	string str = "";

	for (int i = 0; i < 5; i++) {
		str += to_string(arr[i]);
	}

	for (int i = 0; i < str.length(); i += 3) {
		for (int j = i; j < min((int)str.length(), i + 3); j++) {
			cout << str.at(j);
		}
		cout << endl;
	}
}