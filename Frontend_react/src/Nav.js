import React from 'react';
import PropTypes from 'prop-types';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';
import App from './App';
import {useState,useEffect} from 'react';
import './App.css';
import axios from 'axios';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import Toolbar from '@material-ui/core/Toolbar';

function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      className="center"
      role="tabpanel"
      hidden={value !== index}
      id={`wrapped-tabpanel-${index}`}
      aria-labelledby={`wrapped-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box p={3}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

TabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.any.isRequired,
  value: PropTypes.any.isRequired,
};

function a11yProps(index) {
  return {
    id: `wrapped-tab-${index}`,
    'aria-controls': `wrapped-tabpanel-${index}`,
  };
}

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.paper,
  },
    table: {
      minWidth: 650,
    },
    title: {
      flexGrow: 1,
    },
}));

export default function TabsWrappedLabel() {
  const [checked,setChecked]=useState([]);
  const classes = useStyles();
  const [value, setValue] = React.useState('one');

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const fetchChecked=()=>{
    axios.get("http://localhost:8080/api/v1/restaurant/checked")
    .then(resp=>{
      setChecked(resp.data)
      console.log(resp.data)
    })
  };

  useEffect(()=>{ 
    fetchChecked();
    
  },[]);

  return (
    <div className={classes.root}>
      <AppBar position="static">
        <Tabs value={value} onChange={handleChange} aria-label="wrapped label tabs example">
          <Tab
            value="one"
            label="Restaurants"
            wrapped
            {...a11yProps('one')}
          />
          <Tab value="two" label="Visited Restaurants" {...a11yProps('two')} />
        </Tabs>
      </AppBar>
      <TabPanel value={value} index="one">
        <App/>
      </TabPanel>
      <TabPanel value={value} index="two">

      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" className={classes.title}>
            Visited Restaurants
            </Typography>
            </Toolbar>
            </AppBar>

    <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="simple table">
        <TableHead>
          <TableRow>
          <TableCell></TableCell>
          <TableCell></TableCell>
          <TableCell></TableCell>

            <TableCell>Name</TableCell>
            <TableCell align="right">Visit Date</TableCell>

            <TableCell></TableCell>
             <TableCell></TableCell> 
             <TableCell></TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {checked.map((check)=>
           <TableRow key={check.id} >
              <TableCell align="right"></TableCell>
              <TableCell align="right"></TableCell>
              <TableCell align="right"></TableCell>
           <TableCell component="th" scope="row">
            {check.name}
           </TableCell>
           <TableCell align="right">{check.Checked_at}</TableCell>
           <TableCell align="right"></TableCell>
           <TableCell align="right"></TableCell>
           <TableCell align="right"></TableCell>
         </TableRow>
          
          )}
           
        </TableBody>
      </Table>
    </TableContainer>

      </TabPanel>
    </div>
  );
}
