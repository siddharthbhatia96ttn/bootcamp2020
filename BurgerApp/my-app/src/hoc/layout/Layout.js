import React,{ Component } from 'react';
import classes from './Layout.module.css';
import Toolbar from '../../components/navigation/toolbar/Toolbar';
import Aux from '../aux/Aux';
import SideDrawer from '../../components/navigation/sidedrawer/SideDrawer';
import { connect } from 'react-redux';

class Layout extends Component {
  state={
    showSideDrawer:false
  }
  sideDrawerToggleHandeler =() =>
  {
    this.setState((prevState)=>{
      return {showSideDrawer:!prevState.showSideDrawer};
    });
  }
  sideDrawerClosedHandeler = () => {
    this.setState({showSideDrawer:false});
  }
  render () {
    return (
          <Aux>
          <Toolbar
          isAuth={this.props.isAutheticated}
          drawerToggleClicked={this.sideDrawerToggleHandeler}/>
          <SideDrawer
          isAuth={this.props.isAuthenticated}
          open={this.state.showSideDrawer}
          closed={this.sideDrawerClosedHandeler}/>

          <main className={classes.Content}>
          {this.props.children}
          </main>
          </Aux>
    );
  }
}

const mapStateToProps=state=>{
return{
isAutheticated:state.auth.token!==null
};
};

export default connect (mapStateToProps)(Layout);
