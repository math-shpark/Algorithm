// Code129.cpp

#include <iostream>
using namespace std;

int main()
{
	while (true) {
		cout << "Base = ";
		int base; // Base
		cin >> base;

		cout << "Height = ";
		int height; // Height
		cin >> height;

		double area = base * (double)height * 0.5;

		cout << fixed;
		cout.precision(1);

		cout << "Triangle width = " << area << endl;

		cout << "Continue? ";

		string command;
		cin >> command;
		if (command == "Y" || command == "y") {
			continue;
		}
		else {
			break;
		}
	}
}