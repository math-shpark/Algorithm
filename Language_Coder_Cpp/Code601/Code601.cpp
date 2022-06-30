// Code601.cpp

#include <iostream>
using namespace std;

int main()
{
	string str;
	cin >> str;

	char* arr = new char[str.length()];

	for (int i = 0; i < str.length(); i++) {
		arr[i] = str.at(i);
	}

	int idx = str.length() - 1;

	while (idx >= 0) {
		for (int i = idx; i < idx + str.length(); i++) {
			cout << arr[i % str.length()];
		}
		idx--;
		cout << endl;
	}
}