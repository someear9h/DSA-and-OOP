#include <iostream>
#include <iomanip> // For setw
using namespace std;

class Student {
    string name;
    int rollNo;

public:
    Student() {} 

    Student(string n, int r) {
        name = n;
        rollNo = r;
    }

    // Getter methods
    string getName() {
        return name;
    }

    int getRoll() {
        return rollNo;
    }

    void display() {
        // Use setw to format the output in a tabular form
        cout << setw(20) << left << name << setw(10) << rollNo << endl;
    }
};

// Bubble sort
void sortStudents(Student students[], int size) {
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (students[j].getRoll() > students[j + 1].getRoll()) {
                // Swap
                Student temp = students[j];
                students[j] = students[j + 1];
                students[j + 1] = temp;
            }
        }
    }
}

int main() {
    cout << "Enter the number of students: ";
    int n;
    cin >> n;
    cin.ignore(); 

    Student* students = new Student[n];

    // Input student details
    for (int i = 0; i < n; i++) {
        string name;
        int rollNo;

        cout << "Enter name of student " << i + 1 << ": ";
        getline(cin, name); // Read full name
        cout << "Enter roll number of student " << i + 1 << ": ";
        cin >> rollNo;
        cin.ignore(); // Ignore newline after roll number input

        students[i] = Student(name, rollNo);
    }

    // Display unsorted students in tabular form
    cout << "\nUnsorted Students:\n";
    cout << setw(20) << left << "Name" << setw(10) << "Roll No" << endl;
    cout << setfill('-') << setw(30) << "" << setfill(' ') << endl; // Separator line
    for (int i = 0; i < n; i++) {
        students[i].display();
    }

    // Sort students by roll number
    sortStudents(students, n);

    // Display sorted students in tabular form
    cout << "\nSorted Students (by Roll No):\n";
    cout << setw(20) << left << "Name" << setw(10) << "Roll No" << endl;
    cout << setfill('-') << setw(30) << "" << setfill(' ') << endl; // Separator line
    for (int i = 0; i < n; i++) {
        students[i].display();
    }

    // Free allocated memory
    delete[] students;

    return 0;
}