import React, { Component } from 'react';
import './App.css';
import Person from './Person/Person';
import styled from 'styled-components';

const StyledButton=styled.button`
background-color:${props => props.alt ? 'red' : 'green'};
color:white;
font:inherit;
border:1px solid blue;
padding:8px;
cursor:pointer;

&:hover {
  backgroundColor:${props => props.alt ? 'salmon' : 'lightgreen'};
  color:black;
}
`;

class App extends Component {

  state={//property
    persons:[//arrrays
      {id:1,name:'Max',age:28},
      {id:2,name:'Manu',age:29},
      {id:3,name:'Stephanie',age:26}
    ]
  }
  nameChangedHander=(event,id)=>{
    const personIndex=this.state.persons.findIndex(p=>{
      return p.id===id;
    });
    const person=
{
    ...this.state.persons[personIndex]
  };

const persons=[...this.state.persons];
persons[personIndex]=person;
  person.name=event.target.value;
    this.setState({persons:persons});
  }
  deletePersonHandler=(personIndex) => {
  //  const person=this.state.persons.slice();
  //  const persons=this.state.persons;
  const person=[...this.state.persons];
    person.splice(personIndex,1);
    this.setState({persons:person})
  }
  togglePersonsHandler=()=>{
    const doesShow=this.state.showPersons;
    this.setState({showPersons:!doesShow});
  }
  render() {
    const stylo={
      backgroundColor:'green',
      color:'white',
      font:'inherit',
      border:'1px solid blue',
      padding:'8px',
      cursor:'pointer',
      ':hover':{
        backgroundColor:'lightgreen',
        color:'black'
      }
    };
    let persons=null;
    if(this.state.showPersons){
    persons= (
   <div>
   {this.state.persons.map((person, index) => {
     return <Person
     clicker={() => this.deletePersonHandler(index)}
     name={person.name}
     age={person.age}
     key={person.id}
     changed={(event)=>this.nameChangedHander(event,person.id)}/>
   })}
       </div>
      );
        /*  stylo.backgroundColor='red';
          stylo[':hover']={
            backgroundColor:'salmon',
            color:'black'
          }*/
    }
    const classes=[];
    if(this.state.persons.length<=2)
    {
      classes.push('red');
    }
    if(this.state.persons.length<=1)
    {
      classes.push('bold');
    }
   return (
      <div className="App">
  <h1>Hi I am react developer</h1>
   <p className={classes.join(' ')}>This is really working!</p>
   <StyledButton alt={this.state.showPersons}
   onClick={this.togglePersonsHandler}>Switch Button</StyledButton>
   {persons}
      </div>
    );
  }
}



//here join' ' like this becuse it requires something to pass as classes is a empty array'
export default App;
