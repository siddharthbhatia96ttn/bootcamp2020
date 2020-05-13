import React,{ Component } from 'react';
import { Route } from 'react-router-dom';
import CheckoutSummary from '../../components/order/checkoutsummary/CheckoutSummary';
import ContactData from './contactdata/ContactData';
import { connect } from 'react-redux';
class Checkout extends Component{


  checkoutCancelledHandler=()=>{
    this.props.history.goBack();
  }
  checkoutContinuedHandeler=()=>{
    this.props.history.replace('/checkout/contact-data');
  }
  render(){
    return (
      <div>
      <CheckoutSummary ingredent={this.props.ings}
      checkoutCancelled={this.checkoutCancelledHandler}
      checkoutContinued={this.checkoutContinuedHandeler}/>
      <Route
      path={this.props.match.path + '/contact-data'}
      component={ContactData}/>
      </div>
    );
  }

}

const mapStateToProps =state=>{
  return{
    ings:state.ingredent
  }

};

export default connect (mapStateToProps)(Checkout);
