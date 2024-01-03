import React from "react";
import './Navbar.css';
import { Link } from 'react-router-dom';

export default function Navbar() {
  return (
    <nav className="navbar">
    <div className="container">
      <a className="navbar-brand" to="/">School App</a>
      <input type="checkbox" id="nav-toggle" className="nav-toggle" />
      <ul className="navbar-nav">
        <li className="nav-item">
          <Link className="nav-link" to="/AddSchool">Create School</Link>
        </li>
      </ul>
    </div>
  </nav>
  );
}