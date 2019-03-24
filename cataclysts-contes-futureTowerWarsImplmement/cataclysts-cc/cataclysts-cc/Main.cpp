#include <iostream>
#include <fstream>
#include <vector>
#define x first.first
#define y first.second
#include <string>
#define epsilon 0.0001
using namespace std;


enum orientation
{
	RIGHT,
	DOWN,
	LEFT,
	UP

};
vector<vector<int> > alienWalk;
fstream fin("level4_1.in");
ofstream fout("level4_1.out");
pair<pair<long long, long long>, int> finalPosition;
vector<pair<int, int> > path;

//////////////////////
void getCommand(char command, int steps) {
	if (command == 'F') {

		if (finalPosition.second == 0) {
			finalPosition.x += steps;
		}
		else if (finalPosition.second == 1) {
			finalPosition.y += steps;
		}
		else if (finalPosition.second == 2) {
			finalPosition.x -= steps;
		}
		else if (finalPosition.second == 3) {
			finalPosition.y -= steps;
		}

	}
	else if (command == 'T') {
		finalPosition.second += steps;
		finalPosition.second %= 4;
	}
}

void startMovement() {
	fin >> finalPosition.x;
	fin >> finalPosition.y;
	finalPosition.second = 0;

	char COMMAND;
	int STEPS;
	while (fin >> COMMAND >> STEPS) {
		getCommand(COMMAND, STEPS);
	}
	fout << finalPosition.x << " " << finalPosition.y;
}
//////////////////////
/*Level 2*/
//////////////////////

void turn(int steps) {
	finalPosition.second += steps;
	finalPosition.second %= 4;
}

int DEFEND_X;
int DEFEND_Y;
void forward(int steps) {

	if (finalPosition.second == 0) {
		//finalPosition.x += steps;
		for (int i = 0; i < steps; i++) {
			cout << finalPosition.x++ << " " << finalPosition.y << endl;
			//fout << finalPosition.x++ << " " << finalPosition.y << endl;
			path.push_back({ finalPosition.x, finalPosition.y });
			DEFEND_X = finalPosition.x + 1;
			DEFEND_Y = finalPosition.y;
		}
	}
	else if (finalPosition.second == 1) {
		//finalPosition.y += steps;
		for (int i = 0; i < steps; i++) {
			cout << finalPosition.x << " " << finalPosition.y++ << endl;
			//fout << finalPosition.x << " " << finalPosition.y++ << endl;
			path.push_back({ finalPosition.x, finalPosition.y });

			DEFEND_X = finalPosition.x;
			DEFEND_Y = finalPosition.y + 1;
		}
	}
	else if (finalPosition.second == 2) {
		//finalPosition.x -= steps;
		for (int i = 0; i < steps; i++) {
			cout << finalPosition.x-- << " " << finalPosition.y << endl;
			//fout << finalPosition.x-- << " " << finalPosition.y << endl;
			path.push_back({ finalPosition.x, finalPosition.y });

			DEFEND_X = finalPosition.x - 1;
			DEFEND_Y = finalPosition.y;
		}
	}
	else if (finalPosition.second == 3) {
		//finalPosition.y -= steps;
		for (int i = 0; i < steps; i++) {
			cout << finalPosition.x << " " << finalPosition.y-- << endl;
			//fout << finalPosition.x << " " << finalPosition.y-- << endl;
			path.push_back({ finalPosition.x, finalPosition.y });

			DEFEND_X = finalPosition.x;
			DEFEND_Y = finalPosition.y - 1;
		}
	}
}

