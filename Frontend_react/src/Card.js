import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Typography from '@material-ui/core/Typography';
import axios from "axios";
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import Checked from "./Checked";
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import r1 from './r1.svg'



const useStyles = makeStyles((theme)=>({
  root: {
    maxWidth: 345,
    // backgroundColor:theme.palette.info.light,
  },
  media: {
    height: 140,
  },
  paper: {
    height: 200,
    width: 200,
  },
  control: {
    padding: theme.spacing(2),
  },
  dialog1: {
    flexGrow: 1,
  },
}));


export default function OutlinedCard(props) {
const classes = useStyles();
const [spacing, setSpacing] = React.useState(2);

// const id=props.data.id;

// const [checked, setChecked] = React.useState(true);

 console.log(props.data.path)

  //dialog
  const [open, setOpen] = React.useState(false);
  const [scroll, setScroll] = React.useState('paper');
  const [category,setCategory]=React.useState("");

  const handleClickOpen = (scrollType) => () => {
    setOpen(true);
    setScroll(scrollType);
  };

  const handleClose = () => {
    setOpen(false);
  };
 

  const descriptionElementRef = React.useRef(null);

  const fetchCategory=()=>{
    axios.get(`http://localhost:8080/api/v1/restaurant/${props.data.category}`)
    .then(resp=>{
      setCategory(resp.data)
    })
  };



  React.useEffect(() => {

    fetchCategory();
    if (open) {
      const { current: descriptionElement } = descriptionElementRef;
      if (descriptionElement !== null) {
        descriptionElement.focus();
      }
    }
  }, [open]);



  return (
    <>
   
    <Card className={classes.root}  >
      <CardActionArea onClick={handleClickOpen('paper')}>
        <CardMedia
          className={classes.media}
          image={"http://127.0.0.1:5500/"+ props.data.path}
          title="Contemplative Reptile"
        />
        <CardContent>
        </CardContent>
      </CardActionArea>
      <CardActions>
      <Typography gutterBottom variant="h5" component="h2">
            {props.data.name}
          </Typography>
          <Checked id={props.data.id} check={props.data.Checked}/>
      </CardActions>
    </Card>
            <Dialog
        open={open}
        onClose={handleClose}
        scroll={scroll}
        aria-labelledby="scroll-dialog-title"
        aria-describedby="scroll-dialog-description"
        className={classes.dialog1}
        >
        <DialogTitle id="scroll-dialog-title">{props.data.name}</DialogTitle>
        <DialogContent dividers={scroll === 'paper'}>
          
        <Grid container className={classes.root} spacing={2}>
      <Grid item xs={12}>
        <Grid container justify="center" spacing={spacing}>

          <DialogContentText
            id="scroll-dialog-description"
            ref={descriptionElementRef}
            tabIndex={-1}
          >
          <Grid item>
              <Paper className={classes.paper} >
              <CardMedia
                  className={classes.media}
                  image={"http://127.0.0.1:5500/"+ props.data.path}
                  title="Contemplative Reptile"
                />
              </Paper>
          </Grid>
          <Grid item>
              <Paper className={classes.paper} >
              Type:{category.name}
              <br></br>
              Average Cost for two:{props.data.average}
              <br></br>
              Address:{props.data.address}
              <br></br>
              Phone Number:{props.data.phoneNumber}
              </Paper>
          </Grid>
       
        </DialogContentText>
            </Grid>
          </Grid>
        
        </Grid>
        </DialogContent>


        <DialogActions>
          <Button onClick={handleClose} color="primary">
            Cancel
          </Button>
          
        </DialogActions>
        </Dialog>
    </>
  );
}