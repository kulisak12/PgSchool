#include <iostream>

int spoctiTecky(std::string z) {
	if (z == "M" || z == "O" || z == "T" || z == "0") {
		return 0;
	}
	if (z == "A" || z == "E" || z == "G" || z == "J" || z == "K" || z == "N" || z == "Q" || z == "W" || z == "Y" || z == "1" || z == "9") {
		return 1;
	}
	if (z == "C" || z == "D" || z == "I" || z == "P" || z == "R" || z == "U" || z == "X" || z == "Z" || z == "2" || z == "8") {
		return 2;
	}
	if (z == "B" || z == "F" || z == "L" || z == "S" || z == "V" || z == "3" || z == "7") {
		return 3;
	}
	if (z == "H" || z == "4" || z == "6") {
		return 4;
	}
	if (z == "5") {
		return 5;
	}
	throw 1;
}

int main() {
	std::string znak;
	
	int pocetTecek = 0;
	std::cin >> znak;
	while (znak != "konec") {
		pocetTecek += spoctiTecky(znak);
		std::cin >> znak;
	}
	
	std::cout << pocetTecek;
	std::cin.get();
	std::cin.get();
}