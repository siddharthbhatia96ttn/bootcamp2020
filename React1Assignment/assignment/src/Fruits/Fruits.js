import React from 'react';

const Fruits=( props ) =>{
  return(
    <div className="Fruits">
              <tr>
              <td>{props.name}</td>
              <td>{props.quantity}</td>
              <td onClick={props.click}>Delete</td>
              </tr>
    </div>
  )
}

export default Fruits;
