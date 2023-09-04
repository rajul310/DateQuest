import React, { useState } from 'react';
import './App.css';
import Login from './components/Login';
import Navbar from './components/Navbar';
import { UserContext } from './components/UserContext';
import RegistrationForm from './components/RegistrationForm';
import UserRegistration from './components/UserRegistration';
import AdminRegistration from './components/VendorRegistration';
import Packages from './components/Packages'; // Import the Packages component
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import AboutUs from './components/AboutUs.js';
import VendorRegistration from './components/VendorRegistration';

function App() {
  const [user, setUser] = useState(JSON.parse(localStorage.getItem('user')));

  // Mock package data
  const mockPackages = [
    {
      imageUrl: 'https://img.freepik.com/free-photo/front-view-woman-man-restaurant_23-2148395456.jpg?w=900&t=st=1693338215~exp=1693338815~hmac=5b3d2ff8f2b91789058442775819d8992f61d5c2d37cc0c9b8da4abd4c1c430b',
      pName: 'Happy Hour Party',
      pDate: '2023-12-21',
      startAt: '09:45:00 AM',
      endAt: '13:30:00 PM',
      location: 'Kothrud,Pune',
      activities: 'COFFEE_DATE',

    },
    // Add more package objects here
  ];

  return (
    <div className="App">
      <Router>
        <UserContext.Provider value={{ user, setUser }}>
          <Navbar />
          <Switch>
            <Route exact path="/login" component={Login} />
            <Route exact path="/register" component={RegistrationForm} />
            <Route exact path="/user-register" component={UserRegistration} />
            <Route exact path="/vendor-register" component={VendorRegistration} />
            <Route exact path="/about" component={AboutUs}></Route>
            <Route exact path="/packages">
              <Packages packages={mockPackages} />
            </Route>
            
          </Switch>
        </UserContext.Provider>
      </Router>
    </div>
  );
}

export default App;
