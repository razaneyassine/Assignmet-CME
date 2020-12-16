import React,{useState,useEffect} from 'react';
import './App.css';
import axios from 'axios';
import OutlinedCard from './Card';
import Grid from '@material-ui/core/Grid';
import {  makeStyles } from '@material-ui/core/styles';
import Snackbar from '@material-ui/core/Snackbar';
import Pagination from "./Pagination";
import { CircularProgress, FormControl, InputLabel, MenuItem ,Select} from '@material-ui/core';
import { Alert } from '@material-ui/lab';



const useStyles = makeStyles (theme=>({
 gridContainer:{
   paddingLeft: '150px',
   paddingRight: '20px',
 },

 padding:{
   paddingLeft:"20px"
 },
 formControl:{
    minWidth:200
 }

}));

const Restaurants=()=>{
  const [restaurants,setRestaurants]=useState([]);
  const [categories,setCategories]=useState([]);

  const [search,setInput]=useState("");
  const [filter,setFilter]=useState("");
  const [open, setOpen] = React.useState(false);






const handleChange=(e)=>{
  setFilter(e.target.value)
  console.log(filter);

if(filter != ""){
  axios.get('http://localhost:8080/api/v1/restaurant/filter/'+filter).then(resp=>{
    setRestaurants(resp.data);
    console.log(resp);
   })
}
   
};




const handleSearchChange=(e)=>{
  const s= e.target.value;
  s.toUpperCase()
  console.log(s);
  setInput(s);

}

const handleSubmit=(e)=>{
 e.preventDefault();
 if(search ===""){
 
  const handleClose = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }

    setOpen(false);
  };

  return (
    <Snackbar open={open} autoHideDuration={6000} onClose={handleClose}>
    <Alert onClose={handleClose} severity="success">
      This is a success message!
    </Alert>
  </Snackbar>
  ); 
 }
 else{
  axios.get(`http://localhost:8080/api/v1/restaurant/search/${search}`).then(resp=>{
    setRestaurants(resp.data);
    console.log(resp);
   })
 }

};

const options = categories.map((option) => {
  const firstLetter = option.name[0].toUpperCase();
  return {
    firstLetter: /[0-9]/.test(firstLetter) ? '0-9' : firstLetter,
    ...option,
  };
});



  const classes=useStyles();


  const fetchRestaurants=()=>{
    axios.get("http://localhost:8080/api/v1/restaurant")
    .then(resp=>{
      console.log(resp.data);
      setRestaurants(resp.data);
    })
  };

  const fetchCategories=()=>{
    axios.get("http://localhost:8080/api/v1/restaurant/categories")
    .then(resp=>{
      setCategories(resp.data)
    })
  };




  useEffect(()=>{ 
    fetchRestaurants();
    fetchCategories();
    console.log(filter);
 
    
  },[]);

    //paginate
    const [currentRest,setCurrentRest]=useState(1);
    const [restPerPage,serestPerPage]=useState(4);
    const indexOfLast=currentRest * restPerPage;
    const indexofFirst=indexOfLast - restPerPage;
    const current= restaurants.slice(indexofFirst,indexOfLast);

    const paginate=(pageNumber)=> setCurrentRest(pageNumber)
  
    return (
     <>
     <div className="center" >
          <nav className="navbar navbar-light bg-light">
         <form className="form-inline" onSubmit={handleSubmit}>
          <input className="form-control mr-sm-4 col-md-auto" type="search" placeholder="Search" aria-label="Search" onChange={handleSearchChange}/>

          <FormControl className={classes.formControl}>
         <InputLabel>Types</InputLabel>
         <Select onChange={handleChange}>
            {categories.map((option)=>
            <MenuItem key={option.id} value={option.name}>{option.name}</MenuItem>
            )}
         </Select>
       </FormControl>
         
          <button className="btn btn-outline-warning my-2 my-sm-0  col-md-auto" type="submit">Search</button>
        </form>



      </nav>
      </div>
      <br></br>
      {current ? (
        <div>
           <Grid container spacing={4} className={classes.gridContainer}>
           {current.map((restaurant)=>
  
             <Grid item xs={12} sm={6} key={restaurant.id} >
             <OutlinedCard data={restaurant} />
           </Grid>
           )}
        </Grid>
            <br></br>
        <Pagination restPerPage={restPerPage} total={restaurants.length} paginate={paginate} />
        </div>
      ) : (
        <CircularProgress/>
      )}
         
    </>
      
    );
 
  }





function App() {
  return (
    <div className="App">
   <Restaurants/>
    </div>
  );
}

export default App;
