//Q1. Given this array: `[3,62,234,7,23,74,23,76,92]`, Using arrow function, create an array of the numbers greater than `70`.
function q1(numbers)
{
  let orignalNumber=numbers;
  let numbersGreater=orignalNumber.filter((num)=>num>70);
  console.log("Numbers greater than 70 are: "+numbersGreater);
}

export { q1 };
