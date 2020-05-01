class Grandparent
{
  constructor(name,height)
  {
    this.name=name;
    this.height=height;
  }
  display()
  {
      return `Hello this is ${this.name} from granparent class my age is ${this.height}`;
  }
  static granParent()
  {
    console.log("This is Grandparent class static function");
  }
}
class Parent extends Grandparent
{
  constructor(name,height,color)
  {
    super(name,height);
    this.color=color;
  }
  display()
  {
      return `Hello this is ${this.name} from parent class my age is ${this.height} and my color is ${this.color}`;
  }
  static parents()
  {
    console.log("This is Parent class static function");
  }
}

class Child extends Parent
{
  constructor(name,height,color,age)
  {
    super(name,height,color);
    this.age=age;
  }
  display()
  {
      return `Hello this is ${this.name} from child class my age is ${this.height},my color is ${this.color} and my age is ${this.age}`;
  }
  static granChild()
  {
    console.log("This is child class static function");
  }
}

export { Grandparent,Parent,Child };
