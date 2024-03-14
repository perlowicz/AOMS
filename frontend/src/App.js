import './App.css';
import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import AddInvoice from "./pages/AddInvoice";
import CompanyProfile from "./pages/CompanyProfile";
import Registration from "./pages/Registration";
import Users from "./pages/Users";

function App() {
  return (
      <BrowserRouter>
          <Routes>
              <Route path="/" element=<Home/>/>
              <Route path="/add-invoice" element=<AddInvoice/>/>
              <Route path="/profile" element=<CompanyProfile/>/>
              <Route path="/register" element=<Registration/>/>
              <Route path="/users" element=<Users/>/>
          </Routes>
      </BrowserRouter>
  );
}

export default App;
