import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useNavigate, useParams } from "react-router-dom";

import { Button, Table } from "react-bootstrap";
import Userlist from "./Userlist";

export default function Home() {
  
  const navigate = useNavigate();
  const [trekList, settrekList] = useState([]);

    
  
 const {id}  = useParams();

  useEffect(() => {
    loadtrek();
  }, []);

  const loadtrek = async () => {
    const result = await axios.get("http://localhost:8080/api/showtreks");
    settrekList(result.data);
    console.log(id);
  };

  const DeleteTrek = async (id) => {
    await axios.delete(`http://localhost:8080/api/delete/${id}`);
    loadtrek();
  };
 
 


  return (
    <>
      

      <br></br>
      <Button href="/customers"> customer list</Button>
      <Button href="/userlist">User List</Button>
      <Table striped bordered hover variant="dark">
        <thead>
          <tr>
            <th>#</th>
            <th>Title</th>
            <th>Location</th>
            <th>Description</th>
            <th>price</th>
            <th>imgUrl</th>
            <th>imgUrl1</th>
            <th>imgUrl2</th>
            <th>imgUrl3</th>
            <th>imgUrl4</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          
            {
              trekList.map(
                treks =>
                  <tr key={treks.id}>
                    <td>{treks.id}</td>
                    <td>{treks.name}</td>
                    <td>{treks.location}</td>
                    <td>{treks.descrip}</td>
                    <td>{treks.price}</td>
                    <td>{treks.imgUrl}</td>
                    <td>{treks.imgUrl1}</td>
                    <td>{treks.imgUrl2}</td>
                    <td>{treks.imgUrl3}</td>
                    <td>{treks.imgUrl4}</td>
                    <td>
                    <Link
                    className="btn btn-outline-primary mx-2"
                    to={`/edittrek/${treks.id}`}
                  >
                    Edit
                  </Link>
                  <Button
                    className="btn btn-danger mx-2"
                    onClick={() => DeleteTrek(treks.id)}
                  >
                    Delete
                  </Button>   
                  <Link
                    className="btn btn-outline-primary mx-2"
                    to={`/trekBookings/${treks.id}`}
                  >
                    Booking
                  </Link>
                   
                  
                   </td>
                  </tr>
              )
            }
          

        </tbody>
      </Table>

    </>
  );
}