void getAlienPath() {

	int WX, WY;
	fin >> WX >> WY;
	fin >> finalPosition.x;
	fin >> finalPosition.y;
	finalPosition.second = 0;
	char COMMAND;
	int STEPS;
	while (fin >> COMMAND >> STEPS) {
		if (COMMAND == 'F') {
			forward(STEPS);
		}
		else {
			turn(STEPS);
		}
	}
	fout << finalPosition.x << " " << finalPosition.y << endl;
}
//////////////////////
/*Level 3*/
//////////////////////
vector<int> aliensSpawnTime;
vector<double> aliensHealth;
void level3() {
	int WX, WY;
	fin >> WX >> WY;
	fin >> finalPosition.x;
	fin >> finalPosition.y;
	path.push_back({ finalPosition.x, finalPosition.y });
	finalPosition.second = 0;
	string COMMAND;
	double alienSpeed;
	int STEPS;
	while (1) {
		fin >> COMMAND;
		if (COMMAND.compare("F") == 0) {
			fin >> STEPS;
			forward(STEPS);
		}
		else if (COMMAND.compare("T") == 0) {
			fin >> STEPS;
			turn(STEPS);
		}
		else {
			alienSpeed = stod(COMMAND);
			break;
		}
	}
	cout << finalPosition.x << " " << finalPosition.y << endl;
	path.push_back({ finalPosition.x, finalPosition.y });
	int nrAliens;
	fin >> nrAliens;
	cout << (double)alienSpeed << endl << nrAliens << '\n';
	for (int i = 0; i < nrAliens; i++) {
		int alienTick;
		fin >> alienTick;
		aliensSpawnTime.push_back(alienTick);
		cout << alienTick << endl;
	}
	int nrOfQueries;
	fin >> nrOfQueries;
	cout << nrOfQueries << endl;
	for (int i = 0; i < nrOfQueries; i++) {
		int afterTick, alienID;
		fin >> afterTick >> alienID;
		fout << afterTick << " " << alienID << " ";
		fout << path[int((afterTick - aliensSpawnTime[alienID])*alienSpeed)].first << " " << path[int((afterTick - aliensSpawnTime[alienID])*alienSpeed)].second << endl;
	}
}
//////////////////////
/*Level 4*/
//////////////////////

class Tower {
public:
	double damage;
	int range;
	int xCoor;
	int yCoor;
	int locked = -1;
	Tower(double damage, int range, int xCoor, int yCoor) {
		this->damage = damage;
		this->range = range;
		this->xCoor = xCoor;
		this->yCoor = yCoor;

	}
	void printData() {
		cout << damage << " " << range << " " << xCoor << " " << yCoor;
	}
};
class Alien {
public:
	double health;
	double speed;
	int alienTick;
	bool alive = true;
	Alien(double health, double speed, int alienTick) {
		this->health = health;
		this->speed = speed;
		this->alienTick = alienTick;
	}
	void checkStatus() {
		if (health <= 0) {
			alive = false;
		}
	}
	void checkWin() {

	}
};

