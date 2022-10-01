//rfce (rafce=const) + enter
//<div> </div> retorna um elenmento na tela // fragment <> </> pode colocar mais de um componente na tela
// let nome = 'Pamela'
// <h1>{nome}</h1>
// function Home() {
//   return (
//     <>
//     <h1 className="titulo">Donuts</h1>
//     <img src= "https://cdn.pixabay.com/photo/2022/08/31/10/17/donuts-7422971_960_720.jpg" alt="Imagem Donuts-png" className="img1"/>
//     </>
//   );
// }
// export default Home;


import React from 'react';
import './Home.css';
import {Typography, Grid, Button} from '@material-ui/core';
import './Home.css';
import { Box } from '@mui/material';


function Home() {
  return (
      <>
          <Grid container direction="row" justifyContent="center" alignItems="center" style={{ backgroundColor: "black" }}>
              <Grid alignItems="center" item xs={6}>
                  <Box paddingX={20} >
                      <Typography variant="h3" gutterBottom color="textPrimary" component="h3" align="center" style={{ color: "white", fontWeight: "bold" }}>Welcome</Typography>
                      <Typography variant="h5" gutterBottom color="textPrimary" component="h5" align="center" style={{ color: "white", fontWeight: "bold" }}> to the dark side!</Typography>
                  </Box>
                  <Box display="flex" justifyContent="center">
                      <Box marginRight={1}>
                      </Box>
                      <Button variant="outlined" style={{ borderColor: "white", backgroundColor: "red", color: "white" }}>Ver Postagens</Button>
                  </Box>
              </Grid>
              <Grid item xs={6} >
                  <img src="https://cdn.pixabay.com/photo/2022/08/31/10/17/donuts-7422971_960_720.jpg" alt="Imagem Donuts-png" className="img1"width="700px" height="500px" />
              </Grid>
              <Grid xs={12} style={{ backgroundColor: "black" }}>
              </Grid>
          </Grid>
      </>
  );
}

export default Home;