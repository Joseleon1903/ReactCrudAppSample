import React, { useState, useEffect } from 'react';
import './Home.css';
import axios from 'axios';
export default function Home() {

    const [schools, setSchools] = useState([]);


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

  return (
    <div>
        <h1>Home</h1>
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
                      <button class="btn btn-edit">Edit</button>
                      <button class="btn btn-view">Show</button>
                    </td>
                  </tr>

              ))

            }
          </tbody>
        </table>
    </div>
  );
}