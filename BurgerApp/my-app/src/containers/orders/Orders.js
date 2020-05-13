import React, {Component} from 'react';
import axios from '../../Axios-Orders';
import Order from '../../components/order/Order';
import withErrorHandler from '../../hoc/witherrorhandeller/WithErrorHandeller';

class Orders extends Component{
  state={
    orders:[],
    loading:true
  }
  componentDidMount(){
    axios.get('/orders.json')
    .then(res=>{
      const fetchedOrders=[];
      console.log("Hello"+res.data);//for checking receieved data
    for(let key in res.data){
      fetchedOrders.push({
        ...res.data[key],
        id:key
      });
    }
      this.setState({loading:false,orders:fetchedOrders});
    })
    .catch(err=>{
      this.setState({loading:false});
    });
  }
render(){
  return(
    <div>
    {this.state.orders.map(order=>(
      <Order
      key={order.id}
      ingredent={order.ingredent}
      price={order.price}
      />
    ))}
    </div>
  );
}
}

export default withErrorHandler(Orders,axios);
