import math

class Circle:
    def __init__(self, radius):
        self.radius = radius

    def get_area(self):
        """Calculate area of the circle"""
        return math.pi * self.radius ** 2

class Cylinder(Circle):
    def __init__(self, radius, height):
        super().__init__(radius)
        self.height = height

    def get_area(self):
        """Override to calculate surface area of the cylinder"""
        circle_area = super().get_area()
        side_area = 2 * math.pi * self.radius * self.height
        return 2 * circle_area + side_area

    def get_volume(self):
        """Calculate volume of the cylinder"""
        return super().get_area() * self.height

if __name__ == "__main__":
    cylinder = Cylinder(3, 7)

    print(f"Radius: {cylinder.radius}")
    print(f"Height: {cylinder.height}")
    print(f"Surface Area of Cylinder: {cylinder.get_area():.2f}")
    print(f"Volume of Cylinder: {cylinder.get_volume():.2f}")
