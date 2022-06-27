// Code633.cpp

#include <iostream>
using namespace std;

int main()
{
	while (true) {
		cout << "1. Korea" << endl;
		cout << "2. USA" << endl;
		cout << "3. Japan" << endl;
		cout << "4. China" << endl;
		cout << "number? ";

		int num;
		cin >> num;

		cout << endl;

		switch (num) {
		case 1 :
			cout << "Seoul" << endl;
			break;
		case 2:
			cout << "Washington" << endl;
			break;
		case 3:
			cout << "Tokyo" << endl;
			break;
		case 4:
			cout << "Beijing" << endl;
			break;
		default :
			goto End;
		}

		cout << endl;
	}

End: cout << "none" << endl;
}