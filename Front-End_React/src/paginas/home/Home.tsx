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

// import React from "react";
import { Box, Button, Grid, Typography } from '@mui/material';
import React from 'react';
import "./Home.css";

// import purple from '@material-ui/core/colors/purple';

// const roxin = purple[500]


function Home() {
  return (
    <>
      <Grid container direction="row" justifyContent="center" alignItems="center" style={{ backgroundColor: "#3F51B5" }}>
        <Grid alignItems="center" item xs={6}>
          <Box paddingX={20} >
            <Typography variant="h3" gutterBottom color="textPrimary" component="h3" align="center" style={{ color: "white", fontWeight: "bold" }}>Seja bem vindo(a)!</Typography>
            <Typography variant="h5" gutterBottom color="textPrimary" component="h5" align="center" style={{ color: "white", fontWeight: "bold" }}>expresse aqui os seus pensamentos e opiniões!</Typography>
          </Box>
          <Box display="flex" justifyContent="center">
            <Box marginRight={1}>
            </Box>
            <Button variant="outlined" style={{ borderColor: "white", backgroundColor: "#3F51B5", color: "white" }}>Ver Postagens</Button>
          </Box>
        </Grid>
        <Grid item xs={6} >
          <img src="https://i.imgur.com/H88yIo2.png" alt="" width="500px" height="500px" />
        </Grid>
        <Grid xs={12} style={{ backgroundColor: "white" }}>
        </Grid>
      </Grid>
    </>
  );
}

export default Home;