#include <iostream>
#include <string>
using namespace std;

struct Employee {
    int id;
    string name;
    float salary;

    // Display employee details
    void display() {
        cout << name << '\t' << id << '\t' << salary << endl;
    }
};

// Insert new employee into sorted position
void insertEmployee(Employee employees[], int size, int &count) { 
    int flag = 0;  // Flag to check if insertion happened

    if(count >= size) { 
        cout <<"No space left for inserting employee" << endl;
        return;
    }

    Employee newEmp;
    cout << "\nEnter details for new Employee:\n";
    cout << "Enter Name: ";
    cin.ignore();
    getline(cin, newEmp.name);
    cout << "Enter ID: ";
    cin >> newEmp.id;
    cout << "Enter Salary: ";
    cin >> newEmp.salary;

    // Sorting by ID
    int i = count - 1;
    while(i >= 0 && employees[i].id > newEmp.id) {
        employees[i + 1] = employees[i]; // Shift elements right
        i--;
    }
    employees[i + 1] = newEmp; // Insert at correct position
    count++; // Update count globally
    flag = 1; // Set flag to indicate successful insertion

    if(flag) {
        cout << "Employee inserted successfully!" << endl;
    } else {
        cout << "Error: Employee could not be inserted!" << endl;
    }
}

int main() {
    int size = 5; 
    Employee employees[size]; // Array of Employees
    int count = 0;

    cout << "Enter the number of employees (max " << size << "): ";
    cin >> count;

    if(count > size) {
        cout << "Error: Number of employees exceeds max limit!" << endl;
        return 1;
    }

    // Taking input for initial employees
    for (int i = 0; i < count; i++) {
        cout << "\nEnter details for Employee " << i + 1 << ":\n";
        cout << "Enter Name: ";
        cin.ignore();
        getline(cin, employees[i].name);
        cout << "Enter ID: ";
        cin >> employees[i].id;
        cout << "Enter Salary: ";
        cin >> employees[i].salary;
    }

    // Display initial employees
    cout << "\nInitial Employee List:\n";
    cout << "---------------------------------\n";
    cout << "Name\tID\tSalary\n";
    cout << "---------------------------------\n";
    for (int i = 0; i < count; i++) {
        employees[i].display();
    }

    // Insert a new employee
    insertEmployee(employees, size, count);

    // Display updated employee list
    cout << "\nUpdated Employee List:\n";
    cout << "---------------------------------\n";
    cout << "Name\tID\tSalary\n";
    cout << "---------------------------------\n";
    for (int i = 0; i < count; i++) {
        employees[i].display();
    }

    return 0;
}
