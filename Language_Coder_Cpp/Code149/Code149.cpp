// Code149.cpp

#include <iostream>
using namespace std;

int main()
{
	int num;
	cin >> num;

	int s = 1;

	for (int i = 0; i < num; i++) {
		for (int j = 0; j < num; j++) {
			cout << s << " ";
			s += 2;
			if (s >= 10) {
				s = 1;
			}
		}
		cout << endl;
	}
}