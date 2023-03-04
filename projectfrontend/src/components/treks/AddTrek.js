import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddTrek() {
  let navigate = useNavigate();

  const [trek, setUser] = useState({
        name:"",
        location :"",
        descrip :"", 
        price :"",
        imgUrl :"",
        imgUrl1 :"",
        imgUrl2 :"",
        imgUrl3 :"",
        imgUrl4 :"",
  });

  const { name, location,descrip,price,imgUrl,imgUrl1,imgUrl2,imgUrl3,imgUrl4 } = trek;

  const onInputChange = (e) => {
    setUser({ ...trek, [e.target.name]: e.target.value });
  };

  const onSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/api/addtrek", trek);
    navigate("/home/:id");
  };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Register User</h2>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="mb-3">
              <label htmlFor="Name" className="form-label">
                Title
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter Title"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Location" className="form-label">
                Location
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter Location"
                name="location"
                value={location}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="textnox" className="form-label">
               Description
              </label>
              <textarea class="form-control"
                rows="5"
                type="text"
                className="form-control"
                placeholder="Enter Description"
                name="descrip"
                value={descrip}
                
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="textnox" className="form-label">
                Price
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter Image Url"
                name="price"
                value={price}
                onChange={(e) => onInputChange(e)}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="textnox" className="form-label">
                Image imgUrl
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter Image Url"
                name="imgUrl"
                value={imgUrl}
                onChange={(e) => onInputChange(e)}
              />
            </div>


          

            <div className="mb-3">
              <label htmlFor="textnox" className="form-label">
                Image imgUrl1
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter Image Url"
                name="imgUrl1"
                value={imgUrl1}
                onChange={(e) => onInputChange(e)}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="textnox" className="form-label">
                Image imgUrl2
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter Image Url"
                name="imgUrl2"
                value={imgUrl2}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="textnox" className="form-label">
                Image imgUrl3
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter Image Url"
                name="imgUrl3"
                value={imgUrl3}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="textnox" className="form-label">
                Image imgUrl4
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter Image Url"
                name="imgUrl4"
                value={imgUrl4}
                onChange={(e) => onInputChange(e)}
              />
            </div>

            
            <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
            <Link className="btn btn-outline-danger mx-2" to="/">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
  );
}
