import './App.css';
import React, {useState} from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Home from "./pages/Home";
import AddInvoice from "./pages/AddInvoice";
import CompanyProfile from "./pages/CompanyProfile";
import Registration from "./pages/Registration";
import Invoices from "./pages/Invoices";
import Login from "./pages/Login";
import Navbar from "./components/navigation/Navbar";
import ProtectedRoute from "./components/ProtectedRoute";
import {AuthProvider} from "./components/AuthContext";

function App() {
    return (
        <AuthProvider>
            <BrowserRouter>
                <Navbar/>
                <Routes>
                    <Route path="/" element=<Home/>/>
                    <Route path="/add-invoice" element=<AddInvoice/>/>
                    <Route path="/invoices" element=<Invoices/>/>
                    <Route path="/profile" element=<CompanyProfile/>/>
                    <Route path="/register" element=<Registration/>/>
                    <Route path="/login" element=<Login/>/>
                    <Route path="/logout" element=<Home/>/>
                </Routes>
            </BrowserRouter>
        </AuthProvider>
    );
}

export default App;
