// Code115.cpp

#include <iostream>
using namespace std;

int main()
{
	int mH, mW, kH, kW;
	cin >> mH >> mW >> kH >> kW;

	if (mH > kH && mW > kW) {
		cout << 1;
	}
	else {
		cout << 0;
	}
}