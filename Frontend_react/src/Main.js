import React from "react";
import Nav from "./Nav";
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
  


function Main(){	

  return (
   
    <Router>
      <main>
        <Switch>
          <Route path="/"  render={() => (
                <Nav/>
            )} />
        </Switch>
        </main>
        </Router>
  )
}

export default Main;
