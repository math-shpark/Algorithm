// Code188.cpp

#include <iostream>
#include <string>
using namespace std;

int main()
{
	string str;

	int idx = 1;
	getline(cin, str);

	cout << idx << ". ";
	for (int i = 0; i < str.length(); i++) {
		if (str.at(i) != ' ') {
			cout << str.at(i);
		}
		else {
			cout << endl;
			idx++;
			cout << idx << ". ";
		}
	}
}