import React, { Component } from 'react';
import classes from './App.css';
import Person from './Person/Person';

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
    let persons=null;
    let btnClasses=[classes.Button];
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
      btnClasses.push(classes.Red);
    }
    const assignedclasses=[];
    if(this.state.persons.length<=2)
    {
      assignedclasses.push('red');
    }
    if(this.state.persons.length<=1)
    {
      assignedclasses.push(classes.bold);
    }
   return (
      <div className={classes.App}>
  <h1>Hi I am react developer</h1>
   <p className={assignedclasses.join(' ')}>This is really working!</p>
   <button className={btnClasses.join(' ')}
   onClick={this.togglePersonsHandler}>Switch Button</button>
   {persons}
      </div>
    );
  }
}



//here join' ' like this becuse it requires something to pass as classes is a empty array'
export default App;
