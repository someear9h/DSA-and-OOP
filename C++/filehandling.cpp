#include <iostream>
#include <fstream> // Include the file handling library
using namespace std;

class Student {
    string name;
    int rollNo;
    float sgpa;

public:
    Student() {} 

    Student(string n, int r, float s) {
        name = n;
        rollNo = r;
        sgpa = s;
    }

    // Getter methods
    string getName() {
        return name;
    }

    int getRoll() {
        return rollNo;
    }

    float getSGPA() {
        return sgpa;
    }

    void display() {
        cout << "| " << name;
        for (int i = name.length(); i < 20; i++) cout << " "; // Adjust spacing for Name
        cout << " | " << rollNo;
        for (int i = to_string(rollNo).length(); i < 10; i++) cout << " "; // Adjust spacing for Roll No
        cout << " | " << sgpa;
        for (int i = to_string(sgpa).length(); i < 6; i++) cout << " "; // Adjust spacing for SGPA
        cout << " |" << endl;
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

// Function to save data to a CSV file
void saveToCSVFile(Student students[], int size, string filename) {
    // Open the file for writing
    ofstream outFile(filename);
    
    // Check if the file was opened successfully
    if (!outFile) {
        cerr << "Error opening file for writing!" << endl;
        return;
    }

    // Write the header row to the CSV file
    outFile << "Name,Roll No,SGPA" << endl;

    // Write each student's data to the CSV file
    for (int i = 0; i < size; i++) {
        outFile << students[i].getName() << ","
                << students[i].getRoll() << ","
                << students[i].getSGPA() << endl;
    }

    // Close the file
    outFile.close();

    // Notify the user that the data has been saved
    cout << "Data saved to " << filename << " successfully!" << endl;
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
        float sgpa;

        cout << "Enter name of student " << i + 1 << ": ";
        getline(cin, name); // Read full name
        cout << "Enter roll number of student " << i + 1 << ": ";
        cin >> rollNo;
        cout << "Enter SGPA of student " << i + 1 << ": ";
        cin >> sgpa;
        cin.ignore(); // Ignore newline after input

        students[i] = Student(name, rollNo, sgpa);
    }

    // Save data to a CSV file
    saveToCSVFile(students, n, "students.csv");

    // Free allocated memory
    delete[] students;

    return 0;
}