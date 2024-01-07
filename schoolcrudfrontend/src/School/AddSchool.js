import './AddSchool.css';
import axios from 'axios'
import React, { useState } from 'react';
import { Link , useNavigate} from 'react-router-dom';


export default function AddSchool() {

  let navigate = useNavigate();

  const [school, setSchool] = useState({
    name : "",
    language :  "",
    address : "",
    foundationDate : "",
  });

  const { name, language, address, foundationDate } = school;

  const onInputChange = (e) => {
    setSchool({ ...school, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/api/school", school);
    console.log("send post request....");
    navigate("/ShowSchool");
    
  };

  return (
    <div id="form-layout">
     
          <form onSubmit={(e) => onSubmit(e)}  >
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Name"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="language" className="form-label">
                Language
              </label>
              <select value={language} name='language' onChange={(e) => onInputChange(e)} required>
                <option value="">Shoose one</option>
                <option value="English">English</option>
                <option value="Spanish">Spanish</option>
                <option value="Mandarin">Mandarin</option>
              </select>
            </div>

            <div className="mb-3">
              <label htmlFor="address" className="form-label">
                Address
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Address"
                name="address"
                value={address}
                onChange={(e) => onInputChange(e)}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="foundationDate">Foundation Date:</label>
              <input type={"date"} value={foundationDate} id="foundationDate" placeholder="Foundation Date" name="foundationDate" onChange={(e) => onInputChange(e)} required />
            </div>
            
            <button type="submit" className="btn btn-view">
              Submit
            </button>
            <Link className="btn btn-delete" to="/">
              Cancel
            </Link>
          </form>
    </div>
  );


}