#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

class Student {
public:
    string name;
    int rollNo;

    Student() {}
    // Constructor to initialize student
    Student(string n, int r) {
        name = n;
        rollNo = r;
    }

    // Method to display student details
    void display() {
        cout << name << "\t" << rollNo << endl;
        cout <<"---------------------------" << endl;
    }

    // Method to compare names (for binary search)
    bool operator <(const Student &other) const {
        return name < other.name;
    }
};

// Binary Search function
int binarySearch(Student students[], int size, string targetName) {
    int low = 0, high = size - 1;

    while (low <= high) {
        int mid = (low + high) / 2;
        if (students[mid].name == targetName) {
            return mid; // Found the student
        } else if (students[mid].name < targetName) {
            low = mid + 1; // Search in the right half
        } else {
            high = mid - 1; // Search in the left half
        }
    }
    return -1; // Student not found
}

int main() {
    int n;
    cout << "Enter number of students: ";
    cin >> n;

    // Dynamically create array of Student objects
    Student students[n];

    // Taking input for student details
    for (int i = 0; i < n; i++) {
        string name;
        int rollNo;
        cout << "\nEnter name of student " << i + 1 << ": ";
        cin.ignore(); // To ignore the newline character left by the previous cin
        getline(cin, name); // Read full name
        cout << "Enter roll number of student " << i + 1 << ": ";
        cin >> rollNo;
        students[i] = Student(name, rollNo);
    }

    // Sort students by name before performing binary search
    sort(students, students + n);

    // Display sorted list of students
    cout << "\nSorted list of students:\n";
    cout << "Name\tRoll No\n";
    for (int i = 0; i < n; i++) {
        students[i].display();
    }

    // Perform binary search for a student's name
    string targetName;
    cout << "\nEnter name of the student to search: ";
    cin.ignore();
    getline(cin, targetName);

    int index = binarySearch(students, n, targetName);

    if (index != -1) {
        cout << "\nStudent Found:\n";
        students[index].display();
    } else {
        cout << "\nStudent not found.\n";
    }

    return 0;
}
