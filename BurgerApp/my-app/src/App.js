import React, { Component } from 'react';
import { Route,Switch,withRouter,Redirect } from 'react-router-dom';
import { connect } from 'react-redux';
import asyncComponent from './hoc/asyncComponent/AsyncComponent';
import Layout from './hoc/layout/Layout';
import BurgerBuilder from './containers/burgerbuilder/BurgerBuilder';
import Logout from './containers/auth/logout/Logout';
import * as actions from './store/actions/Index';

const asyncCheckout=asyncComponent(()=>{
  return import ('./containers/checkout/Checkout');
});

const asyncOrder=asyncComponent(()=>{
  return import ('./containers/orders/Orders');
});

const asyncAuth=asyncComponent(()=>{
  return import ('./containers/auth/Auth');
});

class App extends Component {
  componentDidMount () {
    this.props.onTryAutoSignup();
  }

  render () {
    let routes = (
      <Switch>
        <Route path="/auth" component={asyncAuth} />
        <Route path="/" exact component={BurgerBuilder} />
        <Redirect to="/" />
      </Switch>
    );

    if ( this.props.isAuthenticated ) {
      routes = (
        <Switch>
          <Route path="/checkout" component={asyncCheckout} />
          <Route path="/orders" component={asyncOrder} />
          <Route path="/logout" component={Logout} />
          <Route path="/auth" component={asyncAuth} />
          <Route path="/" exact component={BurgerBuilder} />
          <Redirect to="/" />
        </Switch>
      );
    }

    return (
      <div>
        <Layout>
          {routes}
        </Layout>
      </div>
    );
  }
}

const mapStateToProps = state => {
  return {
    isAuthenticated: state.auth.token !== null
  };
};

const mapDispatchToProps = dispatch => {
  return {
    onTryAutoSignup: () => dispatch( actions.authCheckState() )
  };
};

export default withRouter( connect( mapStateToProps, mapDispatchToProps )( App ) );
