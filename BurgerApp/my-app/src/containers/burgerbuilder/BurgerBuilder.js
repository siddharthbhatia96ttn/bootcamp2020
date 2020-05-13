import React, { Component } from 'react';
import { connect } from 'react-redux';
import Aux from '../../hoc/aux/Aux';
import Burger from '../../components/burger/Burger';
import BuildControls from '../../components/burger/buildcontrols/BuildControls';
import Modal from '../../components/ui/modal/Modal';
import OrderSummary from  '../../components/burger/ordersummary/OrderSummary';
import Spinner from '../../components/ui/spinner/Spinner';
import withErrorHandeler from '../../hoc/witherrorhandeller/WithErrorHandeller';
import axios from '../../Axios-Orders';
import * as actionTypes from '../../store/actions'


class BurgerBuilder extends Component
{
  state ={
    purchasing:false,
    loading:false,
    error:false
  }

  componentDidMount()
  {
    console.log(this.props);
  /*  axios.get('https://react-my-burger-91338.firebaseio.com/ingredients.json')
    .then(response=>{
      this.setState({ingredent:response.data});
    })
    .catch(error=>{
      this.setState({error:true})
    });*/
  }

  updatePurchaseState(ingredent)
  {
    const sum=Object.keys(ingredent)
    .map(igKey =>{
      return ingredent[igKey];
    })
    .reduce((sum,el)=>{
      return sum+el;
    },0);
    return sum>0;
  }

  purchaseHandeler = () => {
    this.setState({purchasing:true});
  }
  purchaseCancelHandeler=()=>{
    this.setState({purchasing:false});
  }

  purchaseContinueHandeler=() =>
  {
this.props.history.push('/checkout');
  }

  render(){
    const disabledInfo={
      ...this.props.ings
    };
    for(let key in disabledInfo)
    {
      disabledInfo[key]=disabledInfo[key]<=0
    }
    let orderSummary=null;
    let burger=this.state.error ? <p>Ingedients can't be loaded</p>:<Spinner/>
    if(this.props.ings){
      burger=(
          <Aux>
          <Burger ingredent={this.props.ings}/>
          <BuildControls
          ingredentAdded={this.props.onIngredentAdded}
          ingredentRemoved={this.props.onIngredentRemoved}
          disabled={disabledInfo}
          purchasable={this.updatePurchaseState(this.props.ings)}
          ordered={this.purchaseHandeler}
          price={this.props.price}
          />
          </Aux>
        );
        orderSummary=<OrderSummary ingredent={this.props.ings}
            price={this.props.price}
            purchasedCanceled={this.purchaseCancelHandeler}
            purchaseContinued={this.purchaseContinueHandeler}/>;
        if(this.state.loading){
          orderSummary=<Spinner/>;
        }
    }
    return(
      <Aux>
      <Modal show={this.state.purchasing} modalClosed={this.purchaseCancelHandeler}>
        {orderSummary}
      </Modal>
      {burger}
      </Aux>
    );
  }
}
const mapStateToProps=state=>{
  return {
    ings:state.ingredent,
    price:state.totalPrice
  };
}
const mapDispatchToProps=dispatch=>{
  return{
    onIngredentAdded:(ingName)=>dispatch({type:actionTypes.ADD_INGREDIENT,ingredentName:ingName}),
    onIngredentRemoved:(ingName)=>dispatch({type:actionTypes.REMOVE_INGREDIENT,ingredentName:ingName}),
  };
}
 export default connect (mapStateToProps,mapDispatchToProps)(withErrorHandeler(BurgerBuilder,axios));
