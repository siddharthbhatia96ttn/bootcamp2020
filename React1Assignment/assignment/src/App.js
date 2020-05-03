import React, { Component } from 'react';
import './App.css';
import Fruits from './Fruits/Fruits.js'
import './Fruits/Fruits.css'

class App extends Component
{
  state={
      fruits:[
        {name:"Mango",quantity:20}
      ]
};
addFruitHandler= () => {
  let newItem=document.getElementById("item").value;
  const [fruitName,quantity]=newItem.split("-");

  const newFruits=[...this.state.fruits];
  newFruits.push({
    name:fruitName,
    quantity:quantity
  })

  this.setState({fruits:newFruits})
  document.getElementById("item").value="";
};
onPressEnter=(event)=>{
  if(event.key==="Enter")
  {
    this.addFruitHandler();
  }
}
deleteFruitsHandler=(fruitsIndex) =>
{
  const deleteFruits=[...this.state.fruits];
  deleteFruits.splice(fruitsIndex,1);
  this.setState({fruits:deleteFruits});
}
  render() {
    return (
      <div className="App">
      <h3>Enter fruits with quantity</h3>
<input type="text" id="item" placeholder="Fruit-Quantity" onKeyPress={this.onPressEnter}></input>
      <button
   onClick={this.addFruitHandler}
   onKeyPress={this.onPressEnter}>Submit Button</button>
   <table>
   {
     this.state.fruits.map((index)=>{
       return <Fruits name={index.name}
       quantity={index.quantity}
       click={(()=>this.deleteFruitsHandler(index))}/>
     })
  }
   </table>
      </div>
    );
  }
}

export default App;
