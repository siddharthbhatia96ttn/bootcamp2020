import { q1 } from './q1'
import { output } from './q3'
import { addLine1,addLine2,addState,addPin,addCountry,addCity } from './q4'
import { Grandparent,Parent,Child } from './q6'
import { areaCircle, areaCylinder, areaRectangle } from './q8'
import { q9 } from './q9'


//Q-1
console.log("answer of Q-1");
let numbers = [3, 62, 234, 7, 23, 74, 23, 76, 92];
 q1(numbers);


//Q-4
console.log("answer of Q-4");
console.log(addLine1);
console.log(addLine2);
console.log(addState);
console.log(addPin);
console.log(addCountry);
console.log(addCity);

//Q-4(ii)
console.log("answer of Q-4(ii)");
let values=[1,1,2,3,4,4,5,6,6,7,8,8,9];
let uniqueNumber=new Set(values);

console.log(uniqueNumber);

//Q-6,Q-7
console.log("answer of Q-6,Q-7");
Child.granChild();
let ObjChild=new Child("Siddharth","168","Brown","23");
console.log(ObjChild.display());

//Q-8
console.log("answer of Q-8");
console.log(areaCircle(10));
console.log(areaRectangle(10, 20));
console.log(areaCylinder(10, 20));

//Q-9
console.log("answer of Q-9");
let digits = [21,21,22,23,23,45,45,67,67,89];
 q9(digits);

 //q-10
 console.log("answer of Q-10");
 let nestedArray=["one",["two",2],"three",["four",4]];
 let flatArrays = nestedArray.reduce((a, b) => a.concat(b), []);
 console.log(nestedArray);
 console.log(`flattered to ${flatArrays}`);

//Q-12
console.log("answer of Q-12");
let numArr=[[1,'one'],[2,'two'],[3,'three']];
let valMap=new Map(numArr);

for(let [key,value] of valMap.entries())
{
  console.log(`${key} points to ${value}`);
}
