import React, { Component } from 'react';
import { connect } from 'react-redux';
import Aux from '../../hoc/aux/Aux';
import Burger from '../../components/burger/Burger';
import BuildControls from '../../components/burger/buildcontrols/BuildControls';
import Modal from '../../components/ui/modal/Modal';
import OrderSummary from  '../../components/burger/ordersummary/OrderSummary';
import Spinner from '../../components/ui/spinner/Spinner';
import withErrorHandeler from '../../hoc/witherrorhandeller/WithErrorHandeller';
import * as actions from '../../store/actions/Index';
import axios from '../../Axios-Orders';

export class BurgerBuilder extends Component
{
  state ={
    purchasing:false
  }

  componentDidMount()
  {
    console.log(this.props);
    this.props.onInitIngredients();

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
    if(this.props.isAuthenticated){
        this.setState({purchasing:true});
    }
    else {
      this.props.onSetAuthRedirectPath('/checkout');
      this.props.history.push('/auth');
    }
  }
  purchaseCancelHandeler=()=>{
    this.setState({purchasing:false});
  }

  purchaseContinueHandeler=() =>
  {
    this.props.onInitPurchase();
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
    let burger=this.props.error ? <p>Ingedients can't be loaded</p>:<Spinner/>
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
          isAuth={this.props.isAuthenticated}
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
    ings:state.burgerBuilder.ingredent,
    price:state.burgerBuilder.totalPrice,
    error:state.burgerBuilder.error,
    isAuthenticated:state.auth.token!==null
  };
}
const mapDispatchToProps=dispatch=>{
  return{
    onIngredentAdded:(ingName)=>dispatch(actions.addIngredent(ingName)),
    onIngredentRemoved:(ingName)=>dispatch(actions.removeIngredent(ingName)),
    onInitIngredients:()=>dispatch(actions.initIngredent()),
    onInitPurchase:()=>dispatch(actions.purchaseInit()),
    onSetAuthRedirectPath:(path)=>(actions.setAuthRedirectPath(path))
  };
}
 export default connect (mapStateToProps,mapDispatchToProps)(withErrorHandeler(BurgerBuilder,axios));
