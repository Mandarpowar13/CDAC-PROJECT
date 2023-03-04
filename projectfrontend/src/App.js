import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Dashboard from "./components/customer_component/Dashboard";
import TrekDetails from "./components/customer_component/TrekDetails";

import Login from "./components/Login";
import Navbar from "./components/navbar/Navbar";
import Signup from "./components/SignUp"
import AddTrek from "./components/treks/AddTrek";
import EditTrek from "./components/treks/EditTrek";
import BookingByTrek from "./components/usercomponent/BookingByTrek";
import BookingsByUser from "./components/usercomponent/BookingsByUser";
import Customerlist from "./components/usercomponent/Customerlist";
import EditUser from "./components/usercomponent/EditUser";
import Home from "./components/usercomponent/Home";
import Userlist from "./components/usercomponent/Userlist";

import logo from './logo.svg';



function App() {
  return (
    <div className="App">
      
      
      <Router>
        <Navbar/>

        <Routes>
          <Route excat path="/adminLogin"element={<Login></Login>}/>
          <Route exact path = "/" element={<Dashboard/>}/>
          <Route exact path="/home/:id" element={<Home />} />
          <Route excat path="/trekdetsils/:id"element={TrekDetails} ></Route>
          <Route exact path="/customers" element={<Customerlist />} />
          <Route exact path="/signup"element={<Signup></Signup>}/>
          <Route exact path="/addtrek" element={<AddTrek />} />
          <Route exact path="/edittrek/:id" element={<EditTrek />} />
          <Route exact path="/userlist" element = {<Userlist></Userlist>}/>
          <Route exact path="/useredit/:id" element={<EditUser></EditUser>}/>
          <Route exact path="/trekBookings/:id" element={<BookingByTrek></BookingByTrek>}/>
          <Route exact path="/customerBookings/:id" element={<BookingsByUser></BookingsByUser>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
