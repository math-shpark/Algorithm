// Code181.cpp

#include <iostream>
#include <cmath>

using namespace std;

double area(double radius) {
	double pi = 3.141592;
	return (pi * pow(radius, 2));
}

int main()
{
	cout << "radius : ";
	double r; // radius
	cin >> r;

	cout << "area = ";

	cout << fixed;
	cout.precision(3);

	cout << area(r);

}
