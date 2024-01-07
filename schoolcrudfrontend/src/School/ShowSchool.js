import './ShowSchool.css';
import '../style/templatemo-comparto.css';
import React, { useState, useEffect } from 'react';
import { Link , useNavigate} from 'react-router-dom';
import axios from 'axios';

export default function ModifySchool() {
    const [schools, setSchools] = useState([]);

    let navigate = useNavigate();

    useEffect(()=>{
        console.log("Entering in use effect");
        loadSchools();

    }, []);


    const loadSchools= async()=>{
      const result = await axios.get("http://localhost:8080/api/school");
      console.log(result);
      setSchools(result.data);
    }

    const deleteSchool = async (id) => {
      await axios.delete(`http://localhost:8080/api/school?id=${id}`);
      loadSchools();
    };

    const navigateTo = async (root) => {
      console.log("Navigate to edit")
      navigate(root);
    };

  return (
    <div>

        <div className="section-bg tm-gallery-header ">
            <h2 className="tm-mb-1"><Link to="/">Home</Link></h2>
           
             <Link className="btn-group btn btn-view add-school" to="/AddSchool">Create School</Link>
               
        </div>
        <table>
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Language</th>
              <th>Address</th>
              <th>Foundation Date</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {
              schools.map((school) =>(

                  <tr>
                    <td key={school.id}> {school.id}</td>
                    <td>{school.name}</td>
                    <td>{school.language}</td>
                    <td>{school.address}</td>
                    <td>{school.foundationDate}</td>
                    <td class="btn-group">
                      <button class="btn btn-delete" onClick={() => deleteSchool(school.id)}>Delete</button>
                      <button class="btn btn-edit" onClick={() => navigateTo('/ModifySchool/'+school.id)}>Edit</button>
                    </td>
                  </tr>
              ))

            }
          </tbody>
        </table>
    </div>
  );
}