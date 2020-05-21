import React,{ Component } from 'react';
import Aux from '../../../hoc/aux/Aux';
import Button from '../../ui/button/Button';

class OrderSummary extends Component{
  componentDidUpdate()
  {
    console.log('[OrderSummary]Did Update');
  }
render()
{
  const ingredientSummary=Object.keys(this.props.ingredent)
  .map(igKey => {
    return(
      <li key={igKey}>
      <span style={{textTransform:'capitalize'}}>{igKey}</span>:{this.props.ingredent[igKey]}
      </li>
    );
  });
  return(    <Aux>
      <h3>Your Order</h3>
      <p>A delecious burger with the following ingredents</p>
      <ul>
      {ingredientSummary}
      </ul>
      <p><strong>Total Price:{this.props.price}</strong></p>
      <p>Continue to Checkout?</p>
      <Button btnType="Danger" clicked={this.props.purchasedCanceled}>CANCEL</Button>
      <Button btnType="Success" clicked={this.props.purchaseContinued}>CONTINUE</Button>
      </Aux>);
     }
}

export default OrderSummary;
