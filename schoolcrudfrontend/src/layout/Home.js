import React, { useState, useEffect } from 'react';
import { Link , useNavigate} from 'react-router-dom';
import './Home.css';
import schoolImageSrc from '../images/school/school-card-img-1.jpg';
import gptImageSrc from '../images/school/gpt_3.jpg';

export default function Home() {

   
  return (
    <div class="main-page" >

      <header>
          <h1>Dashboard</h1>
          <nav>
            <ul>
              <li><a href="#">Inicio</a></li>
              <li><a href="#">Estadísticas</a></li>
              <li><a href="#">Configuración</a></li>
            </ul>
          </nav>
        </header>
        
        <main>
          {/* <aside>
            <h2>Menú</h2>
            <ul>
              <li><a href="#">Opción 1</a></li>
              <li><a href="#">Opción 2</a></li>
              <li><a href="#">Opción 3</a></li>
              <li><a href="#">Opción 4</a></li>
            </ul>
          </aside> */}
          
          <section class="content">
            <div class="cards">
              <div class="card">
                <h3>School</h3>
                <img className='card-image' src={schoolImageSrc} alt="Error Loading" />
                <br></br>
                <Link className="btn btn-view" to="/ShowSchool">
                  Go to School Crud
                </Link>
              </div>

              <div class="card">
                <h3>Gpt - 3 </h3>
                <img className='card-image' src={gptImageSrc} alt="Error Loading" />
                <br></br>
                <Link className="btn btn-view" to="/Gpt3">
                  Go to Gpt 3
                </Link>
              </div>

            </div>
          </section>
        </main>
        
        <footer>
          <p>Footer - Información de contacto</p>
        </footer>
       
    </div>
  );
}