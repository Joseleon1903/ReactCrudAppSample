import logo from './logo.svg';
import './App.css';
import Navbar from './layout/Navbar.js';
import Home from './layout/Home.js';
import AddSchool from './School/AddSchool.js';
import ModifySchool from './School/ModifySchool.js';
import ShowSchool from './School/ShowSchool.js';

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";


function App() {
  return (
    <div className="App">

      <Router>

      <Navbar></Navbar>

      <Routes>
        <Route exact path="/" element={<Home/>}></Route>
        <Route exact path="/ShowSchool" element={<ShowSchool/>} ></Route>
        <Route exact path="/AddSchool" element={<AddSchool/>}></Route>
        <Route exact path="/ModifySchool/:schoolId" element={<ModifySchool/>} ></Route>
      </Routes>


      </Router>
     


    </div>
  );
}

export default App;