double distanceCalculate(int x1, int y1, int x2, int y2)
{
	int xC = x1 - x2; //calculating number to square in next step
	int yC = y1 - y2;
	double dist;

	dist = pow(xC, 2) + pow(yC, 2);       //calculating Euclidean distance
	dist = sqrt(dist);

	return dist;
}
int WX, WY;
double alienSpeed;
double alienHealthh;
string COMMAND;
int nrAliens;
int STEPS;
double towerDamage;
int towerRange;
int nrOfTowers;
vector<Tower> towers;
void getData() {
	fin >> WX >> WY;
	fin >> finalPosition.x;
	fin >> finalPosition.y;
	path.push_back({ finalPosition.x, finalPosition.y });
	finalPosition.second = 0;
	while (1) {
		fin >> COMMAND;
		if (COMMAND.compare("F") == 0) {
			fin >> STEPS;
			forward(STEPS);
		}
		else if (COMMAND.compare("T") == 0) {
			fin >> STEPS;
			turn(STEPS);
		}
		else {
			alienHealthh = stod(COMMAND);
			break;
		}
	}
	fin >> alienSpeed;
	cout << finalPosition.x << " " << finalPosition.y << endl;
	path.push_back({ finalPosition.x, finalPosition.y });

	fin >> nrAliens;
	cout << alienHealthh << " " << (double)alienSpeed << endl << nrAliens << '\n';


	for (int i = 0; i < nrAliens; i++) {
		int alienTick;			// tick pt fiecare alien id
		fin >> alienTick;
		aliensSpawnTime.push_back(alienTick);   // la ce tick se spawneaza
		aliensHealth.push_back(alienHealthh);
		cout << alienTick << endl;
	}

	fin >> towerDamage >> towerRange >> nrOfTowers;
	cout << nrOfTowers << endl;
	for (int i = 0; i < nrOfTowers; i++)
	{
		int towerX, towerY;
		fin >> towerX >> towerY;
		Tower *temp = new Tower(towerDamage, towerRange, towerX, towerY);
		towers.push_back(*temp);
	}


	//for (int i = 0; i < nrOfQueries; i++) {
		//int afterTick, alienID;
		//fin >> afterTick >> alienID;    
		//fout << afterTick << " " << alienID << " ";
		//fout << path[int((afterTick - aliensSpawnTime[alienID])*alienSpeed)].first << " " << path[int((afterTick - aliensSpawnTime[alienID])*alienSpeed)].second<<endl;
	//}
}
int searchClosest(int timp, Tower temp) {
	pair<int, double> closestAlien;
	closestAlien.second = INT_MAX;
	for (int i = 0; i < aliensHealth.size(); i++)
	{
		if (timp - aliensSpawnTime[i] >= 0) {
			int xAlien = path[int((timp - aliensSpawnTime[i])*alienSpeed)].first;
			int yAlien = path[int((timp - aliensSpawnTime[i])*alienSpeed)].second;


			double dist = distanceCalculate(xAlien, yAlien, temp.xCoor, temp.yCoor);
			if (temp.range - dist <= epsilon) {
				if (dist < closestAlien.second) {
					closestAlien.second = dist;
					closestAlien.first = i;
				}
			}


		}
	}
	if (closestAlien.second != INT_MAX) {
		return closestAlien.first;
	}
}
void shoot(int id, Tower temp) {
	aliensHealth[id] -= temp.damage;
}
int verifyAlien(int id, Tower temp, int timp) {
	if (aliensHealth[id] <= 0) {
		return 1;
	}
	if (timp - aliensSpawnTime[id] >= 0) {
		int xAlien = path[int((timp - aliensSpawnTime[id])*alienSpeed)].first;
		int yAlien = path[int((timp - aliensSpawnTime[id])*alienSpeed)].second;
		double dist = distanceCalculate(xAlien, yAlien, temp.xCoor, temp.yCoor);
		if (temp.range - dist <= epsilon) {
			if (dist > temp.range) {
				return -1;
			}
		}
		shoot(id, temp);
	}
	return 0;
}

int checkAlienEnd(int timp) {

	for (int i = 0; i < aliensHealth.size(); i++) {
		if (timp - aliensSpawnTime[i] >= 0) {
			int xAlien = path[int((timp - aliensSpawnTime[i])*alienSpeed)].first;
			int yAlien = path[int((timp - aliensSpawnTime[i])*alienSpeed)].second;
			if (xAlien == DEFEND_X && yAlien == DEFEND_Y) {
				return  1;
			}
		}
	}
	return 0;
}
int checkDeadAliens() {
	if (aliensSpawnTime.size() == 0) {
		return 1;
	}
	return 0;
}
void game() {
	int timp = 0;
	while (1) {

		if (checkAlienEnd(timp) == 1) {
			cout << "LOSS";
			break;
		}
		for (int i = 0; i < towers.size(); i++)
		{
			if (towers[i].locked == -1) {
				int target = searchClosest(timp, towers[i]);
				towers[i].locked = target;
				if (timp != 0) { shoot(target, towers[i]); }
			}
			else {
				int check = verifyAlien(towers[i].locked, towers[i], timp);
				if (check == 1) {
					aliensHealth.erase(aliensHealth.begin() + towers[i].locked);
					aliensSpawnTime.erase(aliensSpawnTime.begin() + towers[i].locked);
					for (int i = 0; i < towers.size(); i++)
					{
						if (towers[i].locked != -1) {
							towers[i].locked -= 1;
						}
					}
				}
				else if (check == -1) {
					towers[i].locked = -1;
				}
			}
		}


		if (checkDeadAliens() == 1) {
			cout << "WIN";
			fout << timp << endl << "WIN";
			break;
		}


		timp++;
	}

}
int main() {
	//startMovement();
	getData();
	game();
	system("PAUSE");
}