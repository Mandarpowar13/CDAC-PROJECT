


import React, { useState } from "react";
import axios from "axios";
import {  Link, useNavigate } from "react-router-dom";
import { Button,Form } from "react-bootstrap";


export default function Login() {
	const navigate = useNavigate();
	var [id, setid] = useState({
		userid:''
	});
	
	const [values, setValues] = useState({
		email: "",
		pass: "",
		showPass: false,
	});

	var userId = id.userid;


	const handleSubmit = (e) => {
		e.preventDefault();
		console.log(values.pass);
		console.log(values.email);
		axios
			.post("http://localhost:8080/api/users/login", {
				email: values.email,
				password: values.pass
			})
			.then((res) => {

				console.log(res.data);
				if(res.data ==="SUCCESS"){
					
					axios.get(`http://localhost:8080/api/usersByemail/${values.email}`).then((res)=>{
						console.log(res.data);
						if(res.data.email === values.email){
							setid = res.data.id;
							console.log(res.data.id);
						navigate(`/home/${res.data.id}`);
						}else{
							console.log("didint navigate");
						}
						
					})
					
				}
				else{
					console.log("login failed")
					navigate("/")
					
				}
				
			})
			.catch((err) => console.error(err));

	};
	const handlePassVisibilty = () => {
		setValues({
			...values,
			showPass: !values.showPass,
		});
	};

	return (
		<div>


			<Form onSubmit={handleSubmit}>
				<Form.Group className="mb-3" controlId="formBasicEmail">
					<Form.Label>Email address</Form.Label>
					<Form.Control type="email" placeholder="Enter email" onChange={(e) => setValues({ ...values, email: e.target.value })} />
					<Form.Text className="text-muted">
						We'll never share your email with anyone else.
					</Form.Text>
				</Form.Group>

				<Form.Group className="mb-3" controlId="formBasicPassword">
					<Form.Label>Password</Form.Label>
					<Form.Control type="password" placeholder="Password" onChange={(e) => setValues({ ...values, pass: e.target.value })} />
				</Form.Group>
				
				<Form.Group className="mb-3" controlId="formBasicCheckbox">
					<Form.Check type="checkbox" label="Check me out" />
				</Form.Group>
				<Button variant="primary" type="submit">
					Submit
				</Button>
				<Link to={"/signup"}>Register/signup</Link>

			</Form>
		</div>
	);
}
