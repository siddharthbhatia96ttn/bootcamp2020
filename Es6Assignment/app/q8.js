// Q8. Import a module containing the constants and method for calculating area of circle, rectangle, cylinder.

const areaCircle=(radius)=>{
    const pi=3.14;
    let area=pi*(radius*radius);
    return `area of circle with radius ${radius} is ${area}`
}

const areaRectangle=(length,breadth)=>{
    return ` area of rectangle with length ${length} and breadth ${breadth} is ${length*breadth}`
}

const areaCylinder=(radius,height)=>{
    const pi=3.14;
    let area=(2*pi*radius*height)+(2*pi*radius*radius);
    return `area of cylinder with radius ${radius} and height ${height} is ${area}`
}

export{areaCircle,areaCylinder,areaRectangle};
