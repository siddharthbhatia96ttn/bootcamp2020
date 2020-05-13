import * as actionTypes from './actions';

const initialState={
  ingredent:{
    salad:0,
    bacon:0,
    cheese:0,
    meat:0
  },
  totalPrice:40
};

const ingredentPrice={
  salad:5,
  cheese:4,
  meat:10,
  bacon:7
};
const reducer=(state=initialState,action)=>{
  switch( action.type ){
    case actionTypes.ADD_INGREDIENT:
    return{
      ...state,
      ingredent:{
        ...state.ingredent,
        [action.ingredentName]:state.ingredent[action.ingredentName]+1
      },
      totalPrice:state.totalPrice+ingredentPrice[action.ingredentName]
    };
    case actionTypes.REMOVE_INGREDIENT:
    return{
      ...state,
      ingredent:{
        ...state.ingredent,
        [action.ingredentName]:state.ingredent[action.ingredentName]-1
      },
        totalPrice:state.totalPrice-ingredentPrice[action.ingredentName]
    };
    default:
    return state;
  }
};

export default reducer;
