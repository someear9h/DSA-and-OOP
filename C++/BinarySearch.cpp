#include <iostream>
using namespace std;

class Student {
    char name[30];
    int rollNo;
    float sgpa;

public:
    Student() {} // default constructor

    Student(char* n, int r, float s) {
        int i = 0;
        while (n[i] != '\0' && i < 29) {
            name[i] = n[i];
            i++;
        }
        name[i] = '\0'; // '\0' -> null terminated
        rollNo = r;
        sgpa = s;
    }

    char* getName() {
        return name;
    }

    void display() {
        cout << "Name: " << name << ", Roll No: " << rollNo << ", SGPA: " << sgpa << endl;
    }

    // Method to compare names
    int compareName(char* targetName) {
        int i = 0;
        while (name[i] != '\0' && targetName[i] != '\0') {
            if (name[i] > targetName[i]) return 1;
            if (name[i] < targetName[i]) return -1;
            i++;
        }
        if (name[i] == '\0' && targetName[i] == '\0') return 0;
        return name[i] == '\0' ? -1 : 1;
    }
};

// Binary search for student by name
int binarySearch(Student students[], int size, char* targetName) {
    int low = 0, high = size - 1;

    while (low <= high) {
        int mid = (low + high) / 2;
        int comparison = students[mid].compareName(targetName);
        if (comparison == 0) {
            return mid; // target student
        } else if (comparison < 0) {
            low = mid + 1; // Right half
        } else {
            high = mid - 1; // Left half
        }
    }
    return -1; // Not found
}

// Bubble sort students by name
void sortStudents(Student students[], int size) {
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (students[j].compareName(students[j + 1].getName()) > 0) {
                // Swap
                Student temp = students[j];
                students[j] = students[j + 1];
                students[j + 1] = temp;
            }
        }
    }
}

int main() {
    int n;
    cout << "Enter the number of students: ";
    cin >> n;
    cin.ignore(); 

    // Dynamically allocate memory for students
    Student* students = new Student[n];

    for (int i = 0; i < n; i++) {
        char name[30];
        int rollNo;
        float sgpa;

        cout << "Enter details for student " << i + 1 << endl;
        cout << "Name: ";
        cin.getline(name, 30); // Read name
        cout << "Roll No: ";
        cin >> rollNo;
        cout << "SGPA: ";
        cin >> sgpa;
        cin.ignore(); // Ignore leftover newline character

        students[i] = Student(name, rollNo, sgpa);
    }

    
    sortStudents(students, n);

    
    cout << "\nSorted list of students:\n";
    for (int i = 0; i < n; i++) {
        students[i].display();
    }

    char targetName[30];
    cout << "\nEnter the name of the student to search: ";
    cin.getline(targetName, 30);

    int index = binarySearch(students, n, targetName);

    if (index != -1) {
        cout << "\nStudent Found:\n";
        students[index].display();
    } else {
        cout << "\nStudent not found.\n";
    }

    // free memory
    delete[] students;

    return 0;
}
