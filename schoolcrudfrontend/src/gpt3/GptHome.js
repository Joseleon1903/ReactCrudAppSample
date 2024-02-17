import React, { useState, useEffect } from 'react';
import { Link , useNavigate} from 'react-router-dom';
import './GptHome.css';
import './index.css';

import { Blog, Footer, Features, Possibility, WhatGpt3, Header } from '../containers';
import { Cta, Navbar, Brand } from '../components';


export default function GptHome() {



    return (

      <div className='App'>
        <div className='gradient__bg'>

          <Navbar></Navbar>

          <Header></Header>

        </div>

        <Brand></Brand>

        <WhatGpt3></WhatGpt3>

        <Features></Features>

        <Possibility></Possibility>

        <Cta></Cta>

        <Blog></Blog>

        <Footer></Footer>

      </div>
      
      ); 


}