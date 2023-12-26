import React from "react";
import './Navbar.css';

export default function Navbar() {
  return (
    <nav className="navbar">
    <div className="container">
      <a className="navbar-brand" to="/">School App</a>
      <input type="checkbox" id="nav-toggle" className="nav-toggle" />
      <ul className="navbar-nav">
        <li className="nav-item">
          <a className="nav-link" to="/">View School</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" to="/servicios">Add School</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" to="/productos">Modify School</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" to="/contacto">Delete School</a>
        </li>
      </ul>
    </div>
  </nav>
  );
}