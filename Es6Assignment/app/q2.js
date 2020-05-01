var videoNames = new Array();
//a. Select all the list items on the page and convert to array.
let liList = document.getElementById("List").getElementsByTagName("li");
for (var i = 0; i < liList.length; i++) {
    videoNames.push(liList[i].innerHTML);
}

// b. Filter for only the elements that contain the word 'flexbox'"
var flexBoxArray=videoNames.filter((a)=>a.toLowerCase().includes("flexbox"));

// c. Map down to a list of time strings
let arrayTime=new Array();
for(var i=0;i<liList.length;i++)
{
    arrayTime.push(liList[i].getAttribute("data-time"));
}

// d. Map to an array of seconds
let arraySecond = new Array();
arraySecond = arrayTime.map((a) => a.split(":")).map((a) => ((a[0] * 60) + (a[1])));


// e. Reduce to get total using .filter and .map
let totalTime;
totalTime=arraySecond.reduce((accumulator,currentValue)=>accumulator+currentValue);


export {videoNames,flexBoxArray,arrayTime,arraySecond,totalTime};
