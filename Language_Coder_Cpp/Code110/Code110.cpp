// Code110.cpp

#include <iostream>
using namespace std;

int main()
{
	cout << "yard? ";

	double yard;
	cin >> yard;

	cout << fixed;
	cout.precision(1);

	double centi = yard * 91.44;

	cout << yard << "yard = ";


	cout << centi << "cm";
}