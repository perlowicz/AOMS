import './App.css';
import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import AddInvoice from "./pages/AddInvoice";
import CompanyProfile from "./pages/CompanyProfile";
import Registration from "./pages/Registration";
import Invoices from "./pages/Invoices";
import Login from "./pages/Login";
import Navbar from "./components/navigation/Navbar";
import ProtectedRoute from "./components/ProtectedRoute";

function App() {

    const [user, setUser] = React.useState(null);


  return (
      <BrowserRouter>
          <Navbar/>
          <Routes>
              <Route path="/" element=<Home/>/>
              <Route path="/add-invoice" element=<AddInvoice/>/>
              <Route path="/invoices" element=<Invoices/>/>
              <Route path="/profile" element=<CompanyProfile/>/>
              <Route path="/register" element=<Registration/>/>
              <Route path="/login" element=<Login/>/>
          </Routes>
      </BrowserRouter>
  );
}

export default App;
