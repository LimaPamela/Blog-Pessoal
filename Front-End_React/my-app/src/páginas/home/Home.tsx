//rfce (rafce=const) + enter
//<div> </div> retorna um elenmento na tela // fragment <> </> pode colocar mais de um componente na tela

import React from 'react'
import './Home.css'
// let nome = 'Pamela'
// <h1>{nome}</h1>
function Home() {
  return (
    <>
    <h1 className="titulo">Donuts</h1>
    <img src= "https://cdn.pixabay.com/photo/2022/08/31/10/17/donuts-7422971_960_720.jpg" alt="Imagem Donuts-png" className="img1"/>
    </>
  );
}

export default Home;