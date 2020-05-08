import React from 'react';
import styled from 'styled-components';
//import './Person.css';
const StyleDiv=styled.div`
width:60%;
margin:16px auto;
border:1px solid #eee;
box-shadow:0 2px 3px #ccc;
padding:16px;
text-align: center;
}
@media (min-width: 500px)':{
  width:'450px
}
`;
const person=( props ) => {
  const stylus={
    '@media (min-width: 500px)':{
      width:'450px'
    }
  }
  return (
//  <div className="Person" style={stylus}>
<StyleDiv>
   <p onClick={props.clicker}>I'm {props.name} and I am {props.age}years old!</p>
  <p>{props.children}</p>
  <input type="text" onChange={props.changed} value={props.name}/>
</StyleDiv>
)
};
export default person;
