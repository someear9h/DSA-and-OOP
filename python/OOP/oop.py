class Person:
    # constructor
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def display_info(self):
        print(f"Name: {self.name} and Age: {self.age}")

# create an object
person1 = Person("someone", 17)
person1.display_info()

person2 = Person("sometwo", 22)
person2.display_info()