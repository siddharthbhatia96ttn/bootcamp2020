//Q-4
const user = {
firstName: "Sahil",
lastName: "Dua",
Address: {
Line1: "address line 1",
Line2: "address line 2",
State: "Delhi",
Pin: 110085,
Country: "India",
City: "New Delhi",
},
phoneNo: 9999999999
}

let addLine1=user.Address.Line1;
let addLine2=user.Address.Line2;
let addState=user.Address.State;
let addPin=user.Address.Pin;
let addCountry=user.Address.Country;
let addCity=user.Address.City;

export { addLine1,addLine2,addState,addPin,addCountry,addCity };
