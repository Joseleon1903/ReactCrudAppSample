import logo from './logo.svg';
import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../node_modules/bootstrap/dist/js/bootstrap.js"
import Navbar from './layout/Navbar.js'
import Home from './layout/Home.js'
import AddSchool from './School/AddSchool.js'

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";


function App() {
  return (
    <div className="App">

      <Router>

      <Navbar></Navbar>

      <Routes>
        <Route exact path="/" element={<Home/>}></Route>
        <Route exact path="/AddSchool" element={<AddSchool/>}></Route>

      </Routes>


      </Router>
     


    </div>
  );
}

export default App;
