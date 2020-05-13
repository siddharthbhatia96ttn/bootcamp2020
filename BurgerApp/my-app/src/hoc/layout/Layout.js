import React,{ Component } from 'react';
import classes from './Layout.module.css';
import Toolbar from '../../components/navigation/toolbar/Toolbar';
import Aux from '../aux/Aux';
import SideDrawer from '../../components/navigation/sidedrawer/SideDrawer';

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
          <Toolbar drawerToggleClicked={this.sideDrawerToggleHandeler}/>
          <SideDrawer
          open={this.state.showSideDrawer}
          closed={this.sideDrawerClosedHandeler}/>

          <main className={classes.Content}>
          {this.props.children}
          </main>
          </Aux>
    );
  }
}

export default Layout;
