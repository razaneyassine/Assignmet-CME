import React from "react";
import axios from "axios";
import Checkbox from '@material-ui/core/Checkbox';


const handleTrue=(id)=>{
 
    axios.put(`http://localhost:8080/api/v1/restaurant/true/${id}`)
    .then(resp=>{
    })
  };
  

  const handleFalse=(id)=>{
    
    axios.put(`http://localhost:8080/api/v1/restaurant/false/${id}`)
    .then(resp=>{
    })
  };



const Checked = ({id,check})=>{

    if(check===false){
        return(
            <Checkbox color="primary"  onChange={handleTrue(id)}  />
            // <form onSubmit={handleSubmitTrue(id)}>
            //   <button className="btn btn-outline-primary my-2 my-sm-0  col-md-auto" type="submit" >Check</button>
            // </form>
        )
    }
    else{
        return(
            <Checkbox defaultChecked color="primary" onChange={handleFalse(id)}  />
        //     <form onSubmit={handleSubmitFalse(id)}>
        //     <button className="btn btn-outline-primary my-2 my-sm-0  col-md-auto" type="submit" >UnCheck</button>
        //   </form>
        )
    }
  
}

export default Checked